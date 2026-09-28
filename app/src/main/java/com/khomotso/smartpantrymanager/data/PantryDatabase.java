package com.khomotso.smartpantrymanager.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PantryItem.class}, version = 1, exportSchema = false)
public abstract class PantryDatabase extends RoomDatabase {

    private static PantryDatabase instance;

    public abstract PantryItemDao pantryItemDao();

    public static synchronized PantryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PantryDatabase.class,
                    "pantry_database"
            ).allowMainThreadQueries().build();
        }
        return instance;
    }
}