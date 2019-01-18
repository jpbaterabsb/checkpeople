package com.checkpeople.model;

import java.io.Serializable;

public interface Model extends Serializable {
	Long getId();
	Model getObjects();
}
