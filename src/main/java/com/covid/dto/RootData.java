package com.covid.dto;

import org.springframework.stereotype.Component;

@Component
public class RootData {
	 public JsonData data;
	 public String status;
	 
	public JsonData getData() {
		return data;
	}
	public void setData(JsonData data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
}
