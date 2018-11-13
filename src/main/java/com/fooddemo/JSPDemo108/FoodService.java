package com.fooddemo.JSPDemo108;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // this annotation makes that a singleton Spring Bean
// created and managed by Spring
// This is our alternative to a DB for now
public class FoodService {

	private List<Food> list = new ArrayList<>();

	public FoodService() {
		list.add(new Food("Apples", "Fruit", "Sweet and crunchy."));
		list.add(new Food("Carrots", "Vegetable", "Orange root vegtable."));
		list.add(new Food("Peas", "Vegetable", "Small, round, and green."));
		list.add(new Food("Cake", "Prepared", "Fluffy baked good with icing."));
		list.add(new Food("Lemon", "Fruit", "Sour citrus."));
		list.add(new Food("Sandwich", "Prepared", "Versatile staple."));
		list.add(new Food("Blueberry", "Fruit", "Small, round, and blue."));
	}

	public List<Food> getAllFoods() {
		return list;
	}

	// this is a method to do a search by category
	public List<Food> getFoodsInCategory(String category) {
		List<Food> matches = new ArrayList<>();

		for (Food f : list) {
			if(f.getCategory().equalsIgnoreCase(category)) {
				matches.add(f);
			}
		}

		return matches;
	}
	
	// method to add food 
	public void addFood(Food food) {
		list.add(food);
	}

}
