package com.coderscampus.Spoonacular;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;
@Service
public class Spoonacular {
	RestTemplate rt = new RestTemplate();
	
	public ResponseEntity<DayResponse> callDay(String numCalories,String diet, String exclusions) {	
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate?timeFrame=day")
				.queryParam("timeFrame", "day")
				.queryParam("apiKey", "c4172d94931c4091bac85408ce66ee1f");
			if (numCalories !=null) {
				uriBuilder.queryParam("targetCalories", numCalories);
			}
			if(diet != null) {
				uriBuilder.queryParam("diet", diet);
			}
			if(exclusions !=null) {
				uriBuilder.queryParam("exclude", exclusions);
			}
			URI uri = uriBuilder.build().toUri();
				
				
					
		ResponseEntity<DayResponse> dayResponse = rt.getForEntity(uri, DayResponse.class);
		return dayResponse;
		
	}

	public ResponseEntity<WeekResponse> callWeek(String numCalories, String diet, String exclusions) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate?timeFrame=week")
				.queryParam("timeFrame", "week")
				.queryParam("apiKey", "c4172d94931c4091bac85408ce66ee1f");
		if (numCalories !=null) {
			uriBuilder.queryParam("targetCalories", numCalories);
		}
		if(diet != null) {
			uriBuilder.queryParam("diet", diet);
		}
		if(exclusions !=null) {
			uriBuilder.queryParam("exclude", exclusions);
		}
		URI uri = uriBuilder.build().toUri();
				
				
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);
		return weekResponse;
	}

}
