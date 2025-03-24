/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CategoryDTO;
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
 * @author PhamBaoPhi
 */
public class CategoryDAO implements IDAO<CategoryDTO, String> {

    @Override
    public boolean create(CategoryDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        System.out.println(dao.readAll());
    }
    
    @Override
    public List<CategoryDTO> readAll() {
        List<CategoryDTO> listFound = new ArrayList<>();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT * FROM [dbo].[Categories]";
        // Tạo đối tượng PrepareStatement:
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String categoryID = resultSet.getString("CategoryID").trim();
                String categoryName = resultSet.getString("CategoryName").trim();
                String description = resultSet.getString("Description").trim();
                CategoryDTO c = new CategoryDTO(categoryID, categoryName, description);
                listFound.add(c);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    @Override
    public CategoryDTO readById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CategoryDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
