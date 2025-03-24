<%@page import="dto.UserDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register - PizzaStore</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background: url('assess/2ffa5105e1ab6b4634eebdb911526acd.jpg') center center fixed;
                background-size: cover;
            }
            .form-container {
                background: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }
            /* Ch? hi?n màu ?? khi input b? invalid */
            input:invalid {
                border: 1px solid red;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
            <div class="container">
                <a class="navbar-brand" href="login.jsp">Fast Food Online</a>
            </div>
        </nav>

        <%
            //l?i confirm Password ko gi?ng nhau
            String confirm_ErrorMessage = request.getAttribute("confirm_ErrorMessage") + "";
            confirm_ErrorMessage = confirm_ErrorMessage.equals("null") ? "" : confirm_ErrorMessage;
            //l?i confirm Password null
            String confirmPassword_ErrorMessage = request.getAttribute("confirmPassword_ErrorMessage") + "";
            confirmPassword_ErrorMessage = confirmPassword_ErrorMessage.equals("null") ? "" : confirmPassword_ErrorMessage;
            //check l?i b? trùng id
            String userName_ExisterrorMessage = (String) request.getAttribute("userName_ExisterrorMessage");
            if (userName_ExisterrorMessage == null) {
                userName_ExisterrorMessage = "";
            }
            //check l?i userName có b? null ko ?
            String userName_ErrorMessage = request.getAttribute("userName_ErrorMessage") + "";
            userName_ErrorMessage = userName_ErrorMessage.equals("null") ? "" : userName_ErrorMessage;
            //check password có ?? ký t? không
            String password_errorMessage = request.getAttribute("password_errorMessage") + "";
            password_errorMessage = password_errorMessage.equals("null") ? "" : password_errorMessage;
            //check full Name có b? null ko
            String fullname_errorMessage = request.getAttribute("fullname_errorMessage") + "";
            fullname_errorMessage = fullname_errorMessage.equals("null") ? "" : fullname_errorMessage;
            //check s? di?n tho?i có b? sai form ko
            String phoneNumber_errorMessage = request.getAttribute("phoneNumber_errorMessage") + "";
            phoneNumber_errorMessage = phoneNumber_errorMessage.equals("null") ? "" : phoneNumber_errorMessage;
            //ki?m tra gamil
            String email_errorMessage = request.getAttribute("email_errorMessage") + "";
            email_errorMessage = email_errorMessage.equals("null") ? "" : email_errorMessage;

            String Email_ExisterrorMessage = request.getAttribute("Email_ExisterrorMessage") + "";
            Email_ExisterrorMessage = Email_ExisterrorMessage.equals("null") ? "" : Email_ExisterrorMessage;

            String message = (String) request.getAttribute("Message");
        %>

        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6 form-container">
                    <h3 class="text-center">Register</h3>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="register-account"/>

                        <div class="mb-3">
                            <label class="form-label">User Name</label>
                            <input type="text" class="form-control" name="txtUserName"placeholder="Enter your username">
                            <% if (!userName_ExisterrorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= userName_ExisterrorMessage%></span>
                            <% } %>
                            <br/>
                            <% if (!userName_ErrorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= userName_ErrorMessage%></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" class="form-control" name="txtPassword" placeholder="Enter your password">
                            <% if (!password_errorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= password_errorMessage%></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" name="txtConfirmPassword" placeholder="Confirm your password">
                            <% if (!confirm_ErrorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= confirm_ErrorMessage%></span>
                            <% } %>
                            <br/>
                            <% if (!confirmPassword_ErrorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= confirmPassword_ErrorMessage%></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input type="text" class="form-control" name="txtFullName" placeholder="Enter your full name">
                            <% if (!fullname_errorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= fullname_errorMessage%></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Phone Number</label>
                            <input type="number" class="form-control" name="txtPhoneNumber" placeholder="Enter your phone number">
                            <% if (!phoneNumber_errorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= phoneNumber_errorMessage%></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" name="txtEmail" placeholder="Enter your email">
                            <% if (!email_errorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= email_errorMessage%></span>
                            <% } %>
                            <% if (!Email_ExisterrorMessage.isEmpty()) {%>
                            <span class="bg-danger text-white p-1 d-block"><%= Email_ExisterrorMessage%></span>
                            <% } %>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                        <div class="text-center mt-3">
                            <p>Already have an account? <a href="login.jsp" class="btn btn-info">Login Here!</a></p>
                        </div>
                    </form>
                        <%
                            if (message != null && !message.trim().isEmpty()) {
                        %>
                        <span class="bg-success text-white p-1 d-block"><%= message%></span>
                        <%
                            }
                        %>
                </div>
            </div>
        </div>






        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
