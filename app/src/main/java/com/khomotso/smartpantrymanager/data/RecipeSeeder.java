package com.khomotso.smartpantrymanager.data;

public class RecipeSeeder {

    public static void seedIfEmpty(RecipeDao dao) {

        if (dao.getRecipeCount() > 0) return;
        //Inserting recipe items
        dao.insert(new Recipe(
                "Scrambled Eggs",
                "3 eggs\n1 tbsp butter\nSalt\nPepper",
                "1. Crack eggs into a bowl.\n2. Add salt and pepper, whisk well.\n3. Melt butter in a pan over medium heat.\n4. Pour in eggs and stir gently.\n5. Remove from heat while still slightly soft."
        ));

        dao.insert(new Recipe(
                "Tomato Pasta",
                "200g pasta\n400g canned tomatoes\n2 garlic cloves\n1 tbsp olive oil\nBasil\nSalt",
                "1. Boil pasta in salted water until al dente.\n2. Heat oil in a pan, add chopped garlic.\n3. Add tomatoes, simmer 10 minutes.\n4. Stir in pasta and basil.\n5. Serve hot."
        ));

        dao.insert(new Recipe(
                "Grilled Cheese Sandwich",
                "2 slices bread\n2 slices cheddar\n1 tbsp butter",
                "1. Butter one side of each bread slice.\n2. Place cheese between slices, buttered sides out.\n3. Grill in a pan over medium heat.\n4. Flip when golden brown.\n5. Cut and serve."
        ));

        dao.insert(new Recipe(
                "Chicken Stir Fry",
                "300g chicken breast\n1 bell pepper\n1 onion\n2 tbsp soy sauce\n1 tbsp oil\nGarlic",
                "1. Cut chicken into strips.\n2. Heat oil in a wok.\n3. Cook chicken until golden.\n4. Add vegetables, stir fry 3 minutes.\n5. Add soy sauce and serve."
        ));

        dao.insert(new Recipe(
                "Vegetable Soup",
                "2 carrots\n2 potatoes\n1 onion\n1 celery stick\n1L vegetable stock\nSalt\nPepper",
                "1. Chop all vegetables.\n2. Sauté onion in a pot.\n3. Add remaining vegetables.\n4. Pour in stock and simmer 25 min.\n5. Season and serve."
        ));

        dao.insert(new Recipe(
                "Pancakes",
                "1 cup flour\n1 cup milk\n1 egg\n2 tbsp sugar\n1 tsp baking powder\nPinch of salt",
                "1. Mix dry ingredients.\n2. Whisk in milk and egg.\n3. Heat a non-stick pan.\n4. Pour 1/4 cup batter per pancake.\n5. Flip when bubbles appear."
        ));

        dao.insert(new Recipe(
                "Rice and Beans",
                "1 cup rice\n1 can kidney beans\n1 onion\n2 garlic cloves\n1 tsp cumin\nSalt",
                "1. Cook rice per package instructions.\n2. Sauté onion and garlic.\n3. Add beans and cumin.\n4. Simmer 10 minutes.\n5. Serve over rice."
        ));

        dao.insert(new Recipe(
                "Tuna Salad",
                "1 can tuna\n2 tbsp mayonnaise\n1 celery stick\n1 tbsp onion\nSalt\nPepper",
                "1. Drain tuna.\n2. Chop celery and onion finely.\n3. Mix everything in a bowl.\n4. Season to taste.\n5. Serve on bread or lettuce."
        ));

        dao.insert(new Recipe(
                "Omelette",
                "2 eggs\n1 tbsp milk\nCheese\nHam\nSalt\nPepper",
                "1. Whisk eggs with milk, salt, pepper.\n2. Pour into a heated buttered pan.\n3. Add cheese and ham to one side.\n4. Fold over when set.\n5. Slide onto plate."
        ));

        dao.insert(new Recipe(
                "Peanut Butter Toast",
                "2 slices bread\n2 tbsp peanut butter\n1 banana (optional)",
                "1. Toast bread until golden.\n2. Spread peanut butter evenly.\n3. Slice banana on top if using.\n4. Serve immediately."
        ));

        dao.insert(new Recipe(
                "Chicken Curry",
                "500g chicken\n1 onion\n2 tbsp curry powder\n1 can coconut milk\n2 potatoes\nSalt",
                "1. Brown chicken in a pot.\n2. Add chopped onion and curry powder.\n3. Add potatoes and coconut milk.\n4. Simmer 30 minutes.\n5. Serve with rice."
        ));

        dao.insert(new Recipe(
                "Beef Stew",
                "500g beef chunks\n2 carrots\n2 potatoes\n1 onion\n500ml beef stock\nSalt\nPepper",
                "1. Brown beef in a pot.\n2. Add chopped vegetables.\n3. Pour in stock.\n4. Simmer covered 90 minutes.\n5. Season and serve."
        ));

        dao.insert(new Recipe(
                "Mac and Cheese",
                "250g macaroni\n2 cups milk\n2 cups grated cheese\n2 tbsp butter\n2 tbsp flour\nSalt",
                "1. Boil macaroni until tender.\n2. Melt butter, whisk in flour.\n3. Add milk slowly, stir until thick.\n4. Add cheese, stir until melted.\n5. Mix with pasta and serve."
        ));

        dao.insert(new Recipe(
                "Banana Smoothie",
                "2 bananas\n1 cup milk\n1 tbsp honey\nIce cubes",
                "1. Peel and slice bananas.\n2. Add all ingredients to a blender.\n3. Blend until smooth.\n4. Pour into a glass.\n5. Serve cold."
        ));

        dao.insert(new Recipe(
                "Greek Salad",
                "2 tomatoes\n1 cucumber\n1 red onion\n100g feta\nOlives\nOlive oil\nOregano",
                "1. Chop tomatoes, cucumber, onion.\n2. Combine in a bowl.\n3. Add olives and crumbled feta.\n4. Drizzle with olive oil.\n5. Sprinkle oregano and serve."
        ));

        dao.insert(new Recipe(
                "French Toast",
                "2 slices bread\n2 eggs\n1/4 cup milk\n1 tsp cinnamon\n1 tbsp butter\nSyrup",
                "1. Whisk eggs, milk, cinnamon.\n2. Dip bread in mixture.\n3. Melt butter in a pan.\n4. Fry bread until golden on both sides.\n5. Serve with syrup."
        ));

        dao.insert(new Recipe(
                "Fried Rice",
                "2 cups cooked rice\n2 eggs\n1 cup mixed vegetables\n2 tbsp soy sauce\n1 tbsp oil\nGarlic",
                "1. Heat oil in a wok.\n2. Scramble eggs, remove.\n3. Stir fry vegetables and garlic.\n4. Add rice and soy sauce.\n5. Mix in eggs and serve."
        ));

        dao.insert(new Recipe(
                "Grilled Chicken",
                "2 chicken breasts\n2 tbsp olive oil\n1 lemon\nSalt\nPepper\nPaprika",
                "1. Marinate chicken with oil, lemon, spices.\n2. Rest 30 minutes.\n3. Grill on each side 6-7 minutes.\n4. Check cooked through.\n5. Rest 5 minutes before serving."
        ));

        dao.insert(new Recipe(
                "Mashed Potatoes",
                "4 potatoes\n1/4 cup milk\n2 tbsp butter\nSalt\nPepper",
                "1. Peel and boil potatoes 20 min.\n2. Drain water.\n3. Mash with butter and milk.\n4. Season with salt and pepper.\n5. Serve hot."
        ));

        dao.insert(new Recipe(
                "Avocado Toast",
                "2 slices bread\n1 avocado\nLemon juice\nSalt\nChili flakes",
                "1. Toast bread.\n2. Mash avocado with lemon juice and salt.\n3. Spread on toast.\n4. Sprinkle chili flakes.\n5. Serve immediately."
        ));
    }
}