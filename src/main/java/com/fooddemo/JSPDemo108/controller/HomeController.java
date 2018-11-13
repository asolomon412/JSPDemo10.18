package com.fooddemo.JSPDemo108.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fooddemo.JSPDemo108.Food;
import com.fooddemo.JSPDemo108.FoodService;

//@Controller
public class HomeController {
	
	@Autowired
	FoodService foodService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index", "hello", "Hey ya'll!");
	}
	
	@RequestMapping("/food")
	public ModelAndView listFood(@RequestParam(value="category", required=false) String category) {
		ModelAndView mv = new ModelAndView("list-food");
		if(category != null && !category.isEmpty()) {
			mv.addObject("food",foodService.getFoodsInCategory(category));
			mv.addObject("category", category);
		} else {
			mv.addObject("food", foodService.getAllFoods());
		}
		
		return mv;
	}
	
	@RequestMapping("add-food") 
	// String methods used in the controller for a request mapping are used to show the view
	public String addStuff() {
		return "food-form"; // the return should match the view name (jsp)
	}
	
	@PostMapping(value="newfood")
	public ModelAndView newFood(Food newFood) {
		foodService.addFood(newFood);
		return new ModelAndView("redirect:/food");
	}
}
