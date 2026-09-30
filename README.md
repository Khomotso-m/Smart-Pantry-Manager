****# Smart Pantry Manager**

An Android application built in Java that helps users keep track of the food
in their pantry, monitor expiry dates, and discover recipes they can cook
with common ingredients.

---

## Features

### Pantry Management
- **Add items** with name, quantity, unit, and optional expiry date
- **Edit items** by tapping any row
- **Delete items** by long-pressing and confirming
- **Search/filter** items by name using the toolbar search
- **Expiry highlighting** — expired items appear in red, items expiring
  within 3 days appear in orange

### Recipe Collection
- **20 pre-loaded recipes** seeded on first launch
- Each recipe contains a name, list of ingredients, and preparation steps
- **Browse the collection** from the toolbar "Recipes" item
- **View full recipe details** by tapping a recipe

### Persistence
- All data is stored locally using **Room** (SQLite wrapper)
- Recipes are seeded once and persist across app restarts
- Pantry items are preserved between sessions

---

## Tech Stack

**Core**
- **Language:** Java
- **IDE:** Android Studio
- **Build system:** Gradle (Groovy DSL)

**Data & Persistence**
- **Room (SQLite)** — local on-device database
- **LiveData** — observable data holder that auto-updates the UI
- **DAO pattern** — clean separation between queries and UI code

**User Interface**
- **XML layouts** with Material Design Components
- **RecyclerView** — efficient scrolling lists for pantry items and recipes
- **AlertDialog** — in-app forms for adding and editing items

**Platform**
- **Minimum SDK:** API 24 (Android 7.0 Nougat)
- **Target SDK:** API 37
- **Java version:** 11

-----
## Project Structure
app/src/main/java/com/khomotso/smartpantrymanager/
-MainActivity.java → Pantry screen (list, add/edit/delete, search)
-PantryAdapter.java → RecyclerView adapter for pantry items
-RecipeListActivity.java → Recipe collection screen
-RecipeAdapter.java → RecyclerView adapter for recipes
-RecipeDetailActivity.java → Recipe detail screen (ingredients + steps)
 └── data/
.....PantryItem.java → @Entity for pantry items
.....PantryItemDao.java → @Dao for pantry operations
.....Recipe.java → @Entity for recipes
.....RecipeDao.java → @Dao for recipe operations
.....PantryDatabase.java → @Database (Room singleton)
.....RecipeSeeder.java → Seeds 20 recipes on first launch


## How to Run

### Prerequisites
- Android Studio (later recommended)
- JDK 17 or 21
- Android SDK with API 30 or higher installed

### Steps
1. **Clone the repository:**
 https://github.com/Khomotso-m/Smart-Pantry-Manager.git

2. **Open in Android Studio:**
- File → Open → select the cloned `Smart-Pantry-Manager` folder

3. **Let Gradle sync complete** (first sync may take several minutes)

4. **Run the app:**
- Connect an Android device via USB (with USB Debugging enabled),
  or start an emulator
- Click the green **Run ▶** button in the toolbar

---
### Architecture
The app follows a **simplified MVC pattern**:

- **View** — Activities and XML layouts
- **Model** — Room entities and DAOs
- **Controller** — Activities coordinate user input, call DAOs, and update
the UI via LiveData observers

---

## Author

**Khomotso Mokoena**
Module project — Android Application Development

---

## License

This project is for educational purposes only.**
