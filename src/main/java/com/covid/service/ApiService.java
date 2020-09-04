package com.covid.service;

import java.util.List;

import com.covid.dto.CovidData;

public interface ApiService {
//	void checkUpdateDate();
	List<CovidData> getCovidData();
}
