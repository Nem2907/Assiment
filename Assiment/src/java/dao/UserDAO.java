/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author hoang
 */
public class UserDAO implements IDAO<UserDTO, String> {

    @Override
    public boolean create(UserDTO entity) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([UserName]\n"
                + "           ,[Password]\n"
                + "           ,[FullName]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Email]\n"
                + "           ,[Role])"
                + "VALUES (? , ? , ? , ? , ?, ? )";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getUserName());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getFullName());
            ps.setString(4, entity.getPhoneNumber());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getRole());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean isUserExists(String username) {
        username = username.trim();
        String sql = "SELECT 1 FROM [dbo].[Account] WHERE [UserName] = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Nếu có kết quả, user đã tồn tại
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace(); // Thêm dòng này để in lỗi ra console
        }
        return false;
    }

    public boolean isEmailExists(String Email) {
        Email = Email.trim();
        String sql = "SELECT 1 FROM [dbo].[Account] WHERE [Email] = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, Email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Nếu có kết quả, user đã tồn tại
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserDTO> readAll() {
        String sql = " SELECT * FROM [dbo].[Account]";
        List<UserDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getInt("CartID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        (rs.getInt("Role") == 1 ? "Staff" : "User")
                );
                list.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public boolean update(UserDTO entity) {
        return true;
    }

    @Override
    public UserDTO readById(String id) {
        return null;
    }

    public UserDTO readByName(String userName) {
        String sql = "SELECT * FROM [dbo].[Account] WHERE UserName = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getInt("AccountID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("FullName"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        rs.getString("Role"));
                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(String id) {
        return false;
    }

    public boolean deleteByUserName(String username) {
        return false;

    }

    @Override
    public List<UserDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
