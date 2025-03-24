<%-- 
    Document   : detail
    Created on : Mar 17, 2025, 8:17:17 PM
    Author     : PhamBaoPhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/assets/css/style-home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <main>
            <jsp:include page="left.jsp"></jsp:include>
                <section class="product-list">
                    <!-- Product Detail -->
                    <div class="col-md-9">
                        <div class="card">
                            <div class="row no-gutters">
                                <div class="col-md-6">
                                    <img src="${pFound.getProductImage()}" class="img-fluid" alt="${pFound.getProductName()}">
                            </div>
                            <div class="col-md-6 p-4">
                                <h3>${pFound.getProductName()}</h3>
                                <h5><strong>Category: </strong>${pFound.getCategoryName()}</h5>
                                <p class="text-warning">Price: ${pFound.getUnitPrice()}$</p>
                                <p>${pFound.getDescription()}.</p>
                                <div class="mt-3">
                                    <form action="cart" method="POST">
                                        <label for="quantity"><strong>Quantity: </strong></label>
                                        <input name="quantity" id="quantity" class="form-control w-25 d-inline" type="number" value="1">
                                        </input>
                                        <div>
                                            <span class="btn btn-primary">BUY NOW</span>
                                            <span  onclick="actionProduct(event, this, 'add', '${pFound.getProductID()}')" class="btn btn-outline-primary">ADD TO CART</span>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
    </body>
</html>
