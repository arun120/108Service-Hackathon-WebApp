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
      out.write("    \r\n");
      out.write("<head>\r\n");
      out.write("        <title>Matrix Admin</title><meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/bootstrap-responsive.min.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/matrix-login.css\" />\r\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"loginbox\">            \r\n");
      out.write("            <form id=\"loginform\" class=\"form-vertical\" action=\"LoginServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t <div class=\"control-group normal_text\"> <h3><img src=\"img/logo.png\" alt=\"Logo\" /></h3></div>\r\n");
      out.write("                <div class=\"control-group\">\r\n");
      out.write("                    <div class=\"controls\">\r\n");
      out.write("                        <div class=\"main_input_box\">\r\n");
      out.write("                            <span class=\"add-on bg_lg\"><i class=\"icon-user\"> </i></span><input type=\"text\" placeholder=\"Username\" id=\"username\" name =\"uname\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"control-group\">\r\n");
      out.write("                    <div class=\"controls\">\r\n");
      out.write("                        <div class=\"main_input_box\">\r\n");
      out.write("                            <span class=\"add-on bg_ly\"><i class=\"icon-lock\"></i></span><input type=\"password\" placeholder=\"Password\" id=\"password\" name =\"pass\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-actions\">\r\n");
      out.write("                    <span class=\"pull-left\"><a href=\"#\" class=\"flip-link btn btn-info\" id=\"to-recover\">Lost password?</a></span>\r\n");
      out.write("                    <span class=\"pull-right\"><a type=\"submit\" href=\"index.html\" class=\"btn btn-success\" /> Login</a></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("<!--            <form id=\"recoverform\" action=\"LoginServlet\" class=\"form-vertical\" method=\"post\">\r\n");
      out.write("\t\t\t\t<p class=\"normal_text\">Enter your e-mail address below and we will send you instructions how to recover a password.</p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("                    <div class=\"controls\">\r\n");
      out.write("                        <div class=\"main_input_box\">\r\n");
      out.write("                            <span class=\"add-on bg_lo\"><i class=\"icon-envelope\"></i></span><input type=\"text\" placeholder=\"E-mail address\" />\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("               \r\n");
      out.write("                <div class=\"form-actions\">\r\n");
      out.write("                    <span class=\"pull-left\"><a href=\"#\" class=\"flip-link btn btn-success\" id=\"to-login\">&laquo; Back to login</a></span>\r\n");
      out.write("                    <span class=\"pull-right\"><a class=\"btn btn-info\"/>Reecover</a></span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>-->\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>  \r\n");
      out.write("        <script src=\"js/matrix.login.js\"></script> \r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
