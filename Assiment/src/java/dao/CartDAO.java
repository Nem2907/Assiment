/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CartItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author PhamBaoPhi
 */
public class CartDAO implements IDAO<CartItemDTO, Integer> {

    //get All Product In Cart By AccountID
    public List<CartItemDTO> getAllProductInCartByID(int AccountID) {
        List<CartItemDTO> listFound = new ArrayList<>();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT ca.*, p.ProductName, p.ProductImage, p.UnitPrice \n"
                + "FROM Cart ca LEFT JOIN Products p\n"
                + "	on ca.ProductID = p.ProductID\n"
                + "WHERE ca.AccountID = ?";
        // Tạo đối tượng PrepareStatement:
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, AccountID);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                int idCart = resultSet.getInt("CartID");
                int accountId = resultSet.getInt("AccountID");
                int productId = resultSet.getInt("ProductID");
                int quantity = resultSet.getInt("Quantity");
                String productName = resultSet.getString("ProductName");
                String productImage = resultSet.getString("ProductImage");
                double priceOnOne = resultSet.getDouble("UnitPrice");
                double total = quantity * priceOnOne;
                Timestamp timestamp = resultSet.getTimestamp("AddedDate");
                LocalDateTime addedDate = timestamp.toLocalDateTime(); // Chuyển về LocalDateTime
                CartItemDTO item = new CartItemDTO(idCart, accountId, productId,
                        quantity, productName, productImage, total, addedDate);
                listFound.add(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    //add Product in cart:
    public boolean addItemToCart(int idAccount, int productID, int quantity) {
        // Xây dựng SQL
        String sql = "INSERT INTO [dbo].[Cart]\n"
                + "           ([AccountID]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quantity])\n"
                + "     VALUES(?, ?, ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, idAccount);
            ps.setObject(2, productID);
            ps.setObject(3, quantity);
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean create(CartItemDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartItemDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CartItemDTO readById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CartItemDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //remove item cartby CartID:
    @Override
    public boolean delete(Integer id) {
        // Xây dựng SQL
        String sql = "DELETE FROM [dbo].[Cart]\n"
                + "      WHERE CartID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(1, id);
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }
    
    //update Product in cart:
    public boolean update(int id, int quantity){
        // Xây dựng SQL
        String sql = "UPDATE [dbo].[Cart]\n"
                + "   SET [Quantity] = ?\n"
                + " WHERE CartID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set parameter ( optional )
            ps.setObject(2, id);
            ps.setObject(1, quantity);
            //Thực thi câu lệnh:
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<CartItemDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
