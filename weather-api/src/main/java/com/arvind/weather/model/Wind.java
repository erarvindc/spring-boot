package com.arvind.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	public String speed = null;
	@JsonProperty("deg")
	public String direction = null;
	
	public Wind() {
	}
	
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
		
	@Override
	public String toString() {
		return speed + ", " + direction;
	}
	
	
}
