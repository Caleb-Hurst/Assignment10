package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Spoonacular.Spoonacular;
import com.coderscampus.dto.DayResponse;
import com.coderscampus.dto.WeekResponse;

@RestController
public class MealController {
	@Autowired
	Spoonacular spoonacular;
	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(required=false) String numCalories,
			@RequestParam(required=false)String diet,
			@RequestParam(required=false)String exclusions){
		return spoonacular.callWeek(numCalories,diet,exclusions);
	}
	
	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			
			@RequestParam(required=false)  String numCalories, 
			@RequestParam(required=false)  String diet,
			@RequestParam(required=false)  String exclusions){
		
		return spoonacular.callDay(numCalories,diet,exclusions);
	}
}
