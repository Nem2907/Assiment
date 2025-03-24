package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Login-PizzaStore</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body{\r\n");
      out.write("                background: url(assess/2ffa5105e1ab6b4634eebdb911526acd.jpg) center center fixed;\r\n");
      out.write("                background-size: calc(50%);\r\n");
      out.write("            }\r\n");
      out.write("            .col-md-6.h3{\r\n");
      out.write("                align-content: center;\r\n");
      out.write("            }\r\n");
      out.write("            .col-md-6.p{\r\n");
      out.write("                align-content: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .message {\r\n");
      out.write("                padding: 5px; /* T?o kho?ng cách h?p lý */\r\n");
      out.write("                border-radius: 3px; /* Làm góc bo tròn nh? */\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                width: fit-content; /* Ch? v?a v?i n?i dung */\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-danger\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Fast Food Online</a>\r\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\">\r\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                    <ul class=\"navbar-nav me-auto\">\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"MainController\">Home</a></li>\r\n");
      out.write("                        <li class=\"nav-item dropdown\">\r\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"categoriesDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("                                Categories\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Food</a></li>\r\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Drink</a></li>\r\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Pizza</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Reviews</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"navbar-nav\">\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"register.jsp\">Register</a></li>\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Log in</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <!-- Login Form -->\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <div class=\"row justify-content-center\">\r\n");
      out.write("                <div class=\"col-md-6\" style=\"background: whitesmoke\">\r\n");
      out.write("                    <h3>Please log in here.</h3>\r\n");
      out.write("                    <p>Enter your details below</p>\r\n");
      out.write("                    <form action=\"MainController\" method=\"post\">                         \r\n");
      out.write("\r\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"login\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label for=\"username\" class=\"form-label\">User Name</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"txtUserName\" placeholder=\"Enter your username\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label for=\"password\" class=\"form-label\">Password</label>\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"txtPassword\" placeholder=\"Enter your password\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Log in</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("                    ");

                        String message = (String) request.getAttribute("errorMessage") + "";
                    
      out.write("  \r\n");
      out.write("                    ");

                        if (message != null && !message.equals("null") && !message.isEmpty()) {
                    
      out.write("\r\n");
      out.write("                    <div class=\"message\">\r\n");
      out.write("                        <div class=\"p-3 mb-2 bg-danger text-white\">");
      out.print( message);
      out.write("</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    ");

                        String Message = (String) request.getAttribute("Message") + "";
                        
                    
      out.write("\r\n");
      out.write("                                        ");

                        if (Message != null && !Message.equals("null") && !Message.isEmpty()) {
                    
      out.write("\r\n");
      out.write("                    <div class=\"message\">\r\n");
      out.write("                        <div class=\"p-3 mb-2 bg-success text-white\">");
      out.print( Message);
      out.write("</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <p class=\"text-muted\">\r\n");
      out.write("                            If you don't have an account, \r\n");
      out.write("                            <a href=\"register.jsp\" class=\"fw-bold btn btn-outline-dark px-3 py-1\">Register Here!</a>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
