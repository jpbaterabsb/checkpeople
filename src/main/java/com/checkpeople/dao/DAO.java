package com.checkpeople.dao;

import java.util.Collection;

import com.checkpeople.exception.IdAlreadyExistsException;
import com.checkpeople.exception.NotFoundException;
import com.checkpeople.model.Model;
import com.checkpeople.model.ResponseMessage;

public interface DAO<T extends Model> {  
	    public T addUser (T model) throws IdAlreadyExistsException;
	     
	    public Collection<T> getUsers ();
	    
	    public T get (Long id) throws NotFoundException;
	     
	    public T editUser (Long id,T model) throws NotFoundException;
	     
	    public ResponseMessage deleteUser (Long id) throws NotFoundException;
	    
}
