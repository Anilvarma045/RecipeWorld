package com.RecipeWorld.RecipeWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RecipeWorld.RecipeWorld.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}