<%-- 
    Document   : left
    Created on : Mar 17, 2025, 10:31:54 PM
    Author     : PhamBaoPhi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside>
    <div>
        <div class="category-container">
            <button class="category-btn"><i class="fas fa-bars"></i> CATEGORIES</button>
            <div class="category-dropdown">
                <ul>
                    <c:forEach items="${requestScope.listCategory}" var="c">
                        <li>
                            <a href="category?cid=${c.getCategoryID()}">${c.getCategoryName()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    <br>
    <div>

        <div class="latest-product">
            <h3>LATEST PRODUCT</h3>
            <c:if test="${not empty newPro}">
                <div><img src="${newPro.getProductImage()}" class="img-fluid" alt="${newPro.getProductName()}"></div>
                <h3>
                    <a href="detail?pid=${newPro.getProductID()}" title="View Product">
                        ${newPro.getProductName()} 
                    </a>
                </h3><br>
                <p><strong>Category:</strong> ${newPro.getCategoryName()}</p><br>
                <form action="cart" method="Post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="productId" value="${newPro.getProductID()}">
                    <button  class="add-btn">Add Pizza</button><br>
                </form>
            </c:if>

            <p>Try our latest product.<br>Especially delicious.</p>
            <strong><span>$${newPro.getUnitPrice()}</span></strong>
        </div>
    </section>
</aside>
