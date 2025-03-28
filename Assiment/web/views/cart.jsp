
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="${pageContext.request.contextPath}/assets/css/style-home.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <jsp:include page="menu.jsp"></jsp:include>

            <div class="shopping-cart">
                <div class="container py-5">
                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm">

                            <!-- Bảng giỏ hàng -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="border-0 bg-light">No</th>
                                            <th class="border-0 bg-light">Product</th>
                                            <th class="border-0 bg-light">Total Price</th>
                                            <th class="border-0 bg-light">Date Added</th>
                                            <th class="border-0 bg-light">Quantity</th>
                                            <th class="border-0 bg-light">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${requestScope.listCart}" varStatus="loop">
                                        <tr>
                                            <td class="align-middle"><strong>${loop.index+1}</strong></td>
                                            <td>
                                                <div class="p-2">
                                                    <img src="${item.getProductImage()}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0"><a href="detail?pid=${item.getProductId()}" class="text-dark">${item.getProductName()}</a></h5>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="align-middle"><strong>${item.getTotal()} $</strong></td>
                                            <td class="align-middle"><strong>${item.getDate()}</strong></td>
                                            <td class="align-middle">
                                                <form action="cart" method="post" class="d-flex align-items-center">
                                                    <input type="hidden" name="cartItemId" value="${item.getId()}">
                                                    <input type="hidden" name="action" value="update">
                                                    <!-- Ô nhập số lượng -->
                                                    <input type="number" name="quantity" value="${item.getQuantity()}" class="form-control mx-2 text-center quantity-input" style="width: 60px;">
                                                    <!-- Nút cập nhật (ẩn, chỉ submit khi số lượng thay đổi) -->
                                                    <button type="submit" class="btn btn-sm btn-primary mx-2 update-btn" >✔</button>
                                                </form>
                                            </td>
                                            <td class="align-middle">
                                                <form action="cart" method="post">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input type="hidden" name="cartItemId" value="${item.getId()}">
                                                    <button type="submit" class="btn btn-danger">Delete</button>
                                                </form>
                                            </td>
                                        </tr> 
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- Hiển thị tổng tiền -->
                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Bill</div>
                        <div class="p-4">
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom">
                                    <strong class="text-muted">Total Money: </strong>
                                    <h5 class="font-weight-bold"> 
                                        ${requestScope.totalAllProduct} Dollar</h5>
                                </li>
                            </ul>
                            <form action="cart" method="POST">
                                <input type="hidden" name="action" value="buy">
                                <input type="hidden" name="productId" value="${pDetail.getProductID()}">
                                <h3>Enter Shipping Address</h3>
                                <input type="text" id="shipAddress" name="shipAddress" class="input-field" required placeholder="Enter your address">
                                <button type="submit" class="btn btn-dark rounded-pill py-2 btn-block">Purchase</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    </body>
</html>
