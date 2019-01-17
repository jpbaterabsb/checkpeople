package com.checkpeople.dao;

import java.util.Collection;

import com.checkpeople.database.DBSimulator;
import com.checkpeople.exception.IdAlreadyExistsException;
import com.checkpeople.exception.NotFoundException;
import com.checkpeople.model.Developer;
import com.checkpeople.model.ResponseMessage;

public class DeveloperDAO  implements DAO<Developer>{
	private DBSimulator dbSimulator = DBSimulator.getInstance();

	@Override
	public Developer addUser(Developer model) throws IdAlreadyExistsException {
		return (Developer) dbSimulator.insert(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Developer> getUsers() {
		return  (Collection<Developer>) dbSimulator.findAll();
	}

	@Override
	public Developer get(Long id) throws NotFoundException {
		return (Developer) dbSimulator.findById(id);
	}

	@Override
	public Developer editUser(Long id,Developer model) throws NotFoundException {
		
		return (Developer) dbSimulator.update(id,model);
	}

	@Override
	public ResponseMessage deleteUser(Long id) throws NotFoundException {
		return dbSimulator.remove(id);
		
	}
	
	public void generateData() throws Exception {
		dbSimulator.insert(Developer.create(DBSimulator.generateId(),"Caio Bessa", 26, "Java"		,"Software Architect"));
		dbSimulator.insert(Developer.create(DBSimulator.generateId(),"Joao Paulo", 30, "Java"		,"Software Engineer"));
		dbSimulator.insert(Developer.create(DBSimulator.generateId(),"Thiago"	 , 24, "JavaScript" ,"Front-end Architect"));
	}

}
