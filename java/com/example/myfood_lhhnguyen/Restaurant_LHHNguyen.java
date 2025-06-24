package com.example.myfood_lhhnguyen;

public class Restaurant_LHHNguyen {
    int resID;
    String name, address, phone, image;

    public Restaurant_LHHNguyen(int resID, String name, String address, String phone, String image) {
        this.resID = resID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }

    public int getResID() { return resID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getImage() { return image; }
}

