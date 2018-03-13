package com.arvind.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.weather.model.Wind;
import com.arvind.weather.service.WeatherService;

@RestController
public class WindController {

	@Autowired
	private WeatherService weatherService;
	
	
	@GetMapping(path="/wind/{zipCode}" )
	public Wind getWind( @PathVariable String zipCode ) {
	
		return weatherService.getWind(zipCode);

	}
	
	
}
