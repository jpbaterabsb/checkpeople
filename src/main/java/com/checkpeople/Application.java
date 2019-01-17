package com.checkpeople;

import static spark.Spark.*;

import com.checkpeople.route.WebRoute;

public class Application {

	public static void main(String[] args) {	
		port(8085); 
		WebRoute.start();

    }
}
