package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.dao.CovidDataDao;
import com.covid.dto.CovidData;
import com.covid.service.ApiService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CovidDataController {
	@Autowired
	ApiService apiService;
	
	@Autowired
	CovidDataDao covidDataDao;
	
	//On call of 8080 post ControllerGetsCalled	
	@GetMapping("/covid-data")
	List<CovidData> callMethod(){
		return apiService.getCovidData();
	}
}
