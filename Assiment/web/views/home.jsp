<%-- 
    Document   : home.jsp
    Created on : Mar 17, 2025
    Author     : PhamBaoPhi
--%>

<%@page import="dao.ProductDAO"%>
<%@page import="dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    ProductDAO pdao = new ProductDAO();
    if (request.getAttribute("listProduct") == null) {
        List<ProductDTO> products = pdao.readAll();
        request.setAttribute("listProduct", products);
    }
%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Menu</title>
        <!-- Bootstrap & FontAwesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/assets/css/style-home.css?v=125" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <!-- Include menu -->
        <jsp:include page="menu.jsp"></jsp:include>
        <%-- Kiểm tra xem có thông báo trong session không --%>
        <c:if test="${not empty sessionScope.message}">
            <div class="alert alert-success text-center" id="alertMessage">
                ${sessionScope.message}
            </div>
            <%-- Xóa thông báo sau khi hiển thị --%>
            <c:remove var="message" scope="session"/>
            <script>
                // Ẩn thông báo sau 3 giây
                setTimeout(() => {
                    document.getElementById("alertMessage").style.display = "none";
                }, 3000);
            </script>
        </c:if>

        <main class="d-flex">
            <!-- Sidebar -->
            <div>
                <jsp:include page="left.jsp"></jsp:include>
                </div>

                <!-- Product List -->
                <section class="product-list" style="text-align: center">
                    <h2 class="text-center">Pizza Menu</h2>
                    <div class="products" id="#">
                    <c:forEach items="${requestScope.listProduct}" var="p">
                        <div class="product-card">
                            <img src="${p.getProductImage()}" class="img-fluid" alt="${p.getProductName()}">
                            <h3>
                                <a href="detail?pid=${p.getProductID()}" title="View Product">${p.getProductName()}</a>
                                <span>${p.getUnitPrice()}$</span>
                            </h3>
                            <p><strong>Category:</strong> ${p.getCategoryName()}</p>
                            <form action="cart" method="POST">
                                <input type="hidden" name="action" value="add">
                                <input type="hidden" name="productId" value="${p.getProductID()}">
                                <button class="btn btn-primary w-100">Add Pizza</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </main>

        <div style="text-align: center">
            <a href="#"><button type="button" class="btn btn-light">Back to top</button>
        </div>

        <!-- Include Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
