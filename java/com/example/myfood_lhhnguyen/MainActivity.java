package com.example.myfood_lhhnguyen;

import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBHelper_LHHNguyen dbHelper_LHHNguyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper_LHHNguyen = new DBHelper_LHHNguyen(this);
        SQLiteDatabase db = dbHelper_LHHNguyen.getWritableDatabase();
        Toast.makeText(this, "Đã tạo DB Food_LHHNguyen và thêm dữ liệu mẫu!", Toast.LENGTH_SHORT).show();
    }
}
