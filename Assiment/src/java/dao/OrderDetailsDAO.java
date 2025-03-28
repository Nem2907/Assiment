/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.DBUtils;

/**
 *
 * @author hoang
 */
public class OrderDetailsDAO {

    public boolean addOrderDetail(String orderID, int productID, int quantity, double unitPrice) {
        String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, orderID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.setDouble(4, unitPrice);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
