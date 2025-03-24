package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
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
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Home</a></li>\r\n");
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
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"navbar-nav align-items-center\">\r\n");
      out.write("                        ");

                            UserDTO user = (UserDTO) session.getAttribute("user");
                            if (user != null) {
                        
      out.write("\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <span class=\"text-white me-3\">Welcome <strong>");
      out.print( user.getFullName());
      out.write("</strong></span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <a class=\"nav-link text-white\" href=\"MainController?action=logout\">Log out</a>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                    <!-- set l?i tk này ?? làm ph?n logout-->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
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
