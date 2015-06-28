package com.pfe.localisation.json;

import java.io.Serializable;

public class ResponseJson implements Serializable {
    private static final long serialVersionUID = 1513207428686438208L;

	
	  private Boolean success = false;
	  private String info = "";
	  private Object data;
	 
	  public ResponseJson(Boolean status, String errorMessage) {
	    this.success = status;
	    this.info = errorMessage;
	  }
	  
	  public ResponseJson(Boolean status, String errorMessage, Object user) {
		    this.success = status;
		    this.info = errorMessage;
		    this.data= user;
    }

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
}



