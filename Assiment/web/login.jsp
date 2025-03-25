<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login-PizzaStore</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body{
                background: url(assess/2ffa5105e1ab6b4634eebdb911526acd.jpg) center center fixed;
                background-size: calc(50%);
            }
            .col-md-6.h3{
                align-content: center;
            }
            .col-md-6.p{
                align-content: center;
            }

            .message {
                padding: 5px; /* T?o kho?ng cách h?p lý */
                border-radius: 3px; /* Làm góc bo tròn nh? */
                font-size: 14px;
                width: fit-content; /* Ch? v?a v?i n?i dung */
            }
        </style>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
            <div class="container">
                <a class="navbar-brand" href="#">Fast Food Online</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item"><a class="nav-link" href="MainController">Home</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="categoriesDropdown" role="button" data-bs-toggle="dropdown">
                                Categories
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Food</a></li>
                                <li><a class="dropdown-item" href="#">Drink</a></li>
                                <li><a class="dropdown-item" href="#">Pizza</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="#">Reviews</a></li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Log in</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Login Form -->
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6" style="background: whitesmoke">
                    <h3>Please log in here.</h3>
                    <p>Enter your details below</p>
                    <form action="MainController" method="POST">                         

                        <input type="hidden" name="action" value="login">

                        <div class="mb-3">
                            <label for="username" class="form-label">User Name</label>
                            <input type="text" class="form-control" id="username" name="txtUserName" placeholder="Enter your username">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="txtPassword" placeholder="Enter your password">
                        </div>
                        <div>
                            <button type="submit" class="btn btn-primary">Log in</button>
                        </div>

                    </form>
                    <%
                        String message = (String) request.getAttribute("errorMessage") + "";
                    %>  
                    <%
                        if (message != null && !message.equals("null") && !message.isEmpty()) {
                    %>
                    <div class="message">
                        <div class="p-3 mb-2 bg-danger text-white"><%= message%></div>
                    </div>
                    <%
                        }
                    %>

                    <%
                        String Message = (String) request.getAttribute("Message") + "";

                    %>
                    <%                                            if (Message != null && !Message.equals("null") && !Message.isEmpty()) {
                    %>
                    <div class="message">
                        <div class="p-3 mb-2 bg-success text-white"><%= Message%></div>
                    </div>
                    <%
                        }
                    %>
                    <div>
                        <p class="text-muted">
                            If you don't have an account, 
                            <a href="register.jsp" class="fw-bold btn btn-outline-dark px-3 py-1">Register Here!</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
