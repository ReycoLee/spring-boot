package com.tabao.core.base.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *  自动生成主键ID（UUID）的BaseModel
 * @author liqiang
 *
 */
public class GenerateIdModel extends BaseModel {

	private static final long serialVersionUID = -5469757346655329559L;
	
	@Id
	@GeneratedValue(generator="UUID")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
