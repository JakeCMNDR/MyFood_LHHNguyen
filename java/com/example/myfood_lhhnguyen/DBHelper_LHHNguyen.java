package com.example.myfood_lhhnguyen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_LHHNguyen extends SQLiteOpenHelper {

    public static final String DB_NAME = "Food_LHHNguyen.db";
    public static final int DB_VERSION = 1;

    public DBHelper_LHHNguyen(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User (" +
                "UserID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Gender TEXT, Date_of_birth TEXT, " +
                "Phone TEXT, Username TEXT, Password TEXT)");

        db.execSQL("CREATE TABLE Restaurant (" +
                "ResID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Address TEXT, Phone TEXT, Image TEXT)");

        db.execSQL("CREATE TABLE Food (" +
                "FoodID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, Type TEXT, Description TEXT, Image TEXT, " +
                "ResID INTEGER, FOREIGN KEY(ResID) REFERENCES Restaurant(ResID))");

        db.execSQL("CREATE TABLE `Order` (" +
                "OrderID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Address TEXT, Date_order TEXT, Total_value REAL, Status TEXT, " +
                "UserID INTEGER, FOREIGN KEY(UserID) REFERENCES User(UserID))");

        db.execSQL("CREATE TABLE OrderDetail (" +
                "OrderID INTEGER, FoodID INTEGER, Size TEXT, Food TEXT, Quantity INTEGER, " +
                "PRIMARY KEY(OrderID, FoodID), " +
                "FOREIGN KEY(OrderID) REFERENCES `Order`(OrderID), " +
                "FOREIGN KEY(FoodID) REFERENCES Food(FoodID))");

        insertSampleData_LHHNguyen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS OrderDetail");
        db.execSQL("DROP TABLE IF EXISTS `Order`");
        db.execSQL("DROP TABLE IF EXISTS Food");
        db.execSQL("DROP TABLE IF EXISTS Restaurant");
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    private void insertSampleData_LHHNguyen(SQLiteDatabase db) {
        db.execSQL("INSERT INTO User (Name, Gender, Date_of_birth, Phone, Username, Password) VALUES " +
                "('Nguyen Van A', 'Male', '2000-01-01', '0900000001', 'user1', '123')," +
                "('Le Thi B', 'Female', '2001-02-02', '0900000002', 'user2', '123')," +
                "('Tran Van C', 'Male', '2002-03-03', '0900000003', 'user3', '123')," +
                "('Pham Thi D', 'Female', '2003-04-04', '0900000004', 'user4', '123')," +
                "('Hoang Van E', 'Male', '2004-05-05', '0900000005', 'user5', '123');");

        db.execSQL("INSERT INTO Restaurant (Name, Address, Phone, Image) VALUES " +
                "('Quán bánh mì cô Ba', '68 Bùi Thị Xuân, Tân Bình', '0911111111', 'img1.png')," +
                "('Coffee House', '11 Võ Văn Ngân, Thủ Đức', '0922222222', 'img2.png')," +
                "('Cơm tấm Phúc Map', 'P.6, Q.5', '0933333333', 'img3.png')," +
                "('Bánh ngọt Lê Văn Việt', 'Q.9', '0944444444', 'img4.png')," +
                "('Phở Hà Nội', 'Q.1', '0955555555', 'img5.png');");

        db.execSQL("INSERT INTO Food (Name, Type, Description, Image, ResID) VALUES " +
                "('Bánh mì bò kho', 'Main', 'Bò kho + bánh mì', 'f1.png', 1)," +
                "('Bánh mì bơ tỏi', 'Snack', 'Nướng bơ tỏi thơm', 'f2.png', 1)," +
                "('Phở bò', 'Main', 'Phở truyền thống', 'f3.png', 5)," +
                "('Trà sữa truyền thống', 'Drink', 'Trà sữa + trân châu', 'f4.png', 2)," +
                "('Cơm tấm sườn', 'Main', 'Sườn nướng + cơm tấm', 'f5.png', 3)," +
                "('Bún bò Huế', 'Main', 'Đặc sản miền Trung', 'f6.png', 5)," +
                "('Gà rán', 'Snack', 'Gà rán giòn cay', 'f7.png', 4)," +
                "('Bánh tráng trộn', 'Snack', 'Trộn khô bò, rau răm', 'f8.png', 4)," +
                "('Nước cam', 'Drink', 'Cam vắt nguyên chất', 'f9.png', 2)," +
                "('Cà phê sữa', 'Drink', 'Cà phê đậm đà', 'f10.png', 2);");
    }
}

