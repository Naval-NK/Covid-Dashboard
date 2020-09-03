package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.dao.CovidDataDao;
import com.covid.dto.CovidData;
import com.covid.dto.RootData;

@Service
public class ApiServiceImple implements ApiService {
	
	@Autowired
	CovidDataDao covidDataDao;
	
	@Override
	public List<CovidData> getCovidData() {
		
		//Getting Response in Json and accessing it with rows Data object
		String url="https://corona-virus-stats.herokuapp.com/api/v1/cases/countries-search";
		RestTemplate restTemplate = new RestTemplate();
		RootData resp = restTemplate.getForObject(url, RootData.class);
		
		//From root to jsonData Access Rows which is List<> of details about Country's
		List<CovidData> list ;

		try {
				list = resp.getData().getRows();
				int cases = Integer.parseInt(list.get(0).total_cases.replaceAll(",", ""));
				Integer db_cases = covidDataDao.getTotalCases();
				
				//If in JSON cases are updated(incremented/decremented)
				//then update the database		
				if(cases!=db_cases) {
					covidDataDao.updateCovidData(resp.getData().getRows());
					System.out.println("Your data has bee Updated");
				}else {
					System.out.println("Your Data Is Upto Date");
          }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			list = resp.getData().getRows();
		}

		return list;
	}

}
