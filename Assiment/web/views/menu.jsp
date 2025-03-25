<%-- 
    Document   : menu
    Created on : Mar 17, 2025, 9:18:19 PM
    Author     : PhamBaoPhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="logo"><a href="MainController" style="color: white; text-decoration: none">Pizza</a></div>
    <div class="menu" >
        <ul class="navbar-nav d-flex flex-row align-items-center gap-3">
            <c:if test="${sessionScope.account.getRole() eq 'admin'}">
                <li class="nav-item">
                    <a class="nav-link" href="manager">Manager Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </c:if>   
            <c:if test="${sessionScope.account.getRole() eq 'user'}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello ${sessionScope.account.getFullName()}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.account == null}">
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </c:if>
        </ul>

        <form action="search" method="POST">
            <div class="input-group">
                <select name="filter" class="custom-select w-auto">
                    <option value="name" ${filter == 'name' ? 'selected' : ''}>Name</option>
                    <option value="price" ${filter == 'price' ? 'selected' : ''}>Price</option>
                </select>
                <input type="text" name="keyword" class="form-control" placeholder="Nhập từ khóa..." value="${keyword}">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <a class="btn btn-success btn-sm ml-3" href="cart">
            <i class="fa fa-shopping-cart"></i> Cart
        </a>
    </div>
</header>
