/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leducphi
 */
public class ProductDAO extends DBContext {

    //action: read all products
    //cac buoc lam viec: 
    /*
        1. tao doi tuong ket noi den csdl
        2. tao cac doi tuong prepare statement de thuc thi truy van
        3. thuc thi truy van
        4. xu ly ket qua tra ve
     */
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsinStock = rs.getInt("UnitsinStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                //khoi tao doi tuong product 
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsinStock, UnitsOnOrder, ReorderLevel, Discontinued);
                //add to list
                products.add(p);
            }
        } catch (SQLException e) {
        }

        return products;
    }
    
//    public static void main(String[] args) {
//        ArrayList<Product> proList = new ProductDAO().getProducts();
//        for (Product p : proList) {
//            System.out.println(p);
//        }
//    }
}
