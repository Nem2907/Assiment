<%-- 
    Document   : userOrders
    Created on : Mar 27, 2025, 11:07:00 AM
    Author     : hoang
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.OrderDTO" %>

<html>
<head>
    <title>My Orders</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/userOrder.css">
</head>
<body>
    <div class="container">
        <h1>My Orders</h1>
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Shipped Date</th>
                <th>Freight</th>
                <th>Shipping Address</th>
            </tr>
            <%
                List<OrderDTO> orders = (List<OrderDTO>) request.getAttribute("orders");
                if (orders != null && !orders.isEmpty()) {
                    for (OrderDTO order : orders) {
            %>
            <tr>
                <td><%= order.getOrderID()%></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.getShippedDate() != null ? order.getShippedDate() : "Not shipped yet" %></td>
                <td>$<%= order.getFreight() %></td>
                <td><%= order.getShipAddress() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="6">No orders found.</td></tr>
            <%
                }
            %>
        </table>
        <a href="MainController">Back to Home</a>
    </div>
</body>
</html>
 
