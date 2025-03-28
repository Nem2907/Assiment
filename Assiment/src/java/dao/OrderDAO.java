/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author hoang
 */
import dto.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class OrderDAO {

    public boolean insertOrder(OrderDTO order) {
        String sql = "INSERT INTO Orders (OrderID, AccountID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, order.getOrderID());
            ps.setInt(2, order.getAccountID());
            ps.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setDate(4, new java.sql.Date(order.getRequiredDate().getTime()));
            ps.setDate(5, order.getShippedDate() != null ? new java.sql.Date(order.getShippedDate().getTime()) : null);
            ps.setDouble(6, order.getFreight());
            ps.setString(7, order.getShipAddress());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<OrderDTO> getOrdersByAccount(int accountID) {
        List<OrderDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE AccountID = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, accountID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDTO order = new OrderDTO(
                        rs.getString("OrderID"),
                        rs.getInt("AccountID"),
                        rs.getDate("OrderDate"),
                        rs.getDate("RequiredDate"),
                        rs.getDate("ShippedDate"),
                        rs.getDouble("Freight"),
                        rs.getString("ShipAddress")
                );
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String createOrder(int accountID, String shipAddress) {
        String sql = "INSERT INTO Orders (OrderID, AccountID, OrderDate, ShipAddress) VALUES (?, ?, GETDATE(), ?)";
        String orderID = "ORD" + System.currentTimeMillis(); // Tạo OrderID dạng "ORD<timestamp>"

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, orderID);
            ps.setInt(2, accountID);
            ps.setString(3, shipAddress);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return orderID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public String createOrder(int accountID, String shipAddress, double freight) {
        String sql = "INSERT INTO Orders (OrderID, AccountID, OrderDate, RequiredDate, Freight, ShipAddress) VALUES (?, ?, GETDATE(), GETDATE(), ?, ?)";
        String orderID = "ORD" + (System.currentTimeMillis() % 1000000); // Tạo OrderID dạng "ORD<timestamp>"

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, orderID);
            ps.setInt(2, accountID);
            ps.setDouble(3, freight);
            ps.setString(4, shipAddress);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return orderID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
