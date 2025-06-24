package com.example.myfood_lhhnguyen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class HomeActivity_LHHNguyen extends AppCompatActivity {

    RecyclerView rvRestaurant_LHHNguyen;
    RestaurantAdapter_LHHNguyen adapter;
    ArrayList<Restaurant_LHHNguyen> restaurantList = new ArrayList<>();
    DBHelper_LHHNguyen dbHelper_LHHNguyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvRestaurant_LHHNguyen = findViewById(R.id.rvRestaurant_LHHNguyen);
        dbHelper_LHHNguyen = new DBHelper_LHHNguyen(this);

        loadRestaurantData_LHHNguyen();

        adapter = new RestaurantAdapter_LHHNguyen(this, restaurantList);
        rvRestaurant_LHHNguyen.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurant_LHHNguyen.setAdapter(adapter);

        exportDatabase();
    }

    private void loadRestaurantData_LHHNguyen() {
        SQLiteDatabase db = dbHelper_LHHNguyen.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Restaurant", null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            String phone = cursor.getString(3);
            String image = cursor.getString(4);
            restaurantList.add(new Restaurant_LHHNguyen(id, name, address, phone, image));
        }
        cursor.close();
    }

    private void exportDatabase() {
        try {
            File dbFile = getDatabasePath("MyFood_LHHNguyen.db");

            File exportDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!exportDir.exists()) exportDir.mkdirs();

            File backupFile = new File(exportDir, "backup_db.db");

            FileChannel src = new FileInputStream(dbFile).getChannel();
            FileChannel dst = new FileOutputStream(backupFile).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();

            Toast.makeText(this, "Đã xuất DB tới: " + backupFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Lỗi xuất DB: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}



