package com.khomotso.smartpantrymanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.khomotso.smartpantrymanager.data.PantryDatabase;
import com.khomotso.smartpantrymanager.data.PantryItem;
import com.khomotso.smartpantrymanager.data.PantryItemDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PantryAdapter adapter;
    private PantryItemDao dao;
    private TextView textEmpty;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = PantryDatabase.getInstance(this).pantryItemDao();

        recyclerView = findViewById(R.id.recyclerView);
        textEmpty = findViewById(R.id.textEmpty);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PantryAdapter();
        adapter.setOnItemLongClickListener(item -> showDeleteDialog(item));
        adapter.setOnItemClickListener(item -> showEditDialog(item));
        recyclerView.setAdapter(adapter);

        dao.getAllItems().observe(this, new Observer<List<PantryItem>>() {
            @Override
            public void onChanged(List<PantryItem> items) {
                adapter.setItems(items);
                textEmpty.setVisibility(items.isEmpty() ? View.VISIBLE : View.GONE);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> showAddDialog());
    }

    private void showAddDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_item, null);
        EditText inputName = dialogView.findViewById(R.id.inputName);
        EditText inputQuantity = dialogView.findViewById(R.id.inputQuantity);
        EditText inputUnit = dialogView.findViewById(R.id.inputUnit);
        EditText inputExpiry = dialogView.findViewById(R.id.inputExpiry);

        new AlertDialog.Builder(this)
                .setTitle("Add Pantry Item")
                .setView(dialogView)
                .setPositiveButton("Save", (dialog, which) -> {
                    String name = inputName.getText().toString().trim();
                    String qtyStr = inputQuantity.getText().toString().trim();
                    String unit = inputUnit.getText().toString().trim();
                    String expiryStr = inputExpiry.getText().toString().trim();

                    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(qtyStr)) {
                        Toast.makeText(this, "Name and quantity are required", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double qty;
                    try {
                        qty = Double.parseDouble(qtyStr);
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    long expiry = 0;
                    if (!TextUtils.isEmpty(expiryStr)) {
                        try {
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault());
                            java.util.Date date = sdf.parse(expiryStr);
                            if (date != null) expiry = date.getTime();
                        } catch (Exception e) {
                            Toast.makeText(this, "Date format: dd/MM/yyyy", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    PantryItem item = new PantryItem(name, qty, unit, expiry);
                    dao.insert(item);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showEditDialog(PantryItem item) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_item, null);
        EditText inputName = dialogView.findViewById(R.id.inputName);
        EditText inputQuantity = dialogView.findViewById(R.id.inputQuantity);
        EditText inputUnit = dialogView.findViewById(R.id.inputUnit);
        EditText inputExpiry = dialogView.findViewById(R.id.inputExpiry);

        // Pre-fill with existing values
        inputName.setText(item.getName());
        inputQuantity.setText(String.valueOf(item.getQuantity()));
        inputUnit.setText(item.getUnit());

        if (item.getExpiryDate() > 0) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault());
            inputExpiry.setText(sdf.format(new java.util.Date(item.getExpiryDate())));
        }

        new AlertDialog.Builder(this)
                .setTitle("Edit Pantry Item")
                .setView(dialogView)
                .setPositiveButton("Update", (dialog, which) -> {
                    String name = inputName.getText().toString().trim();
                    String qtyStr = inputQuantity.getText().toString().trim();
                    String unit = inputUnit.getText().toString().trim();
                    String expiryStr = inputExpiry.getText().toString().trim();

                    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(qtyStr)) {
                        Toast.makeText(this, "Name and quantity are required", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double qty;
                    try {
                        qty = Double.parseDouble(qtyStr);
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    long expiry = 0;
                    if (!TextUtils.isEmpty(expiryStr)) {
                        try {
                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault());
                            java.util.Date date = sdf.parse(expiryStr);
                            if (date != null) expiry = date.getTime();
                        } catch (Exception e) {
                            Toast.makeText(this, "Date format: dd/MM/yyyy", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    // Update the existing item
                    item.setName(name);
                    item.setQuantity(qty);
                    item.setUnit(unit);
                    item.setExpiryDate(expiry);
                    dao.update(item);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showDeleteDialog(PantryItem item) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Item")
                .setMessage("Delete \"" + item.getName() + "\"?")
                .setPositiveButton("Delete", (dialog, which) -> dao.delete(item))
                .setNegativeButton("Cancel", null)
                .show();
    }
}