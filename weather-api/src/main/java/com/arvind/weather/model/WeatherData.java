package com.arvind.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

	public Wind wind;
	
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	@Override
	public String toString() {
		return "WeatherData [wind=" + wind + "]";
	}
	
	
}
