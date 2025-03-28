/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartDAO;
import dao.OrderDAO;
import dao.OrderDetailsDAO;
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
        totalAllProduct = listCart.stream().map((cartItem) -> cartItem.getTotal()).reduce(totalAllProduct, (accumulator, _item) -> accumulator + _item);
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
        request.setCharacterEncoding("UTF-8");

        try {
            String action = request.getParameter("action");
            System.out.println(action);
            if (action == null) {
                //return về trang home
                response.sendRedirect("MainController");
                return;
            }
            HttpSession se = request.getSession();
            UserDTO ac = (UserDTO) se.getAttribute("account");
            if (ac == null) {
                //return về trang login
                response.sendRedirect("login.jsp");
                return;
            }
            String cartItemId = request.getParameter("cartItemId");
            CartDAO cartDao = new CartDAO();
            int id = 0;
            if (!(cartItemId == null)) {
                id = Integer.parseInt(cartItemId);
            }
            if (action.trim().equalsIgnoreCase("update")) {
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
                response.sendRedirect("cart");
                return;
            } else if (action.trim().equalsIgnoreCase("delete")) {
//                cartDao.delete(id);
//                return;
                cartDao.delete(id);

                // Lấy lại danh sách giỏ hàng sau khi xóa
                List<CartItemDTO> listCart = cartDao.getAllProductInCartByID(ac.getUserID());
                double totalAllProduct = listCart.stream().mapToDouble(CartItemDTO::getTotal).sum();
                String formattedTotal = String.format("%.2f", totalAllProduct);
                request.setAttribute("totalAllProduct", formattedTotal);
                // Cập nhật lại dữ liệu trong request
                request.setAttribute("listCart", listCart);
                request.setAttribute("totalAllProduct", totalAllProduct);

                // Forward về cart.jsp để cập nhật UI ngay lập tức
                request.getRequestDispatcher("views/cart.jsp").forward(request, response);
                return;
            } else if (action.trim().equalsIgnoreCase("add")) {
                String productIdSTR = request.getParameter("productId");
                String quantitySTR = request.getParameter("quantity");
                if (quantitySTR == null) {
                    quantitySTR = "1";
                }
                if (!(productIdSTR == null)) {
                    int quantity = Integer.parseInt(quantitySTR.trim());
                    int productID = Integer.parseInt(productIdSTR.trim());
                    cartDao.addItemToCart(ac.getUserID(), productID, quantity);

                    // Thêm thông báo vào session
                    se.setAttribute("message", "Pizza đã được thêm vào giỏ hàng!");
                }
                response.sendRedirect("MainController");
                return;
            }else if (action.equals("buy")) {
                Integer accountIdObj = ac.getUserID(); // Nếu ac không null
                if (accountIdObj == null) {
                    request.setAttribute("message", "You need to log in before purchasing!");
                    request.getRequestDispatcher("/login.jsp");
                    return;
                }
                int accountId = accountIdObj; // Ép kiểu an toàn
                System.out.println(accountId);
                String shipAddress = request.getParameter("shipAddress");
                CartDAO cartDAO = new CartDAO();
                OrderDAO orderDAO = new OrderDAO();
                OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
                List<CartItemDTO> cartItems = cartDAO.getAllProductInCartByID(accountId);
                if (cartItems.isEmpty()) {
                    request.setAttribute("message", "Your cart is empty!");
                    request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
                    return;
                }

                // Tạo đơn hàng mới
                double freight = 5.0; // Phí vận chuyển mặc định
                String orderId = orderDAO.createOrder(accountId, shipAddress, freight);

                if (orderId != null) {
                    for (CartItemDTO cartItem : cartItems) {
                        orderDetailsDAO.addOrderDetail(orderId, cartItem.getProductId(), cartItem.getQuantity(), cartItem.getTotal());
                    }
                    cartDAO.clearCart(accountId); // Xóa giỏ hàng sau khi mua
                    request.setAttribute("orderId", orderId);
                    request.setAttribute("shipAddress", shipAddress);
                    request.setAttribute("totalAmount", cartItems.stream().mapToDouble(CartItemDTO::getTotal).sum());
                    request.setAttribute("cartItems", cartItems);

                    request.getRequestDispatcher("views/orderConfirmation.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("message", "Purchase failed!");
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                }
            } 
            response.sendRedirect("MainController");
            return ;
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
