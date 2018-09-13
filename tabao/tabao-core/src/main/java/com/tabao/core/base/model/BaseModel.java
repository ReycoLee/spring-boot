package com.tabao.core.base.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author liqiang
 * @date 2018-09-07
 */
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 8460448711634324463L;
	
	@Transient
	private int pageNum = 1;
	
	@Transient
	private int pageSize = 10;

	@Override
    public String toString(){
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName(), f.get(this));
            }
        }
        catch (Exception e) { // Suppress
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}