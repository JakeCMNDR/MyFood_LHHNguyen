package com.example.myfood_lhhnguyen;

public class Food_LHHNguyen {
    int id;
    String name, size, price, image;
    int resId;

    public Food_LHHNguyen(int id, String name, String size, String price, String image, int resId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
        this.resId = resId;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public String getPrice() { return price; }
    public String getImage() { return image; }
    public int getResId() { return resId; }
}

