package com.RecipeWorld.RecipeWorld.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeWorld.RecipeWorld.model.Recipe;
import com.RecipeWorld.RecipeWorld.model.User;
import com.RecipeWorld.RecipeWorld.repository.RecipeRepository;
import com.RecipeWorld.RecipeWorld.repository.UserRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;
 
    User user;
    
    public Recipe createRecipe(Long userId, Recipe recipe) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        recipe.setUser(user);
        recipe.setCreateAt(LocalDateTime.now());
        return recipeRepository.save(recipe);
    }

    // Get all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Get recipe by ID
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    // Get recipes by title (partial search)
    public List<Recipe> getRecipesByTitle(String title) {
        return recipeRepository.findByTitleContainingIgnoreCase(title);
    }

    // Delete recipe by ID
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    // Like a recipe by adding user ID to likes list
    public Recipe likeRecipe(Long recipeId, Long userId) {
//        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
//        if (recipe.getLikes().contains(userId.Id())) {
//            recipe.getLikes().add(userId.userId());
//        }
//        else {
//        	recipe.getLikes().add(userId.getId());
//            
//        }
//        return recipeRepository.save(recipe);
//    }
    	return null; }

	public Recipe updateRecipe(Recipe recipe, Long id) throws RuntimeException {
//		Recipe updatedrecipe = RecipeRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        
//        recipe.setCreateAt(LocalDateTime.now());
//        return recipeRepository.save(recipe);
		
		return null;
	}
    
}
