package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class map_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <link href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\" rel=\"stylesheet\"> \n");
      out.write("         <script src=\"jquery.min.js\"></script>\n");
      out.write(" <script type=\"text/javascript\" src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyDmpIyxCnOqXMfcl4mi-iZub0XQlgjkTgY&sensor=false&libraries=places\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var source, destination;\n");
      out.write("var directionsDisplay;\n");
      out.write("var directionsService = new google.maps.DirectionsService();\n");
      out.write("google.maps.event.addDomListener(window, 'load', function () {\n");
      out.write("//    new google.maps.places.SearchBox(document.getElementById('txtSource'));\n");
      out.write("//    new google.maps.places.SearchBox(document.getElementById('txtDestination'));\n");
      out.write("    directionsDisplay = new google.maps.DirectionsRenderer({ 'draggable': true });\n");
      out.write("});\n");
      out.write(" \n");
      out.write("function GetRoute() {\n");
      out.write("    var chennai = new google.maps.LatLng(13.0827,80.2707);\n");
      out.write("    var mapOptions = {\n");
      out.write("        zoom: 7,\n");
      out.write("        center: chennai\n");
      out.write("    };\n");
      out.write("    map = new google.maps.Map(document.getElementById('dvMap'), mapOptions);\n");
      out.write("    directionsDisplay.setMap(map);\n");
      out.write("    directionsDisplay.setPanel(document.getElementById('dvPanel'));\n");
      out.write(" \n");
      out.write("    //*********DIRECTIONS AND ROUTE**********************//\n");
      out.write("//    source = document.getElementById(\"txtSource\").value;\n");
      out.write("//    destination = document.getElementById(\"txtDestination\").value;\n");
      out.write("\n");
      out.write("        $.get('getloc',function(response){\n");
      out.write("            console.log(response);\n");
      out.write("            $.each(response.split(':')),function(index,value){\n");
      out.write("                console.log(value);\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        function repeat(a,b){\n");
      out.write("    \n");
      out.write(" \n");
      out.write("    var request = {\n");
      out.write("        origin: a,\n");
      out.write("        destination:\"13.0551,80.2221\",\n");
      out.write("        travelMode: google.maps.TravelMode.DRIVING\n");
      out.write("    };\n");
      out.write("    directionsService.route(request, function (response, status) {\n");
      out.write("        if (status === google.maps.DirectionsStatus.OK) {\n");
      out.write("            directionsDisplay.setDirections(response);\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write(" \n");
      out.write(" }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("  \n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">108_Services</a>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\">\n");
      out.write("            <a href=\"home.jsp\" class=\"btn btn-info btn-lg\">\n");
      out.write("          <span class=\"glyphicon glyphicon-home\"></span> Home\n");
      out.write("        \n");
      out.write("    </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("           <a href=\"map.jsp\" class=\"btn btn-info btn-lg\" >\n");
      out.write("          <span class=\"glyphicon glyphicon-globe\"></span> View map\n");
      out.write("        </a>\n");
      out.write("      </li>\n");
      out.write("      <li><a href=\"home2.jsp\">Add Driver</a></li> \n");
      out.write("      <li><a href=\"home3.jsp\">Status</a></li> \n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("        <div class=\"container\">\n");
      out.write("  <div class=\"jumbotron\" style=\" border: 1px solid black;\">\n");
      out.write("        <table border=\"0\" cellpadding=\"0\" cellspacing=\"3\">\n");
      out.write("<tr>\n");
      out.write("    \n");
      out.write("    <td colspan=\"2\">\n");
      out.write("      \n");
      out.write("        <input type=\"button\" value=\"Show status\" onclick=\"GetRoute()\" />\n");
      out.write("        <hr />\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td colspan=\"2\">\n");
      out.write("        <div id=\"dvDistance\">\n");
      out.write("        </div>\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td>\n");
      out.write("        <div id=\"dvMap\" style=\"width: 500px; height: 500px\">\n");
      out.write("        </div>\n");
      out.write("    </td>\n");
      out.write("   \n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("  </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
