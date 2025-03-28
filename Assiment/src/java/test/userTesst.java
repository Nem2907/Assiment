/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDAO;
import dto.UserDTO;
import utils.PasswordUtils;

/**
 *
 * @author hoang
 */
public class userTesst {

    public static void main(String[] args) {
//        UserDAO user = new UserDAO();
//        UserDTO u2 = new UserDTO(1,"nam","123",1);
//        user.update(u2);
////        user.deleteByUserName("phi");
////        user.deleteByUserName("Nam2");
        UserDAO udao = new UserDAO();
        UserDTO user = new UserDTO("nem", PasswordUtils.hashPassword("123456789"), "Nguyễn Hoàng Nam", "0825561297", "nemnguyenhoang2907@gmail.com", "admin");
        udao.create(user);
    }
}
