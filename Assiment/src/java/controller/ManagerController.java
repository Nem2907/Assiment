/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import dto.CategoryDTO;
import dto.ProductDTO;
import dto.SupplierDTO;
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
public class ManagerController extends HttpServlet {

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
            out.println("<title>Servlet ManagerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerController at " + request.getContextPath() + "</h1>");
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
        String view = request.getParameter("view") == null ? "" : request.getParameter("view").trim();
        //
        ProductDAO pdao = new ProductDAO();
        CategoryDAO cadao = new CategoryDAO();
        SupplierDAO sudao = new SupplierDAO();
        HttpSession se = request.getSession();
        //
        //ktr user
        UserDTO ac = (UserDTO) se.getAttribute("account");
        if (ac == null) {
            response.sendRedirect("login");
            return;
        }
        //
        if (view.equalsIgnoreCase("add")) {
            List<CategoryDTO> listCate = cadao.readAll();
            request.setAttribute("listCategory", listCate);
            List<SupplierDTO> listSup = sudao.readAll();
            request.setAttribute("listSupplier", listSup);
            request.getRequestDispatcher("views/add.jsp").forward(request, response);
        } else if (view.equalsIgnoreCase("edit")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            ProductDTO p = pdao.readById(productID);
            request.setAttribute("pDetail", p);
            List<CategoryDTO> listCate = cadao.readAll();
            request.setAttribute("listCategory", listCate);
            List<SupplierDTO> listSup = sudao.readAll();
            request.setAttribute("listSupplier", listSup);
            request.getRequestDispatcher("views/edit.jsp").forward(request, response);
        } else {
            //check lại cái account cho chắc:
            HttpSession sess = request.getSession();
            UserDTO acc = (UserDTO) sess.getAttribute("account");
            if (acc.getRole().equals("Staff")) {
                //load sản phẩm lên cho trang quản lý:
                List<ProductDTO> listProduct = pdao.readAll();
                request.setAttribute("listP", listProduct);
                request.getRequestDispatcher("views/manager.jsp").forward(request, response);
            } else {
                //quay lại trang web home:
                response.sendRedirect("MainController");
            }
        }
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            if (action == null) {
                //return về trang add
                response.sendRedirect("manager");
                return;
            }
            action = action.trim();
            ProductDAO pdao = new ProductDAO();
            //
            String productId = request.getParameter("productId");
            int id = 0;
            if (!(productId == null)) {
                id = Integer.parseInt(productId);
            }
            //
            String productName = request.getParameter("name");
            String supplierId = request.getParameter("supplierId");
            String categoryId = request.getParameter("categoryId");
            //
            String quantitySTR = request.getParameter("quantity");
            int quantity = 0;
            if (!(quantitySTR == null)) {
                quantity = Integer.parseInt(quantitySTR);
            }
            //
            String priceSTR = request.getParameter("price");
            double price = 0;
            if (!(priceSTR == null)) {
                price = Double.parseDouble(priceSTR);
            }
            //
            String imageLink = request.getParameter("image");
            String description = request.getParameter("description");
            switch (action) {
                case "edit":
                    ProductDTO pEdit = new ProductDTO(id, productName, supplierId, categoryId,
                            quantity, price, description, null, imageLink);
                    pdao.update(pEdit);
                    break;
                case "delete":
                    pdao.delete(id);
                    break;
                case "add":
                    ProductDTO pCreate = new ProductDTO(0, productName, supplierId, categoryId,
                            quantity, price, description, null, imageLink);
                    pdao.create(pCreate);
                    break;
                default:
                    throw new Exception();
            }
            response.sendRedirect("manager");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("manager");
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
