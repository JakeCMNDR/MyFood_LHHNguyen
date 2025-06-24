package com.example.myfood_lhhnguyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FoodAdapter_LHHNguyen extends RecyclerView.Adapter<FoodAdapter_LHHNguyen.ViewHolder> {

    Context context;
    List<Food_LHHNguyen> foodList;

    public FoodAdapter_LHHNguyen(Context context, List<Food_LHHNguyen> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food_LHHNguyen food = foodList.get(position);
        holder.tvName.setText(food.getName());
        holder.tvSize.setText("Size: " + food.getSize());
        holder.tvPrice.setText(food.getPrice() + " VND");
        holder.img.setImageResource(R.drawable.sample_food);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvSize, tvPrice;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvFoodName_LHHNguyen);
            tvSize = itemView.findViewById(R.id.tvFoodSize_LHHNguyen);
            tvPrice = itemView.findViewById(R.id.tvFoodPrice_LHHNguyen);
            img = itemView.findViewById(R.id.imgFood_LHHNguyen);
        }
    }
}

