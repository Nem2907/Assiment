/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.UserDAO;
import dto.CategoryDTO;
import dto.ProductDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;
import utils.PasswordUtils;

/**
 *
 * @author tungi
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    public static final String LOGIN_PAGE = "login.jsp";
    public static final String SEARCH_PAGE = "search.jsp";

    public UserDTO getUser(String strUserName) {
        UserDAO udao = new UserDAO();
        UserDTO user = udao.readByName(strUserName);
        return user;
    }

    public boolean isValidLogin(String strUserID, String strPassword) {
        UserDTO user = getUser(strUserID);
        System.out.println(user);
        return user != null && user.getPassword().equals(strPassword);
    }

    public boolean create(UserDTO entity) {

        UserDAO udao = new UserDAO();
        if (udao.isUserExists(entity.getUserName())) {
            System.out.println("UserName đã tồn tại!");
            return false;
        }
        return true;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = LOGIN_PAGE;
            UserDAO userDAO = new UserDAO();
            try {
                String action = request.getParameter("action");
                if (action == null) {
                    url = LOGIN_PAGE;
                } else {
                    if (action.equals("login")) {
                        String userName = request.getParameter("txtUserName");
                        String passWord = request.getParameter("txtPassword");
                        System.out.println(userName);
                        System.out.println(passWord);
                        if (AuthUtils.isValidLogin(userName, passWord)) {
                            HttpSession session = request.getSession();
                            url = "menu.jsp";
                            UserDTO user = AuthUtils.getUser(userName);
                            request.getSession().setAttribute("user", user);
                            request.getSession().setAttribute("role", user.getRole());
                        } else {
                            request.setAttribute("errorMessage", "Invalid UserName or Password !");
                            url = "login.jsp";
                        }
                    } else if (action.equals("Register")) {
                        url = "register.jsp";
                    } else if (action.equals("logout")) {
                        request.getSession().invalidate();
                        url = "login.jsp";
                    } else if (action.equals("register-account")) {
                        String username = request.getParameter("txtUserName");
                        String password = request.getParameter("txtPassword");
                        String fullName = request.getParameter("txtFullName");
                        String phoneNumber = request.getParameter("txtPhoneNumber");
                        String email = request.getParameter("txtEmail");
                        String confirmPassword = request.getParameter("txtConfirmPassword");

                        System.out.println(username);
                        System.out.println(password);
                        System.out.println(fullName);
                        System.out.println(phoneNumber);
                        System.out.println(email);
                        System.out.println(confirmPassword);
                        boolean isCheckError = false;

                        //kiểm tra confirm Password có giống password cũ ko?
                        if (!password.equals(confirmPassword)) {
                            isCheckError = true;
                            request.setAttribute("confirm_ErrorMessage", "Confirm Password must be equal to Password !");
                        }
                        //kiểm tra password
                        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
                            isCheckError = true;
                            request.setAttribute("confirmPassword_ErrorMessage", "ConfirmPassword can't be null !");
                        }
                        //kiểm tra xem userName có bị trùng không ?
                        if (userDAO.isUserExists(username)) {
                            isCheckError = true;
                            request.setAttribute("userName_ExisterrorMessage", "This username is used !");
                        }
                        // Kiểm tra username có bị null ko
                        if (username == null || username.trim().isEmpty()) {
                            isCheckError = true;
                            request.setAttribute("userName_ErrorMessage", "Username can't be Empty !");
                        }

                        // Kiểm tra mật khẩu (độ dài tối thiểu 6 ký tự)
                        if (password == null || password.length() < 6) {
                            isCheckError = true;
                            request.setAttribute("password_errorMessage", "Password can't be Empty!");
                        }

                        // Kiểm tra fullname
                        if (fullName == null || fullName.trim().isEmpty()) {
                            isCheckError = true;
                            request.setAttribute("fullname_errorMessage", "FullName can't be Empty ");
                        }

                        // Kiểm tra số điện thoại (chỉ chứa số, độ dài hợp lệ)
                        if (phoneNumber == null || !phoneNumber.matches("\\d{10,11}")) {
                            isCheckError = true;
                            request.setAttribute("phoneNumber_errorMessage", "PhoneNumber is Invalid");
                        }

                        // Kiểm tra email đúng định dạng
                        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                            isCheckError = true;
                            request.setAttribute("email_errorMessage", "Email is Invalid !");
                        }
                        //kiểm tra email có bị trùng hay không ?
                        if (userDAO.isEmailExists(email)) {
                            isCheckError = true;
                            request.setAttribute("Email_ExisterrorMessage", "This Email is used !");
                        }
                        System.out.println(isCheckError);
                        // Nếu có lỗi, quay lại trang đăng ký
                        if (!isCheckError) {
                            // Nếu hợp lệ, tiếp tục xử lý đăng ký (thêm vào database)
                            UserDTO user = new UserDTO(username, PasswordUtils.hashPassword(password), fullName, phoneNumber, email, "User");
                            boolean isCreated = userDAO.create(user);
                            System.out.println(isCreated);
                            if (isCreated) {
                                request.setAttribute("Message", "Register Successfully!");
                            } else {
                                request.setAttribute("Message", "Registration failed, please try again!");
                            }
                        } else {
                                request.setAttribute("txtUserName", username);
                                request.setAttribute("txtFullName", fullName);
                                request.setAttribute("txtPhoneNumber", phoneNumber);
                                request.setAttribute("txtEmail", email);
                                url = "register.jsp";
                            }
                            url = "register.jsp";
                        }
//                    }else if()

                }
            } catch (Exception e) {
                log("Error in MainController: " + e.toString());
            } finally {
                System.out.println("Redirecting to: " + url); // Kiểm tra URL trước khi forward
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tạo 1 cái tài khoản để demo ko đăng nhập:
        UserDTO user1 = new UserDTO(1, "admin", "admin123", "Administrator",
                "1122334455", "example@gmail.com", "Staff");
        UserDTO user2 = new UserDTO(2, "john_doe", "password123", "John Doe",
                "0987654321", "example@gmail.com", "User");
        HttpSession se = request.getSession();
        se.setAttribute("account", user1);
        //
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO pdao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();
        List<ProductDTO> listP = pdao.readAll();
        List<CategoryDTO> listCate = cdao.readAll();
        ProductDTO newPro = pdao.getNewProduct();
        request.setAttribute("newPro", newPro);
        request.setAttribute("listProduct", listP);
        request.setAttribute("listCategory", listCate);
        request.getRequestDispatcher("views/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
