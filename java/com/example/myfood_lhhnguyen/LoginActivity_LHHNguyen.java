package com.example.myfood_lhhnguyen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_LHHNguyen extends AppCompatActivity {

    EditText etUsername_LHHNguyen, etPassword_LHHNguyen;
    Button btnLogin_LHHNguyen;
    TextView tvRegister_LHHNguyen;
    DBHelper_LHHNguyen dbHelper_LHHNguyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper_LHHNguyen = new DBHelper_LHHNguyen(this);
        etUsername_LHHNguyen = findViewById(R.id.etUsername_LHHNguyen);
        etPassword_LHHNguyen = findViewById(R.id.etPassword_LHHNguyen);
        btnLogin_LHHNguyen = findViewById(R.id.btnLogin_LHHNguyen);
        tvRegister_LHHNguyen = findViewById(R.id.tvRegister_LHHNguyen);

        btnLogin_LHHNguyen.setOnClickListener(v -> CheckUser_LHHNguyen());

        tvRegister_LHHNguyen.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity_LHHNguyen.class);
            startActivity(intent);
        });
    }

    private void CheckUser_LHHNguyen() {
        String username = etUsername_LHHNguyen.getText().toString().trim();
        String password = etPassword_LHHNguyen.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ!", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper_LHHNguyen.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE Username=? AND Password=?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity_LHHNguyen.class));
        } else {
            Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
    }
}

