package com.hiringglobal.mobile.dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8686277996220812151L;
	private String status;
	private String message;
	private String url;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
