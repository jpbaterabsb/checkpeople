package com.checkpeople;

import static spark.Spark.*;

import com.checkpeople.route.WebRoute;

public class Application {

	public static void main(String[] args) {	
		port(getHerokuAssignedPort()); 
		WebRoute.start();

    }
	
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
