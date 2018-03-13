package com.arvind.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvind.weather.model.Wind;
import com.arvind.weather.source.WeatherClient;

@Service
public class WeatherService {

	@Autowired
	WeatherClient weatherClient;
	
	public WeatherService() {
	}
	
	public Wind getWind( String zipCode ) {
		
		return weatherClient.getWindByZipCode(zipCode);		
	}
	
}
