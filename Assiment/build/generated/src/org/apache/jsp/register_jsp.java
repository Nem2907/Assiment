package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Register - PizzaStore</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                background: url('assess/2ffa5105e1ab6b4634eebdb911526acd.jpg') center center fixed;\r\n");
      out.write("                background-size: cover;\r\n");
      out.write("            }\r\n");
      out.write("            .form-container {\r\n");
      out.write("                background: white;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("                border-radius: 10px;\r\n");
      out.write("                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            }\r\n");
      out.write("            /* Ch? hi?n màu ?? khi input b? invalid */\r\n");
      out.write("            input:invalid {\r\n");
      out.write("                border: 1px solid red;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-danger\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <a class=\"navbar-brand\" href=\"login.jsp\">Fast Food Online</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        ");

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
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <div class=\"row justify-content-center\">\r\n");
      out.write("                <div class=\"col-md-6 form-container\">\r\n");
      out.write("                    <h3 class=\"text-center\">Register</h3>\r\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"register-account\"/>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">User Name</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtUserName\"placeholder=\"Enter your username\">\r\n");
      out.write("                            ");
 if (!userName_ExisterrorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( userName_ExisterrorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                            <br/>\r\n");
      out.write("                            ");
 if (!userName_ErrorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( userName_ErrorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">Password</label>\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"txtPassword\" placeholder=\"Enter your password\">\r\n");
      out.write("                            ");
 if (!password_errorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( password_errorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">Confirm Password</label>\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"txtConfirmPassword\" placeholder=\"Confirm your password\">\r\n");
      out.write("                            ");
 if (!confirm_ErrorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( confirm_ErrorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                            <br/>\r\n");
      out.write("                            ");
 if (!confirmPassword_ErrorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( confirmPassword_ErrorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">Full Name</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtFullName\" placeholder=\"Enter your full name\">\r\n");
      out.write("                            ");
 if (!fullname_errorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( fullname_errorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">Phone Number</label>\r\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"txtPhoneNumber\" placeholder=\"Enter your phone number\">\r\n");
      out.write("                            ");
 if (!phoneNumber_errorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( phoneNumber_errorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"mb-3\">\r\n");
      out.write("                            <label class=\"form-label\">Email</label>\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" name=\"txtEmail\" placeholder=\"Enter your email\">\r\n");
      out.write("                            ");
 if (!email_errorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( email_errorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                            ");
 if (!Email_ExisterrorMessage.isEmpty()) {
      out.write("\r\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( Email_ExisterrorMessage);
      out.write("</span>\r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"text-center\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"text-center mt-3\">\r\n");
      out.write("                            <p>Already have an account? <a href=\"login.jsp\" class=\"btn btn-info\">Login Here!</a></p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                        ");

                            if (message != null && !message.trim().isEmpty()) {
                        
      out.write("\r\n");
      out.write("                        <span class=\"bg-success text-white p-1 d-block\">");
      out.print( message);
      out.write("</span>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
