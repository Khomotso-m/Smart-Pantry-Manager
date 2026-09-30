package com.khomotso.smartpantrymanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.khomotso.smartpantrymanager.data.PantryDatabase;
import com.khomotso.smartpantrymanager.data.Recipe;
import com.khomotso.smartpantrymanager.data.RecipeDao;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private RecipeAdapter adapter;
    private RecipeDao recipeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
//toolbar
        MaterialToolbar toolbar = findViewById(R.id.toolbarRecipes);
        toolbar.setNavigationOnClickListener(v -> finish());
//database
        recipeDao = PantryDatabase.getInstance(this).recipeDao();
//recyclerview setup
        RecyclerView recyclerView = findViewById(R.id.recyclerRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//creating adapter and define
        adapter = new RecipeAdapter();
        adapter.setOnRecipeClickListener(recipe -> {
            Intent intent = new Intent(this, RecipeDetailActivity.class);
            intent.putExtra("recipe_id", recipe.getId());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        recipeDao.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                adapter.setRecipes(recipes);
            }
        });
    }
}