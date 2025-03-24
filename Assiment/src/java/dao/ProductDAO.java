/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author PhamBaoPhi
 */
public class ProductDAO extends DBUtils implements IDAO<ProductDTO, Integer> {
    
    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        for (ProductDTO arg : dao.readAll()) {
            System.out.println(arg);
        }
//        ProductDTO p = new ProductDTO(0, productName, supplierID, categoryID, 0, 0, description, categoryName, productImage)
        System.out.println(dao.delete(6));
    }

    @Override
    public boolean create(ProductDTO entity) {
        // Xây dựng SQL
        String sql = "INSERT INTO Products (ProductName, SupplierID, CategoryID, "
                + "QuantityPerUnit, UnitPrice, Description, ProductImage) VALUES\n"
                + "(?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, entity.getProductName());
            ps.setObject(2, entity.getSupplierID());
            ps.setObject(3, entity.getCategoryID());
            ps.setObject(4, entity.getQuantityPerUnit());
            ps.setObject(5, entity.getUnitPrice());
            ps.setObject(6, entity.getDescription());
            ps.setObject(7, entity.getProductImage());
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<ProductDTO> readAll() {
        List<ProductDTO> listFound = new ArrayList<>();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.Sale = 1";
        // Tạo đối tượng PrepareStatement:
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Thực thi câu lệnh:
            ResultSet rs = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String productName = rs.getString("ProductName").trim();
                String supplierID = rs.getString("SupplierID").trim();
                String categoryName = rs.getString("CategoryName").trim();
                String categoryID = rs.getString("CategoryID").trim();
                int quantityPerUnit = rs.getInt("QuantityPerUnit");
                double unitPrice = rs.getDouble("UnitPrice");
                String description = rs.getString("Description").trim();
                String productImage = rs.getString("ProductImage").trim();
                //int sale = rs.getInt("Sale");//này cho có vì thực tế ta ko lấy tk sale = 0 về
                ProductDTO p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    @Override
    public ProductDTO readById(Integer id) {
        ProductDTO p = null;
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.ProductID = ? AND p.Sale = 1";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, id);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean update(ProductDTO entity) {
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[ProductImage] = ?\n"
                + " WHERE ProductID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Tạo đối tượng PrepareStatement:
            ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, entity.getProductName());
            ps.setObject(2, entity.getSupplierID());
            ps.setObject(3, entity.getCategoryID());
            ps.setObject(4, entity.getQuantityPerUnit());
            ps.setObject(5, entity.getUnitPrice());
            ps.setObject(6, entity.getDescription());
            ps.setObject(7, entity.getProductImage());
            ps.setObject(8, entity.getProductID());
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [Sale] = 0\n"
                + " WHERE ProductID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Tạo đối tượng PrepareStatement:
            ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, id);
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    //nhận về tk product mới nhất
    public ProductDTO getNewProduct()  {

        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT top 1 p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		  LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		  on p.CategoryID = c.CategoryID \n"
                + "  WHERE p.Sale = 1"
                + "  ORDER BY ProductID desc";
        ProductDTO p = null;
        try {
            // connect with DB:
            Connection conn = DBUtils.getConnection();
            // Tạo đối tượng PrepareStatement:
            PreparedStatement ps = conn.prepareStatement(sql);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }

    //lấy về danh sách các Product theo Category:
    public List<ProductDTO> getProductByCategory(String caID) {
        List<ProductDTO> listFound = new ArrayList<>();
        //chuẩn bị câu lệnh SQL:
        String sql = "  SELECT p.*, c.CategoryName\n"
                + "  FROM [PizzaStoreDB].[dbo].[Products] p \n"
                + "		LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c \n"
                + "		ON p.CategoryID = c.CategoryID \n"
                + "  WHERE p.CategoryID = ?  AND p.Sale = 1";

        try {
            // connect with DB:
            Connection conn = DBUtils.getConnection();
            // Tạo đối tượng PrepareStatement:
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            caID = caID.toUpperCase();
            ps.setString(1, caID);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                //int sale = resultSet.getInt("Sale");
                ProductDTO p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //search bằng Name:
    @Override
    public List<ProductDTO> search(String searchTerm) {
        List<ProductDTO> listFound = new ArrayList<>();
        // Xây dựng SQL động
        String sql = "SELECT p.*, c.CategoryName "
                + "FROM [PizzaStoreDB].[dbo].[Products] p "
                + "LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c "
                + "ON p.CategoryID = c.CategoryID "
                + "WHERE p.ProductName LIKE ?  AND p.Sale = 1";

        try {
            // connect with DB:
            Connection conn = DBUtils.getConnection();
            // Tạo đối tượng PrepareStatement:
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set tham số SQL
            ps.setString(1, "%" + searchTerm + "%");
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                ProductDTO p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //Search product by price:
    public List<ProductDTO> searchByPrice(Double price) {
        List<ProductDTO> listFound = new ArrayList<>();
        // Xây dựng SQL động
        String sql = "SELECT p.*, c.CategoryName "
                + "FROM [PizzaStoreDB].[dbo].[Products] p "
                + "LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c "
                + "ON p.CategoryID = c.CategoryID "
                + "WHERE p.UnitPrice = ?  AND p.Sale = 1";

        try {
            // connect with DB:
            Connection conn = DBUtils.getConnection();
            // Tạo đối tượng PrepareStatement:
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set tham số SQL
            ps.setDouble(1, price);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int productID = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName").trim();
                String supplierID = resultSet.getString("SupplierID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String categoryID = resultSet.getString("CategoryID").trim();
                int quantityPerUnit = resultSet.getInt("QuantityPerUnit");
                double unitPrice = resultSet.getDouble("UnitPrice");
                String description = resultSet.getString("Description").trim();
                String productImage = resultSet.getString("ProductImage").trim();
                int sale = resultSet.getInt("Sale");
                ProductDTO p = new ProductDTO(productID, productName, supplierID,
                        categoryID, quantityPerUnit, unitPrice,
                        description, categoryName, productImage);
                listFound.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }
}
