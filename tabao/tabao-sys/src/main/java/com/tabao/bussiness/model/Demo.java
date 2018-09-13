package com.tabao.bussiness.model;

import com.tabao.core.base.model.BaseModel;

public class Demo extends BaseModel {

	private static final long serialVersionUID = -8739941907283811325L;

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
