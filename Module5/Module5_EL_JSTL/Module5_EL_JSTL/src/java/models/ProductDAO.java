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

    public void updatePro(Product pro) {
        String sql = "UPDATE [dbo].[Products] SET [ProductName] = ?,[UnitPrice] = ?\n WHERE ProductID =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pro.getProductName());
            ps.setDouble(2, pro.getUnitPrice());
            ps.setInt(3, pro.getProductID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePro(int id) {
        String sql = "delete Products FROM Products left join [Order Details] on Products.ProductID = [Order Details].ProductID where Products.ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrderDetail(int id) {
        String sql = "delete [Order Details] FROM [Order Details] left join Products on Products.ProductID = [Order Details].ProductID where Products.ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        ProductDAO p = new ProductDAO();
        p.deletePro(1);

    }
}
