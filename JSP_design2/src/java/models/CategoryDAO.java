/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Category;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leducphi
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getCategorys() {
        ArrayList<Category> category = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.Categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                category.add(new Category(CategoryID, CategoryName, Description));
            }
        } catch (SQLException e) {
        }

        return category;
    }

//    public static void main(String[] args) {
//        ArrayList<Category> proList = new CategoryDAO().getCategorys();
//        for (Category p : proList) {
//            System.out.println(p);
//        }
//    }
    
    public ArrayList<Category> getCategorysID_1() {
        ArrayList<Category> category = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.Products WHERE CategoryID = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                category.add(new Category(CategoryID, CategoryName, Description));
            }
        } catch (SQLException e) {
        }

        return category;
    }
}
