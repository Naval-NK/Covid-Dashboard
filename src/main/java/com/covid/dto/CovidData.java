package com.covid.dto;

import org.springframework.stereotype.Component;

@Component
public class CovidData {
	
	 public String country;
	 public String country_abbreviation;
	 public String total_cases;
	 public String new_cases;
	 public String total_deaths;
	 public String new_deaths;
	 public String total_recovered;
	 public String active_cases;
	 public String serious_critical;
	 public String cases_per_mill_pop;
	 public String flag;
	 
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_abbreviation() {
		return country_abbreviation;
	}
	public void setCountry_abbreviation(String country_abbreviation) {
		this.country_abbreviation = country_abbreviation;
	}
	public String getTotal_cases() {
		return total_cases;
	}
	public void setTotal_cases(String total_cases) {
		this.total_cases = total_cases;
	}
	public String getNew_cases() {
		return new_cases;
	}
	public void setNew_cases(String new_cases) {
		this.new_cases = new_cases;
	}
	public String getTotal_deaths() {
		return total_deaths;
	}
	public void setTotal_deaths(String total_deaths) {
		this.total_deaths = total_deaths;
	}
	public String getNew_deaths() {
		return new_deaths;
	}
	public void setNew_deaths(String new_deaths) {
		this.new_deaths = new_deaths;
	}
	public String getTotal_recovered() {
		return total_recovered;
	}
	public void setTotal_recovered(String total_recovered) {
		this.total_recovered = total_recovered;
	}
	public String getActive_cases() {
		return active_cases;
	}
	public void setActive_cases(String active_cases) {
		this.active_cases = active_cases;
	}
	public String getSerious_critical() {
		return serious_critical;
	}
	public void setSerious_critical(String serious_critical) {
		this.serious_critical = serious_critical;
	}
	public String getCases_per_mill_pop() {
		return cases_per_mill_pop;
	}
	public void setCases_per_mill_pop(String cases_per_mill_pop) {
		this.cases_per_mill_pop = cases_per_mill_pop;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	@Override
	public String toString() {
		return "CovidData [\ncountry=" + country + ", \ncountry_abbreviation=" + country_abbreviation + ", \ntotal_cases="
				+ total_cases + ", \nnew_cases=" + new_cases + ", \ntotal_deaths=" + total_deaths + ",\nnew_deaths="
				+ new_deaths + ",total_recovered=" + total_recovered + ", \nactive_cases=" + active_cases
				+ ", \nserious_critical=" + serious_critical + ", \ncases_per_mill_pop=" + cases_per_mill_pop + ", \nflag="
				+ flag + "\n]";
	}
}

