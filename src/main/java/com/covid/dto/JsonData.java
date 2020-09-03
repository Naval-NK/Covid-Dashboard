package com.covid.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JsonData {
	public PaginationMeta paginationMeta;
    public String last_update;
    public List<CovidData> rows;
    
	public PaginationMeta getPaginationMeta() {
		return paginationMeta;
	}
	public void setPaginationMeta(PaginationMeta paginationMeta) {
		this.paginationMeta = paginationMeta;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public List<CovidData> getRows() {
		return rows;
	}
	public void setRows(List<CovidData> rows) {
		this.rows = rows;
	}
    
    
}
