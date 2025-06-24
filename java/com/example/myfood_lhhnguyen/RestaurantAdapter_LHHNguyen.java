package com.example.myfood_lhhnguyen;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter_LHHNguyen extends RecyclerView.Adapter<RestaurantAdapter_LHHNguyen.ViewHolder> {

    Activity context;
    List<Restaurant_LHHNguyen> restaurantList;

    public RestaurantAdapter_LHHNguyen(Activity context, List<Restaurant_LHHNguyen> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant_LHHNguyen restaurant = restaurantList.get(position);
        holder.tvName.setText(restaurant.getName());
        holder.tvAddress.setText(restaurant.getAddress());
        holder.tvPhone.setText(restaurant.getPhone());
        
        holder.img.setImageResource(R.drawable.sample_restaurant);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodListActivity_LHHNguyen.class);
            intent.putExtra("res_id", restaurant.getResID());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvPhone;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgRes_LHHNguyen);
            tvName = itemView.findViewById(R.id.tvResName_LHHNguyen);
            tvAddress = itemView.findViewById(R.id.tvResAddress_LHHNguyen);
            tvPhone = itemView.findViewById(R.id.tvResPhone_LHHNguyen);
        }
    }
}


