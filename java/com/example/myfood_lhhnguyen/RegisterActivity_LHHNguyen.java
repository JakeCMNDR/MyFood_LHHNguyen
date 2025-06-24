package com.example.myfood_lhhnguyen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity_LHHNguyen extends AppCompatActivity {

    EditText etUsernameReg_LHHNguyen, etPasswordReg_LHHNguyen, etRePassword_LHHNguyen;
    Button btnRegister_LHHNguyen;
    DBHelper_LHHNguyen dbHelper_LHHNguyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper_LHHNguyen = new DBHelper_LHHNguyen(this);
        etUsernameReg_LHHNguyen = findViewById(R.id.etUsernameReg_LHHNguyen);
        etPasswordReg_LHHNguyen = findViewById(R.id.etPasswordReg_LHHNguyen);
        etRePassword_LHHNguyen = findViewById(R.id.etRePassword_LHHNguyen);
        btnRegister_LHHNguyen = findViewById(R.id.btnRegister_LHHNguyen);

        btnRegister_LHHNguyen.setOnClickListener(v -> RegisterUser_LHHNguyen());
    }

    private void RegisterUser_LHHNguyen() {
        String username = etUsernameReg_LHHNguyen.getText().toString().trim();
        String password = etPasswordReg_LHHNguyen.getText().toString().trim();
        String rePassword = etRePassword_LHHNguyen.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(rePassword)) {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper_LHHNguyen.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", username);
        values.put("Password", password);

        long result = db.insert("User", null, values);
        if (result != -1) {
            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity_LHHNguyen.class));
        } else {
            Toast.makeText(this, "Thất bại. Username có thể đã tồn tại", Toast.LENGTH_SHORT).show();
        }
    }
}

