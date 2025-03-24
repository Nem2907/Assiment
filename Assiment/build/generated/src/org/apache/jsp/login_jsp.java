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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Login-PizzaStore</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background: url(assess/2ffa5105e1ab6b4634eebdb911526acd.jpg) center center fixed;\n");
      out.write("                background-size: calc(50%);\n");
      out.write("            }\n");
      out.write("            .col-md-6.h3{\n");
      out.write("                align-content: center;\n");
      out.write("            }\n");
      out.write("            .col-md-6.p{\n");
      out.write("                align-content: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .message {\n");
      out.write("                padding: 5px; /* T?o kho?ng cách h?p lý */\n");
      out.write("                border-radius: 3px; /* Làm góc bo tròn nh? */\n");
      out.write("                font-size: 14px;\n");
      out.write("                width: fit-content; /* Ch? v?a v?i n?i dung */\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-danger\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Fast Food Online</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("                    <ul class=\"navbar-nav me-auto\">\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Home</a></li>\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"categoriesDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\n");
      out.write("                                Categories\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Food</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Drink</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Pizza</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Reviews</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"register.jsp\">Register</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Log in</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!-- Login Form -->\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-md-6\" style=\"background: whitesmoke\">\n");
      out.write("                    <h3>Please log in here.</h3>\n");
      out.write("                    <p>Enter your details below</p>\n");
      out.write("                    <form action=\"MainController\" method=\"post\">                         \n");
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"login\">\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"username\" class=\"form-label\">User Name</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"txtUserName\" placeholder=\"Enter your username\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"password\" class=\"form-label\">Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"txtPassword\" placeholder=\"Enter your password\">\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Log in</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    ");

                        String message = (String) request.getAttribute("errorMessage") + "";
                    
      out.write("  \n");
      out.write("                    ");

                        if (message != null && !message.equals("null") && !message.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <div class=\"message\">\n");
      out.write("                        <div class=\"p-3 mb-2 bg-danger text-white\">");
      out.print( message);
      out.write("</div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");

                        String Message = (String) request.getAttribute("Message") + "";
                        
                    
      out.write("\n");
      out.write("                                        ");

                        if (Message != null && !Message.equals("null") && !Message.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <div class=\"message\">\n");
      out.write("                        <div class=\"p-3 mb-2 bg-success text-white\">");
      out.print( Message);
      out.write("</div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <p class=\"text-muted\">\n");
      out.write("                            If you don't have an account, \n");
      out.write("                            <a href=\"register.jsp\" class=\"fw-bold btn btn-outline-dark px-3 py-1\">Register Here!</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
