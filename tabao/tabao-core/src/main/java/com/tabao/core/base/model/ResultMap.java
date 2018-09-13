package com.tabao.core.base.model;

import java.io.Serializable;

import com.tabao.core.consts.CommonConst;

public class ResultMap implements Serializable {

	private static final long serialVersionUID = -2026823196318283343L;

    private String msg; // JSON返回消息
    private int code;//返回状态码
    private Object extension;//扩展字段
    private Object data; // 返回对象
    
    public ResultMap() {
    	super();
    }
    
	public ResultMap(String msg, int code, Object extension, Object data) {
		super();
		this.msg = msg;
		this.code = code;
		this.extension = extension;
		this.data = data;
	}
	
	public static ResultMap success(Object data, String msg) {
		return new ResultMap(msg, CommonConst.HTTP_CODE_SUCCESS, null, data);
	}
	
	public static ResultMap success(Object data) {
		return success(data, null);
	}
	
	public static ResultMap success(String msg) {
		return success(null, msg);
	}
	
	public static ResultMap error(String msg) {
		return new ResultMap(msg, CommonConst.HTTP_CODE_FAIL, null , null);
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getExtension() {
		return extension;
	}
	public void setExtension(Object extension) {
		this.extension = extension;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
}
