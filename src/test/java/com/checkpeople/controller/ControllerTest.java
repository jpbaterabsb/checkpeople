package com.checkpeople.controller;

import org.junit.ClassRule;
import com.checkpeople.route.WebRoute;
import static com.checkpeople.util.JsonUtils.*;
import com.despegar.http.client.DeleteMethod;
import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpResponse;
import com.despegar.http.client.PostMethod;
import com.despegar.http.client.PutMethod;
import com.despegar.sparkjava.test.SparkServer;

import spark.servlet.SparkApplication;

public class ControllerTest {
	
	
	@ClassRule
	public static SparkServer<ControllerTest.WebRouteSparkApplication> testServer = new SparkServer<WebRouteSparkApplication>(ControllerTest.WebRouteSparkApplication.class, 4567);

	public HttpResponse get(String path) throws Exception {
		GetMethod get = testServer.get(path, false);
		get.addHeader("Test-Header", "test");
		return testServer.execute(get);
	}
	
	public HttpResponse post(String path, Object o) throws Exception {
		PostMethod post = testServer.post(path,toJson(o), false);
		post.addHeader("Test-Header", "test");
		return testServer.execute(post);
	}
	
	public HttpResponse delete(String path) throws Exception {
		DeleteMethod post = testServer.delete(path, false);
		post.addHeader("Test-Header", "test");
		return testServer.execute(post);
	}
	
	public HttpResponse put(String path, Object o) throws Exception {
		PutMethod post = testServer.put(path, toJson(o), false);
		post.addHeader("Test-Header", "test");
		return testServer.execute(post);
	}
//		assertEquals(200, httpResponse.code());
//		assertEquals("This works!", new String(httpResponse.body()));
//		assertNotNull(testServer.getApplication());
//	}
	
	public static class WebRouteSparkApplication implements SparkApplication {
		@Override
		public void init() {
			WebRoute.start();
		}
	}
	
}
