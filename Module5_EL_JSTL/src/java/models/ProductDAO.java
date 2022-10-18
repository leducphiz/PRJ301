package models;

import dal.DBContext;
import dal.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thopn
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        // Create : PrepareStatement
        try {
            String sql = "Select * from Products";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");

                // Intinilizial object 
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);

                // Add p to arraylist
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return products;
    }

    public Product getProductByID(int ProductId) {

        // Create : PrepareStatement
        try {
            String sql = "Select * from Products where ProductID=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setInt(1, ProductId);

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            if (rs.next()) {
                // Take data from 'rs' to biencucbo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");

                // Intinilizial object 
                Product pro = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                // Add p to arraylist
                return pro;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public int count(String searchName) {
        try {
            String sql = "select count(*) from Products where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setString(1, "%" + searchName + "%");

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }
    
    public int countProductList() {
        try {
            String sql = "select count(*) from Products";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
         

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<Product> search(String searchName) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setString(1, "%" + searchName + "%");

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");

                // Intinilizial object 
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);

                // Add p to arraylist
                products.add(p);

            }
        } catch (Exception e) {
        }

        return products;
    }

    public ArrayList<Product> searchPageSize(String searchName, int index, int size) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "with x as(select ROW_NUMBER() over (order by ProductID asc) as y\n"
                    + ",* from Products where ProductName like ?)\n"
                    + "select * from x where y between ? * ? - (? - 1) and ? * ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setString(1, "%" + searchName + "%");
            ps.setInt(2, index);
            ps.setInt(3, size);
             ps.setInt(4, size);
              ps.setInt(5, index);
               ps.setInt(6, size);
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");

                // Intinilizial object 
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);

                // Add p to arraylist
                products.add(p);

            }
        } catch (Exception e) {
        }

        return products;
    }
    
     public ArrayList<Product> PageSize( int index, int size) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "with x as(select ROW_NUMBER() over (order by ProductID asc) as y\n"
                    + ",* from Products)\n"
                    + "select * from x where y between ? * ? - (? - 1) and ? * ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            
            ps.setInt(1, index);
            ps.setInt(2, size);
             ps.setInt(3, size);
              ps.setInt(4, index);
               ps.setInt(5, size);
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");

                // Intinilizial object 
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);

                // Add p to arraylist
                products.add(p);

            }
        } catch (Exception e) {
        }

        return products;
    }

    public void updatePro(Product pro) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + " WHERE ProductID =?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, pro.getProductName());
            ps.setDouble(2, pro.getUnitPrice());

            ps.setInt(3, pro.getProductID());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePro(int id) {
        String sql = "delete Products FROM Products \n"
                + "left join [dbo].[Order Details]\n"
                + "on Products.ProductID = [dbo].[Order Details].ProductID\n"
                + "where Products.ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrderDetail(int id) {
        String sql = "delete [dbo].[Order Details] FROM [dbo].[Order Details]\n"
                + "left join Products\n"
                + "on Products.ProductID = [dbo].[Order Details].ProductID\n"
                + "where Products.ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        ArrayList<Product> products = p.PageSize(1, 6);
        for (Product p1 : products) {
            System.out.println(p1);
        }
    }
}
