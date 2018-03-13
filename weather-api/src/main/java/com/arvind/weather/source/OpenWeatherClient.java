package com.arvind.weather.source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.arvind.weather.model.WeatherData;
import com.arvind.weather.model.Wind;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class OpenWeatherClient implements WeatherClient {

	public String endpoint = "https://api.openweathermap.org/data/2.5/weather";
	public String apiKey = "0dfe75c71b3a86b22de700eebb334df3";

	public Map<String, Wind> windCache = new ConcurrentHashMap<String, Wind>(); 
	
	public Wind getWindByZipCode( String zipCode ) {

		
		// Look for the object in Cache
		
		Wind cachedWind = windCache.get(zipCode);
		if ( cachedWind != null ) {
			return cachedWind;
		}
		
		Wind wind = null;
		
		try {

			String url = endpoint + "?zip=" + zipCode + "&APPID=" + apiKey;

			HttpURLConnection connection = (HttpURLConnection) new URL( url ).openConnection();
			connection.setRequestMethod( "GET" );
			
			int responseCode = connection.getResponseCode();

			if ( responseCode == 404 ) {
				throw new Exception("OpenWeatherClient.getWindByZip()-Response Code 404");
			}

			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			ObjectMapper mapper = new ObjectMapper();
			WeatherData weatherData = mapper.readValue( response.toString(), WeatherData.class );

			wind = weatherData.getWind();

			windCache.put( zipCode, wind );
			
		} catch (Exception e ) {
			e.printStackTrace();
		}

		return wind;

	}

}
