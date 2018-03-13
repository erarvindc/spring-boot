package com.arvind.weather.source;

import org.springframework.stereotype.Repository;

import com.arvind.weather.model.Wind;

@Repository
public interface WeatherClient {

	public Wind getWindByZipCode( String zipCode );
	
}
