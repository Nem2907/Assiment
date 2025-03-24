<%@page import="dto.UserDTO"%>
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
                        <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
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
                    </ul>
                    <ul class="navbar-nav align-items-center">
                        <%
                            UserDTO user = (UserDTO) session.getAttribute("user");
                            if (user != null) {
                        %>
                        <li class="nav-item">
                            <span class="text-white me-3">Welcome <strong><%= user.getFullName()%></strong></span>
                        </li>
                        <a class="nav-link text-white" href="MainController?action=logout">Log out</a>
                        <%}%>
                    </ul>

                    <!-- set l?i tk này ?? làm ph?n logout-->

                </div>
            </div>
        </nav>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
