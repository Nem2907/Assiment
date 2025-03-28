<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.CartItemDTO" %>
<html>
    <head>
        <title>Order Confirmation</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/orderConfirmation.css">
    </head>
    <body>
        <div class="container">
            <h1>Order Confirmation</h1>
            <p>Your order has been placed successfully.</p>

            <h2>Order Details</h2>
            <p>Order ID: <%= request.getAttribute("orderId")%></p>
            <p>Shipping Address: <%= request.getAttribute("shipAddress")%></p>
            <p>Total Amount: $<%= request.getAttribute("totalAmount")%></p>

            <h3>Items:</h3>
            <ul>
                <%
                    List<CartItemDTO> cartItems = (List<CartItemDTO>) request.getAttribute("cartItems");
                    if (cartItems != null) {
                        for (CartItemDTO item : cartItems) {
                %>
                <li><%= item.getProductName()%> - Quantity: <%= item.getQuantity()%> - Price: $<%= item.getTotal()%></li>
                    <%
                            }
                        }
                    %>
            </ul>

            <a href="MainController">Continue Order</a>
        </div>
    </body>
</html>
