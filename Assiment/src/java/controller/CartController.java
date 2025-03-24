/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartDAO;
import dto.CartItemDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PhamBaoPhi
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession se = request.getSession();
        UserDTO ac = (UserDTO) se.getAttribute("account");
        if (ac == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        CartDAO cartDao = new CartDAO();
        List<CartItemDTO> listCart = cartDao.getAllProductInCartByID(ac.getUserID());
        double totalAllProduct = 0;
        for (CartItemDTO cartItem : listCart) {
            totalAllProduct += cartItem.getTotal();
        }
        System.out.println(listCart);
        request.setAttribute("listCart", listCart);
        request.setAttribute("totalAllProduct", totalAllProduct);
        request.getRequestDispatcher("views/cart.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            if (action == null) {
                //return về trang home
                response.sendRedirect("home");
                return;
            }
            HttpSession se = request.getSession();
            UserDTO ac = (UserDTO) se.getAttribute("account");
            if (ac == null) {
                //return về trang login
                response.sendRedirect("login.jsp");
                return;
            }
            action = action.trim();
            String cartItemId = request.getParameter("cartItemId");
            CartDAO cartDao = new CartDAO();
            int id = 0;
            if (!(cartItemId == null)) {
                id = Integer.parseInt(cartItemId);
            }
            switch (action) {
                case "update":
                    String quantityUpdate_str = request.getParameter("quantity");
                    if (quantityUpdate_str == null) {
                        quantityUpdate_str = "0";
                    }
                    int quantityUpdate = Integer.parseInt(quantityUpdate_str.trim());
                    if (quantityUpdate == 0) {
                        cartDao.delete(id);
                    } else {
                        cartDao.update(id, quantityUpdate);
                    }
                    break;
                case "delete":
                    cartDao.delete(id);
                    break;
                case "add":
                    String productIdSTR = request.getParameter("productId");
                    String quantitySTR = request.getParameter("quantity");
                    if (quantitySTR == null) {
                        quantitySTR = "1";
                    }
                    if (!(productIdSTR == null)) {
                        int quantity = Integer.parseInt(quantitySTR.trim());
                        int productID = Integer.parseInt(productIdSTR.trim());
                        cartDao.addItemToCart(ac.getUserID(), productID, quantity);
                    }
                    break;
                default:
                    throw new Exception();
            }
            response.sendRedirect("cart");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("cart");
        }
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
