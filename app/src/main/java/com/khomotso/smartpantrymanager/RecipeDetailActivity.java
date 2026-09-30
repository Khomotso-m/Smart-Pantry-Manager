package com.khomotso.smartpantrymanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.khomotso.smartpantrymanager.data.PantryDatabase;
import com.khomotso.smartpantrymanager.data.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
//toolbar setup
        MaterialToolbar toolbar = findViewById(R.id.toolbarDetail);
        toolbar.setNavigationOnClickListener(v -> finish());

        int recipeId = getIntent().getIntExtra("recipe_id", -1);

        TextView textTitle = findViewById(R.id.textRecipeTitle);
        TextView textIngredients = findViewById(R.id.textIngredients);
        TextView textSteps = findViewById(R.id.textSteps);

        //load the recipe from room
        new Thread(() -> {
            Recipe recipe = PantryDatabase.getInstance(this)
                    .recipeDao()
                    .getRecipeById(recipeId);

            runOnUiThread(() -> {
                if (recipe == null) {
                    textTitle.setText("Recipe not found");
                    return;
                }
                toolbar.setTitle(recipe.getName());
                textTitle.setText(recipe.getName());
                textIngredients.setText(recipe.getIngredients());
                textSteps.setText(recipe.getSteps());
            });
        }).start();
    }
}