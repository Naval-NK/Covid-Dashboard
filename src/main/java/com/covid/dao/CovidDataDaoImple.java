package com.covid.dao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.covid.dto.CovidData;
import com.covid.service.ApiService;

@Repository
public class CovidDataDaoImple implements CovidDataDao {

	@Autowired
	ApiService apiService;
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	CovidData covidData;
	
	@Override
	public void updateCovidData(List<CovidData> list) {		
		
		String sql = "update coviddata set country_abbreviation=? ,"
				+ "total_cases=?,new_cases=?,total_deaths=?,new_deaths=?,"
				+ "total_recovered=?,active_cases=?,serious_critical=?,cases_per_mill_pop=?,"
				+ "flag=? WHERE country=?";
		
		int j = 0 ;
		for(int i=0;i<list.size();i++) {
			
		 j = jdbc.update(sql, list.get(i).country,list.get(i).country_abbreviation,
				 Integer.parseInt(list.get(i).total_cases.replaceAll(",","")),
				 list.get(i).new_cases.replaceAll(",",""),
				 Integer.parseInt((list.get(i).total_deaths).replaceAll(",","")),
				 Integer.parseInt((list.get(i).new_deaths).replaceAll(",","")),
				 convertList(list.get(i)),
				 Integer.parseInt((list.get(i).active_cases).replaceAll(",","")),
				 Integer.parseInt((list.get(i).serious_critical).replaceAll(",","")),
				 Float.valueOf(list.get(i).cases_per_mill_pop.replaceAll( ",","")),
				 list.get(i).flag,
				 list.get(i).country
			 );
		}
	}
	
	private Integer convertList(CovidData covidData2) {
		Integer i = 0 ;
		System.out.println("Method called");
		String str = covidData2.total_recovered;
		if(str.contains(",") && str.contains(",") || str.contains(",,")){
			System.out.println("its comma");
			i = Integer.parseInt(str.replaceAll(",",""));
		}else if(str.matches("(a-zA-Z^/)")) {
			System.out.println("its null now");
			i = Integer.parseInt(str.replaceAll("[a-zA-Z^/]",null));
		}
		
		return i;
	}

	public boolean checkTable() {
		boolean exists = false;
		
		String sql = "Select * from coviddata";
	
		List<Map<String,Object>> list = jdbc.queryForList(sql);
		list.isEmpty();
		
		if(!(list.isEmpty())) {
			System.out.println("data in table is present");
			exists = true;
		}else {
			System.out.println("data in table not present");
			exists = false;
		}
		
		return exists;
	}

	public String convertList(String str){
		
		if(str.matches("[,,]")){
			System.out.println("its comma");
			str.replaceAll("[,,]","");
		}else if(str.matches("[a-zA-Z^/]")) {
			System.out.println("its null now");
			str.replaceAll("[a-zA-Z^/]",null);
		}
		
		return str;
	}
	
	@Override
	public int getTotalCases() {
		String sql = "select total_cases from coviddata where country = 'world' ";
		
		int i = jdbc.queryForObject(sql, Integer.class);
		System.out.println("total cases from db -> " + i);
		return i;
	}

}

	