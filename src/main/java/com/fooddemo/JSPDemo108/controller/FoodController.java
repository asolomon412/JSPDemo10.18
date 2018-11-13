package com.fooddemo.JSPDemo108.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fooddemo.JSPDemo108.Food;
import com.fooddemo.JSPDemo108.jdbc.FoodJdbcDao;

@Controller
public class FoodController {
	@Autowired
	FoodJdbcDao dao;

	@RequestMapping("/food")
	public ModelAndView listJdbc(@RequestParam(value = "category", required = false) String category) {
		ModelAndView mv = new ModelAndView("list-food");
		if (category != null && !category.isEmpty()) {
			mv.addObject("food", dao.findByCategory(category));
			mv.addObject("category", category);
		} else {
			mv.addObject("food", dao.findAllFoods());
		}

		return mv;
	}

	@RequestMapping("add-food")
	// String methods used in the controller for a request mapping are used to show
	// the view
	public String addStuff() {
		return "food-form"; // the return should match the view name (jsp)
	}

	@PostMapping(value = "newfood")
	public ModelAndView newFood(Food newFood) {
		dao.addFood(newFood.getName(), newFood.getCategory(), newFood.getDescription());
		return new ModelAndView("redirect:/food");
	}

	@RequestMapping(value = "update")
	public ModelAndView updateForm(@RequestParam("id") int id) {
		return new ModelAndView("update-form", "id", id);
	}

	@PostMapping(value = "update-food")
	public ModelAndView updateFood(Food newFood) {
		dao.updateFood(newFood.getId(), newFood.getName(), newFood.getCategory(), newFood.getDescription());
		return new ModelAndView("redirect:/food");
	}

	@RequestMapping(value = "delete")
	public ModelAndView remove(@RequestParam("id") int id) {
		dao.deleteFood(id);
		return new ModelAndView("redirect:/food");
	}
}
