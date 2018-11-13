package com.fooddemo.JSPDemo108.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fooddemo.JSPDemo108.Food;

@Repository
public class FoodJdbcDao {

	// we need to use JdbcTemplate to execute a query
	@Autowired // use Spring to autowire it
	JdbcTemplate jdbcTemplate;

	public List<Food> findAllFoods() {
		return jdbcTemplate.query("select * from food", new BeanPropertyRowMapper<Food>(Food.class));
	}
	
	public List<Food> findByCategory(String category) {
		return jdbcTemplate.query("select * from food where category like '%" + category + "%'", new BeanPropertyRowMapper<Food>(Food.class));
	}

	public int addFood(String name, String category, String description) {
		String insertQuery = "INSERT INTO food(name, category, description)" + " values(?,?,?)";
		return jdbcTemplate.update(insertQuery, name, category, description);
	}

	public int updateFood(int id, String name, String category, String description) {

		String updateQuery = "UPDATE food set name=?, category=?, description=? where id = ?";
		return jdbcTemplate.update(updateQuery, name, category, description, id);

	}

	public int deleteFood(int id) {
		String deleteQuery = "delete from food where id = ?";
		return jdbcTemplate.update(deleteQuery, id);

	}
}
