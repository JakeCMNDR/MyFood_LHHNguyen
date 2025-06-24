package com.example.myfood_lhhnguyen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FoodListActivity_LHHNguyen extends AppCompatActivity {

    RecyclerView rvFoodList_LHHNguyen;
    ArrayList<Food_LHHNguyen> foodList = new ArrayList<>();
    FoodAdapter_LHHNguyen adapter;
    DBHelper_LHHNguyen dbHelper;
    int restaurantId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        rvFoodList_LHHNguyen = findViewById(R.id.rvFoodList_LHHNguyen);
        dbHelper = new DBHelper_LHHNguyen(this);

        restaurantId = getIntent().getIntExtra("res_id", -1);
        if (restaurantId == -1) {
            Toast.makeText(this, "Không tìm thấy nhà hàng", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        loadFoodByRestaurant_LHHNguyen();

        adapter = new FoodAdapter_LHHNguyen(this, foodList);
        rvFoodList_LHHNguyen.setLayoutManager(new LinearLayoutManager(this));
        rvFoodList_LHHNguyen.setAdapter(adapter);
    }

    private void loadFoodByRestaurant_LHHNguyen() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Food WHERE ResID = ?", new String[]{String.valueOf(restaurantId)});

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String type = cursor.getString(2);
            String description = cursor.getString(3);
            String image = cursor.getString(4);
            int resId = cursor.getInt(5);

            foodList.add(new Food_LHHNguyen(id, name, type, description, image, resId));
        }

        cursor.close();
    }
}


