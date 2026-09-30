package com.khomotso.smartpantrymanager.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void insert(Recipe recipe);

    @Query("SELECT * FROM recipes ORDER BY name ASC")
    LiveData<List<Recipe>> getAllRecipes();
    @Query("SELECT * FROM recipes WHERE id = :id LIMIT 1")
    Recipe getRecipeById(int id);

    @Query("SELECT COUNT(*) FROM recipes")
    int getRecipeCount();
}