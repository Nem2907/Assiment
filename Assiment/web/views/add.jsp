
<%@page import="dto.UserDTO"%>
<%-- 
    Document   : home
    Created on : Mar 10, 2025, 1:57:28 PM
    Author     : PhamBaoPhi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link href="${pageContext.request.contextPath}/assets/css/style-add.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            // Lấy session
            UserDTO user = (UserDTO) session.getAttribute("account");

            // Nếu chưa đăng nhập hoặc không phải admin, chuyển về menu.jsp
            if (user == null || !"admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect(request.getContextPath() + "/MainController");
                return;
            }
        %>
        <div class="container">
            <h2>Add Product</h2>
            <form action="${pageContext.request.contextPath}/manager?action=add" method="POST">
                <div class="form-group">
                    <label>Name</label>
                    <input name="name" type="text" value="" required>
                </div>
                <div class="form-group">
                    <label>Supplier</label>
                    <select name="supplierId" required>
                        <c:forEach items="${requestScope.listSupplier}" var="s">
                            <option value="${s.getSupplierID()}">${s.getCompanyName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="categoryId" required>
                        <c:forEach items="${requestScope.listCategory}" var="c">
                            <option value="${c.getCategoryID()}">${c.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input name="quantity" value="" type="text" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name="price" value="" type="text" required>
                </div>
                <div class="form-group">
                    <label>Image URL</label>
                    <input name="image" value="" type="text" placeholder="Input link image" required>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input name="description" value="" type="text" placeholder="Input description..." required>
                </div>
                <input type="submit" class="btn" value="Add"></input>
                <button type="button" class="btn" onclick="window.history.back()"
                        style="background-color: red;margin-top: 20px">Cancel</button>
            </form>
        </div>
    </body>
</html>
