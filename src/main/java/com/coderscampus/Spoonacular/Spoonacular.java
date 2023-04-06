package com.coderscampus.Spoonacular;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.Week;
import com.coderscampus.dto.WeekResponse;
@Service
public class Spoonacular {
	RestTemplate rt = new RestTemplate();
	
	public ResponseEntity<DayResponse> callDay(String numCalories,String diet, String exclusions) {	
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate?timeFrame=day")
				.queryParam("timeFrame", "day")
				.queryParam("targetCalories", numCalories)
				.queryParam("diet", diet)
				.queryParam("exclude",exclusions)
				.queryParam("apiKey", "c4172d94931c4091bac85408ce66ee1f")
				.build()
				.toUri();
				;	
		ResponseEntity<DayResponse> dayResponse = rt.getForEntity(uri, DayResponse.class);
		return dayResponse;
		
	}

	public ResponseEntity<WeekResponse> callWeek(String numCalories, String diet, String exclusions) {
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate?timeFrame=week")
				.queryParam("timeFrame", "week")
				.queryParam("targetCalories", numCalories)
				.queryParam("diet", diet)
				.queryParam("exclude",exclusions)
				.queryParam("apiKey", "c4172d94931c4091bac85408ce66ee1f")
				.build()
				.toUri();
				;
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);
		return weekResponse;
	}

}
