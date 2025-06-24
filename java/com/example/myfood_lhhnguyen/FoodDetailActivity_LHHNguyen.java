package com.example.myfood_lhhnguyen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity_LHHNguyen extends AppCompatActivity {

    private TextView tvFoodName, tvDescription, tvStoreInfo, tvPrice;
    private Button btnSmall, btnMedium, btnLarge;
    private ImageButton btnAddToCart, btnFavorite;
    private ImageView imgFood;

    // Giá theo size
    private double smallPrice = 10000.0;
    private double mediumPrice = 29000.0;
    private double largePrice = 51000.0;
    private double selectedPrice = smallPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        tvFoodName = findViewById(R.id.tvFoodName);
        tvDescription = findViewById(R.id.tvDescription);
        tvStoreInfo = findViewById(R.id.tvStoreInfo);
        tvPrice = findViewById(R.id.tvPrice);

        btnSmall = findViewById(R.id.btnSmall);
        btnMedium = findViewById(R.id.btnMedium);
        btnLarge = findViewById(R.id.btnLarge);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnFavorite = findViewById(R.id.btnFavorite);
        imgFood = findViewById(R.id.imgFood);

        tvFoodName.setText("Bánh mì bò kho");
        tvDescription.setText("Bữa ăn đơn giản cho người đơn giản!");
        tvStoreInfo.setText("Tên cửa hàng: Quán Ăn Ngon - Địa chỉ: 123 Lê Lợi");
        imgFood.setImageResource(R.drawable.food);  // đảm bảo bạn đã thêm ảnh vào drawable

        updatePrice(smallPrice);
        highlightSelectedSize(btnSmall);

        btnSmall.setOnClickListener(v -> {
            updatePrice(smallPrice);
            highlightSelectedSize(btnSmall);
        });

        btnMedium.setOnClickListener(v -> {
            updatePrice(mediumPrice);
            highlightSelectedSize(btnMedium);
        });

        btnLarge.setOnClickListener(v -> {
            updatePrice(largePrice);
            highlightSelectedSize(btnLarge);
        });

        btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào giỏ hàng với giá " + (int) selectedPrice + " VND", Toast.LENGTH_SHORT).show();
            // TODO: Bạn có thể thêm logic lưu vào giỏ hàng (List, Database,...)
        });

        btnFavorite.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào danh sách yêu thích!", Toast.LENGTH_SHORT).show();
            // TODO: Thêm xử lý lưu yêu thích
        });
    }

    private void updatePrice(double price) {
        selectedPrice = price;
        tvPrice.setText((int) price + " VND");
    }

    private void highlightSelectedSize(Button selectedButton) {
        btnSmall.setBackgroundColor(getResources().getColor(R.color.orange));
        btnMedium.setBackgroundColor(getResources().getColor(R.color.orange));
        btnLarge.setBackgroundColor(getResources().getColor(R.color.orange));

        selectedButton.setBackgroundColor(getResources().getColor(R.color.purple_700));
    }
}


