package dal;

import dal.DBContext;
import models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author thopn
 */
public class ProductDAO extends DBContext {

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.searchProduct("a", "all");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "select * from Products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByPage(int page, int elements) {
        ArrayList<Product> products = new ArrayList<>();
        int start = page * elements - elements;
        try {
            String sql = "SELECT *FROM products\n"
                    + "ORDER BY\n"
                    + "   ProductID\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, elements);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public Product UpdateProducts(int ProductID, String ProductName, int CategoryID, String QuantityPerUnit, double UnitPrice,
            int UnitsInStock, int UnitsOnOrder, int ReorderLevel) {
        try {
            String sql = "update Products set ProductName = ? , CategoryID = ? , QuantityPerUnit = ? ,\n"
                    + "                     UnitPrice = ? , UnitsInStock = ? , UnitsOnOrder = ? , ReorderLevel = ? \n"
                    + "                    where ProductID = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setString(3, QuantityPerUnit);
            ps.setDouble(4, UnitPrice);
            ps.setInt(5, UnitsInStock);
            ps.setInt(6, UnitsOnOrder);
            ps.setInt(7, ReorderLevel);
            ps.setInt(8, ProductID);
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return null;
    }

    public void DeleteProduct(int ProductID) {
        try {
            String sql = "delete Products where ProductID = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ProductID);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Product getProductByID(int id) {
        String sql = "select * from Products\n"
                + "where ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                return p;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void insertProduct(String ProductName, int CategoryID, String QuantityPerUnit, double UnitPrice,
            int UnitsInStock, int UnitsOnOrder, int ReorderLevel, int Discontinued) {
        String sql = "insert into Products(ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder,ReorderLevel, Discontinued)"
                + " values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setString(3, QuantityPerUnit);
            ps.setDouble(4, UnitPrice);
            ps.setInt(5, UnitsInStock);
            ps.setInt(6, UnitsOnOrder);
            ps.setInt(7, ReorderLevel);
            ps.setInt(8, Discontinued);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Product> searchProduct(String textSearch, String filter) {

        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = new ProductDAO().getQueryByFilter(filter, textSearch);
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public Product getLastestProduct() {
        try {
            String sql = "SELECT TOP 1 * FROM Products ORDER BY ProductID DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                p.setUnitPrice(rs.getDouble("UnitPrice"));
                p.setUnitsInStock(rs.getInt("UnitsInStock"));
                p.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                p.setReorderLevel(rs.getInt("ReorderLevel"));
                p.setDiscontinued(rs.getBoolean("Discontinued"));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String getQueryByFilter(String filter, String textSearch) {
        String query = "";
        switch (filter) {
            case "name":
                query = "select * from Products where ProductName like '%" + textSearch + "%'";
                break;
            case "category":
                query = "select p.ProductID , p.ProductName , p.CategoryID , p.QuantityPerUnit , p.UnitPrice , p.UnitsInStock , p.UnitsOnOrder  , p.ReorderLevel , p.Discontinued from Products p \n"
                        + "join Categories c\n"
                        + "on  p.CategoryID = c.CategoryID\n"
                        + "\n"
                        + "where c.CategoryName like '%" + textSearch + "%' ";
                break;
            case "price":
                query = "select * from Products where UnitPrice like '%" + textSearch + "%'";
                break;
            case "all":
                query = "select p.ProductID , p.ProductName , p.CategoryID , p.QuantityPerUnit , p.UnitPrice , p.UnitsInStock , p.UnitsOnOrder  , p.ReorderLevel , p.Discontinued from Products p \n"
                        + "join Categories c\n"
                        + "on  p.CategoryID = c.CategoryID\n"
                        + "\n"
                        + "where c.CategoryName like '%" + textSearch + "%' or p.ProductName like '%" + textSearch + "%' or p.UnitPrice like '%" + textSearch + "%'";
            default:
                break;
        }

        return query;
    }

}
