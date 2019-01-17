package com.checkpeople.route;

import static spark.Spark.*;

import static org.eclipse.jetty.http.HttpStatus.*;

import com.checkpeople.controller.DeveloperController;
import com.checkpeople.dao.DeveloperDAO;
import com.checkpeople.exception.DBSimulatorException;
import com.checkpeople.model.ResponseMessage;
import com.checkpeople.util.JsonUtils;

public class WebRoute {

	public static DeveloperController developerController = new DeveloperController(new DeveloperDAO());

	public static void start() {
		before((req, res) -> {
			res.type("application/json");
			res.header("Access-Control-Allow-Headers", "Authorization, Content-Type");
			res.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			res.header("Access-Control-Allow-Origin", "*");
		});

		path("/api", () -> {
			get("/start", developerController.start, JsonUtils::toJson);
			path("/developer", () -> {
				get("", developerController.findAll, JsonUtils::toJson);
				get("/:id/show", developerController.findById, JsonUtils::toJson);
				post("/add", "application/json", developerController.add, JsonUtils::toJson);
				put("/:id/update", developerController.update, JsonUtils::toJson);
				delete("/:id/remove", developerController.delete, JsonUtils::toJson);
			});
		});

		exception(Exception.class, (e, req, res) -> {

			if (e instanceof DBSimulatorException) {
				res.status(BAD_REQUEST_400);
			} else {
				res.status(INTERNAL_SERVER_ERROR_500);
			}

			res.body(JsonUtils.toJson(new ResponseMessage(e)));
		});

	}
}
