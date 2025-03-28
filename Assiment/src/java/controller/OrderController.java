package controller;

import dao.OrderDAO;
import dto.OrderDTO;
import dto.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        OrderDAO orderDAO = new OrderDAO();
        List<OrderDTO> orders = orderDAO.getOrdersByAccount(user.getUserID());

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("views/userOrders.jsp").forward(request, response);
    }
}
