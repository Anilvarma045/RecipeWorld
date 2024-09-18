package com.RecipeWorld.RecipeWorld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RecipeWorld.RecipeWorld.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	List<Recipe> findByTitleContainingIgnoreCase(String title);

	
	
	
}
