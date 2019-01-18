package com.checkpeople.controller;

import com.checkpeople.dao.DeveloperDAO;
import com.checkpeople.model.Developer;

import spark.Route;

public class DeveloperController extends Controller<DeveloperDAO>{

	public DeveloperController(DeveloperDAO t) {
		super(t);
	}
	
	
	public Route start = (req, response) -> {
		t.generateData();
		return findAll.handle(req, response);
	};


	@Override
	public Class<Developer> getType() {

		return Developer.class;
	}
	
	

}
