package com.checkpeople.controller;

import com.checkpeople.dao.DAO;
import com.checkpeople.model.Model;
import com.checkpeople.util.JsonUtils;
import spark.Route;

@SuppressWarnings("rawtypes")
public abstract class Controller<T extends DAO> {
	
	protected T t;
	
	public Controller(T t) {
		this.t = t;

	}
	
	public abstract Class<? extends Model> getType();

	@SuppressWarnings("unchecked")
	public Route add = (req, response) -> {
		return t.addUser(JsonUtils.parserJson(req.body(), getType()));
	};
	
	@SuppressWarnings("unchecked")
	public Route update = (req, response) -> {
		return t.editUser(Long.valueOf(req.params("id")),JsonUtils.parserJson(req.body(), getType()));
	};
	
	public Route delete = (req, response) -> {
		return t.deleteUser(Long.valueOf(req.params("id"))); 
	};
	
	public Route findById = (req, response) -> {
		return t.get(Long.valueOf(req.params("id")));
	};
	
	public Route findAll = (req, response) -> {
		return t.getUsers();
	};
	
}
