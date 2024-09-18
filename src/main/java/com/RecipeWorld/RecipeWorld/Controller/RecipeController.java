package com.RecipeWorld.RecipeWorld.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeWorld.RecipeWorld.model.Recipe;
import com.RecipeWorld.RecipeWorld.model.User;
import com.RecipeWorld.RecipeWorld.service.RecipeService;
import com.RecipeWorld.RecipeWorld.service.UserService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public Recipe createRecipe(@PathVariable Long userId, @RequestBody
    		Recipe recipe) {
        return recipeService.createRecipe(userId, recipe);
    }
    //update Recipes
    @PutMapping("/api/recipe/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id)throws Exception{
    	
    	Recipe updatedRecipe=recipeService.updateRecipe(recipe,id);
    	return updatedRecipe;
    
    }
 // Get all recipes
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // Get recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get recipes by title (partial search)
    @GetMapping("/search")
    public List<Recipe> getRecipesByTitle(@RequestParam String title) {
        return recipeService.getRecipesByTitle(title);
    }

    // Delete recipe by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        System.out.println("User deleted Successfully");

        return ResponseEntity.ok().build() ;
    }

    // Like a recipe
    @PutMapping("/{id}/user/{userId}")
    public ResponseEntity<Recipe> likeRecipe(@PathVariable Long id, @RequestParam Long userId) {
      Optional<User> user = userService.getUserById(userId);
    	Recipe likedRecipe = recipeService.likeRecipe(id, userId);
        return ResponseEntity.ok(likedRecipe);
    }
}
