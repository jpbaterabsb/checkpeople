package com.checkpeople.database;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.checkpeople.exception.IdAlreadyExistsException;
import com.checkpeople.exception.NotFoundException;
import com.checkpeople.model.Model;
import com.checkpeople.model.ResponseMessage;

import java.util.Collection;
import static java.util.Objects.*;

public class DBSimulator {
  
	private static DBSimulator dbSimulator = new DBSimulator();
	private static ConcurrentMap<Long, Model> db;
	private static Long autoIncrement = new Long(0);
  
	public synchronized static DBSimulator getInstance() {
		return  Optional
				.ofNullable(dbSimulator)
				.orElse(new DBSimulator());
	}
	
	private DBSimulator() {
		db = new ConcurrentHashMap<Long, Model>();
		
	}
	
	public synchronized static Long generateId() {
		return ++autoIncrement;
	}
	
	public synchronized Model insert(Model model) throws IdAlreadyExistsException {
		if(db.containsKey(model.getId())) {
			throw new IdAlreadyExistsException();
		}

		Long id = Optional.ofNullable(model.getId()).orElse(generateId());
		db.putIfAbsent(id, model.getObjects());	
		return db.get(model.getId());
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public synchronized DBSimulator remove(Model model) {
		db.remove(db.get(model.getId()));
		return this;
	}
	
	public synchronized ResponseMessage remove(Long id) throws NotFoundException {
		if(nonNull(db.remove(id))){
			return new ResponseMessage("Successfully deleted id: "+id);
		}
		throw new NotFoundException();
	}
	
	public synchronized Model update(Long id,Model model) throws NotFoundException {
		
		if(db.containsKey(id)){
			db.put(model.getId(), model.getObjects());
			return db.get(model.getId());
		}
		throw new NotFoundException();
	}
	
	public synchronized Model findById(Long id) throws NotFoundException {
		return Optional.ofNullable(db.get(id))
				.orElseThrow(NotFoundException::new);
	}
	
	public synchronized Collection<? extends Model> findAll() {
		return db.values();
	}
}
