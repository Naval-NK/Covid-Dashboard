package com.covid.dao;

import java.util.List;

import com.covid.dto.CovidData;

public interface CovidDataDao {
	void updateCovidData(List<CovidData> list);
	boolean checkTable();
	String convertList(String str);
	int getTotalCases();
}
