/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.SupplierDTO;
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
public class SupplierDAO implements IDAO<SupplierDTO, String> {

    @Override
    public boolean create(SupplierDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SupplierDTO> readAll() {
        List<SupplierDTO> listFound = new ArrayList<>();
        //chuẩn bị câu lệnh SQL:
        String sql = "SELECT * FROM Suppliers";
        // Tạo đối tượng PrepareStatement:
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Thực thi câu lệnh:
            ResultSet resultSet = ps.executeQuery();//trả về cái bảng kết quả như SQL
            while (resultSet.next()) {
                String supplierID = resultSet.getString("SupplierID").trim();
                String companyName = resultSet.getString("CompanyName").trim();
                String address = resultSet.getString("Address").trim();
                String phone = resultSet.getString("Phone").trim();
                SupplierDTO s = new SupplierDTO(supplierID, companyName, address, phone);
                listFound.add(s);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFound;
    }

    @Override
    public SupplierDTO readById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SupplierDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SupplierDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
