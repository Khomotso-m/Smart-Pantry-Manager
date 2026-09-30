package com.khomotso.smartpantrymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khomotso.smartpantrymanager.data.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe recipe);
    }

    private List<Recipe> recipes = new ArrayList<>();
    private OnRecipeClickListener clickListener;

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public void setOnRecipeClickListener(OnRecipeClickListener listener) {
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
//recipe name
        holder.textRecipeName.setText(recipe.getName());

        //ingredients preview
        String ingredients = recipe.getIngredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            String[] lines = ingredients.split("\n");
            StringBuilder preview = new StringBuilder();
            int limit = Math.min(2, lines.length);
            for (int i = 0; i < limit; i++) {
                if (i > 0) preview.append(", ");
                preview.append(lines[i].trim());
            }
            if (lines.length > 2) preview.append("...");
            holder.textRecipePreview.setText(preview.toString());
        } else {
            holder.textRecipePreview.setText("");
        }

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onRecipeClick(recipe);
            }
        });
    }
//displaying the total number of recipes
    @Override
    public int getItemCount() {
        return recipes.size();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView textRecipeName;
        TextView textRecipePreview;

        RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            textRecipeName = itemView.findViewById(R.id.textRecipeName);
            textRecipePreview = itemView.findViewById(R.id.textRecipePreview);
        }
    }
}