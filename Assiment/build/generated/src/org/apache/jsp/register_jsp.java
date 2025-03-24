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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Register - PizzaStore</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background: url('assess/2ffa5105e1ab6b4634eebdb911526acd.jpg') center center fixed;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("            .form-container {\n");
      out.write("                background: white;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("            /* Ch? hi?n màu ?? khi input b? invalid */\n");
      out.write("            input:invalid {\n");
      out.write("                border: 1px solid red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-danger\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"login.jsp\">Fast Food Online</a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
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
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-md-6 form-container\">\n");
      out.write("                    <h3 class=\"text-center\">Register</h3>\n");
      out.write("                    <form action=\"MainController\" method=\"POST\">\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"register-account\"/>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">User Name</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtUserName\"placeholder=\"Enter your username\">\n");
      out.write("                            ");
 if (!userName_ExisterrorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( userName_ExisterrorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            <br/>\n");
      out.write("                            ");
 if (!userName_ErrorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( userName_ErrorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"txtPassword\" placeholder=\"Enter your password\">\n");
      out.write("                            ");
 if (!password_errorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( password_errorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">Confirm Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"txtConfirmPassword\" placeholder=\"Confirm your password\">\n");
      out.write("                            ");
 if (!confirm_ErrorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( confirm_ErrorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            <br/>\n");
      out.write("                            ");
 if (!confirmPassword_ErrorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( confirmPassword_ErrorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">Full Name</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtFullName\" placeholder=\"Enter your full name\">\n");
      out.write("                            ");
 if (!fullname_errorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( fullname_errorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">Phone Number</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" name=\"txtPhoneNumber\" placeholder=\"Enter your phone number\">\n");
      out.write("                            ");
 if (!phoneNumber_errorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( phoneNumber_errorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label class=\"form-label\">Email</label>\n");
      out.write("                            <input type=\"email\" class=\"form-control\" name=\"txtEmail\" placeholder=\"Enter your email\">\n");
      out.write("                            ");
 if (!email_errorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( email_errorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            ");
 if (!Email_ExisterrorMessage.isEmpty()) {
      out.write("\n");
      out.write("                            <span class=\"bg-danger text-white p-1 d-block\">");
      out.print( Email_ExisterrorMessage);
      out.write("</span>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"text-center\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Register</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"text-center mt-3\">\n");
      out.write("                            <p>Already have an account? <a href=\"login.jsp\" class=\"btn btn-info\">Login Here!</a></p>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                        ");

                            if (message != null && !message.trim().isEmpty()) {
                        
      out.write("\n");
      out.write("                        <span class=\"bg-success text-white p-1 d-block\">");
      out.print( message);
      out.write("</span>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
