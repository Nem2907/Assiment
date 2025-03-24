<%-- 
    Document   : home
    Created on : Mar 17, 2025, 12:38:09 PM
    Author     : PhamBaoPhi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Product Managerment</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/assets/css/manager.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6" id="#top">
                            <a href="manager?view=add"  class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                            <a href="#bottom" style="color: blue"><button type="button" class="btn btn-primary">To bottom</button>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>${o.getProductID()}</td>
                                <td><a href="detail?pid=${o.getProductID()}" title="View Product">${o.getProductName()}</a>
                                </td>
                                <td>
                                    <img src="${o.getProductImage()}">
                                </td>
                                <td>${o.getUnitPrice()} dollar</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/manager" method="POST">
                                        <a href="${pageContext.request.contextPath}/manager?view=edit&productID=${o.getProductID()}"  class="edit" >
                                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                        </a>
                                        <span onclick="actionProduct(event, this, 'delete', '${o.getProductID()}')" class="delete">
                                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                        </span>
                                    </form>


                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div id="bottom">
                <a href="MainController"><button type="button" class="btn btn-primary">Back to home</button>
                <a href="#top"><button type="button" class="btn btn-light">Back to top</button>
            </div>
        </div>
    </a>
    <script src="${pageContext.request.contextPath}/assets/js/util.js" type="text/javascript"></script>
</body>
</html>