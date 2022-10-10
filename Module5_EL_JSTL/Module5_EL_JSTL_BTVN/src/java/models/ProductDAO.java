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

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "select * from Products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                double UnitPrice = rs.getDouble("UnitPrice");
                Product p = new Product(ProductID, ProductName, UnitPrice);
                products.add(p);
            }
        } catch (SQLException e) {
        }
        return products;
    }

    public void UpdateProduct(Product product) {
        String sql = "UPDATE dbo.Products\n"
                + "SET ProductName = ?, UnitPrice = ?\n"
                + "WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getUnitPrice());
            ps.setInt(3, product.getProductID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DeleteProduct(int id) {
        String sql = "DELETE FROM dbo.[Order Details] WHERE ProductID = ?\n"
                + "DELETE FROM dbo.Products WHERE ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        ProductDAO x = new ProductDAO();
//        Product p = new Product(2, "Iphone 2", 100.2);
//        System.out.println(p);
//        x.UpdateProduct(p);
//    }

    public Product getProductByID(int id) {
        Product product = null;
        try {
            String sql = "SELECT * FROM dbo.Products WHERE ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                double UnitPrice = rs.getDouble("UnitPrice");
                product = new Product(ProductID, ProductName, UnitPrice);
            }
        } catch (SQLException e) {
        }

        return product;
    }
}
