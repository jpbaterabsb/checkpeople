package com.checkpeople.controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.checkpeople.model.Developer;
import com.checkpeople.model.ResponseMessage;
import com.despegar.http.client.HttpResponse;


import static com.checkpeople.util.JsonUtils.*;
import static java.util.Objects.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeveloperControllerTest extends ControllerTest {
	private  Developer developer;
	@Test
	public void test1startDataBase() throws Exception {
	   HttpResponse httpResponse = get("/api/start");
	   Developer[] developers = parserJson(new String(httpResponse.body()), Developer[].class);
	   assertNotNull(developers);
	   assertTrue(developers.length == 3);
	}
	
	@Test
	public void test2addDeveloper() throws Exception {
	   developer = Developer.create(10l, "Diogo", 31, ".NET", "Developer");
	   HttpResponse httpResponse = post("/api/developer/add",developer);
	   Developer dev = parserJson(new String(httpResponse.body()), Developer.class);
	   assertNotNull(dev);
	   assertTrue(nonNull(dev.getId()));
	}
	
	@Test
	public void test3addDeveloperReturnMessage() throws Exception {
	   developer = Developer.create(10l, "Diogo", 31, ".NET", "Developer");
	   HttpResponse httpResponse = post("/api/developer/add",developer);
	   ResponseMessage response = parserJson(new String(httpResponse.body()), ResponseMessage.class);
	   assertNotNull(response);
	   assertTrue(response.getMessage().equals("Id already exists"));
	}
	
	@Test
	public void test4updateDeveloper() throws Exception {
	   developer = Developer.create(10l, "Tadeu", 27, ".NET", "Manager");
	   HttpResponse httpResponse = put("/api/developer/"+developer.getId()+"/update",developer);
	   Developer dev = parserJson(new String(httpResponse.body()), Developer.class);
	   assertNotNull(dev);
	   assertTrue(dev.getId().equals(developer.getId()));
	   assertTrue(dev.getName().equals("Tadeu"));
	   assertTrue(dev.getAge().equals(27));
	   assertTrue(dev.getPosition().equals("Manager"));
	   assertTrue(dev.getLanguage().equals(".NET"));
	}
	
	@Test
	public void test5findById() throws Exception {
	   HttpResponse httpResponse = get("/api/developer/10/show");
	   Developer dev = parserJson(new String(httpResponse.body()), Developer.class);
	   assertNotNull(dev);
	   assertTrue(dev.getId().equals(10l));
	}
	
	@Test
	public void test6findByIdReturnMessage() throws Exception {
	   HttpResponse httpResponse = get("/api/developer/99/show");
	   ResponseMessage response = parserJson(new String(httpResponse.body()), ResponseMessage.class);
	   assertNotNull(response);
	   assertTrue(response.getMessage().equals("register not found"));
	}
	
	@Test
	public void test7findAll() throws Exception {
	   HttpResponse httpResponse = get("/api/developer");
	   Developer[] developers = parserJson(new String(httpResponse.body()), Developer[].class);
	   assertNotNull(developers);
	   assertTrue(developers.length == 4);
	}
	
	@Test
	public void test8removeDeveloper() throws Exception {
	   HttpResponse httpResponse = delete("/api/developer/10/remove");
	   ResponseMessage response = parserJson(new String(httpResponse.body()), ResponseMessage.class);
	   assertNotNull(response);
	   assertTrue(response.getMessage().equals("Successfully deleted id: 10"));
	}
	
	@Test
	public void test9removeDeveloperNotFound() throws Exception {
	   HttpResponse httpResponse = delete("/api/developer/10/remove");
	   ResponseMessage response = parserJson(new String(httpResponse.body()), ResponseMessage.class);
	   assertNotNull(response);
	   assertTrue(response.getMessage().equals("register not found"));
	}

	
}
