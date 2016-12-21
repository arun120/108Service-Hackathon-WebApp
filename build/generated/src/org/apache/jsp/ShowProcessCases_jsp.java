package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Database.Dbdetails;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class ShowProcessCases_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style =\"height:50%\"></div>\n");
      out.write("        <div style =\"height:50%\">\n");
      out.write("         <div id=\"map\" style=\"width:100%;height:500px\"></div>\n");
      out.write("         <script src=\"jquery.min.js\"></script>\n");
      out.write("       <script>\n");
      out.write("           var map;\n");
      out.write("      function addMarker(lat,lng){\n");
      out.write("          \n");
      out.write("            myCenter = new google.maps.LatLng(lat,lng);\n");
      out.write("             marker= new google.maps.Marker({position:myCenter});\n");
      out.write("             marker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png');\n");
      out.write("             marker.setMap(map);\n");
      out.write("          \n");
      out.write("          \n");
      out.write("      }\n");
      out.write("        function myMap()\n");
      out.write("        {\n");
      out.write("        var directionsService = new google.maps.DirectionsService;\n");
      out.write("        var directionsDisplay = new google.maps.DirectionsRenderer;\n");
      out.write("         map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("          zoom: 10,\n");
      out.write("          center: {lat: 13.0827, lng: 80.2707}\n");
      out.write("        });\n");
      out.write("        directionsDisplay.setMap(map);\n");
      out.write("           var myRepeater;\n");
      out.write("        \n");
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 
            Connection con;
            Statement stmt;
            ResultSet rs,rs1;
            
            con = new Dbdetails().getConnection();
            stmt = con.createStatement();
            String a="",b="Processing",query = "SELECT a.CASE_ID,a.LATITUDE,a.LONGITUDE,b.CASE_ID,b.DRIVER_ID,c.DRIVER_ID,c.LATITUDE,c.LONGITUDE,d.CASE_ID,d.STATUS FROM CUSTOMER_CASE a,CASE_LINK b,DRIVER_LOCATION c,CASE_LOG d WHERE a.CASE_ID = b.CASE_ID AND a.CASE_ID = d.CASE_ID AND b.DRIVER_ID = c.DRIVER_ID";
            rs = stmt.executeQuery(query);
            int i=0;
            while(rs.next())
            {
                if(b.equals(rs.getString("d.STATUS")))
                {
                   i++;
                    a+= rs.getString("a.LATITUDE")+":"+rs.getString("a.LONGITUDE")+":"+rs.getString("c.LATITUDE")+":"+rs.getString("c.LONGITUDE")+":";
             
                
      out.write("\n");
      out.write("            \n");
      out.write("                 custlat");
      out.print(i);
      out.write('=');
      out.print(rs.getString("a.LATITUDE"));
      out.write(";\n");
      out.write("                 custlon");
      out.print(i);
      out.write('=');
      out.print(rs.getString("a.LONGITUDE"));
      out.write(";\n");
      out.write("                 drilat");
      out.print(i);
      out.write('=');
      out.print(rs.getString("c.LATITUDE"));
      out.write(";\n");
      out.write("                drilon");
      out.print(i);
      out.write('=');
      out.print(rs.getString("c.LONGITUDE"));
      out.write(";\n");
      out.write("                driverid");
      out.print(i);
      out.write('=');
      out.print(rs.getString("c.DRIVER_ID"));
      out.write(";\n");
      out.write("                \n");
      out.write("            myCenter");
      out.print(i);
      out.write(" = new google.maps.LatLng(custlat");
      out.print(i);
      out.write(",custlon");
      out.print(i);
      out.write(");\n");
      out.write("             marker");
      out.print(i);
      out.write(" = new google.maps.Marker({position:myCenter");
      out.print(i);
      out.write("});\n");
      out.write("             marker");
      out.print(i);
      out.write(".setMap(map);\n");
      out.write("             myCenter");
      out.print(i);
      out.write(" = new google.maps.LatLng(12.9532,80.1416);\n");
      out.write("           google.maps.event.addListener(marker");
      out.print(i);
      out.write(", 'click',function(){\n");
      out.write("               \n");
      out.write("                  calculateAndDisplayRoute");
      out.print(i);
      out.write("(directionsService, directionsDisplay);\n");
      out.write("                    clearInterval(myRepeater);\n");
      out.write("                    myRepeater=setInterval(function(){    calculateAndDisplayRoute");
      out.print(i);
      out.write("(directionsService, directionsDisplay);},1000);\n");
      out.write("               \n");
      out.write("           });\n");
      out.write("            function calculateAndDisplayRoute");
      out.print(i);
      out.write("(directionsService, directionsDisplay) {\n");
      out.write("                //ajax call\n");
      out.write("                var alat");
      out.print(i);
      out.write(",alon");
      out.print(i);
      out.write(";\n");
      out.write("                $.post('DriverLocation',{\n");
      out.write("                    driverid:driverid");
      out.print(i);
      out.write(" \n");
      out.write("                },function(response){\n");
      out.write("                    var a=response.split(\":\");\n");
      out.write("                   \n");
      out.write("                    alat");
      out.print(i);
      out.write("=parseFloat(a[0]);\n");
      out.write("                    alon");
      out.print(i);
      out.write("=parseFloat(a[1]);\n");
      out.write("                   // console.log(alon");
      out.print(i);
      out.write(");\n");
      out.write("            directionsService.route({\n");
      out.write("            origin: {lat:custlat");
      out.print(i);
      out.write(",lng:custlon");
      out.print(i);
      out.write("},\n");
      out.write("            destination:{lat:alat");
      out.print(i);
      out.write(",lng:alon");
      out.print(i);
      out.write("},\n");
      out.write("            travelMode: 'DRIVING'\n");
      out.write("        }, function(response, status) {\n");
      out.write("          if (status === 'OK') {\n");
      out.write("              console.log(\"");
      out.print(i);
      out.write("\");\n");
      out.write("            directionsDisplay.setDirections(response);\n");
      out.write("          } else {\n");
      out.write("            window.alert('Directions request failed due to ' + status);\n");
      out.write("          }\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("                });\n");
      out.write("    }\n");
      out.write("            \n");
      out.write("            ");

                
                }
            }     
           // out.println(a);
            


      out.write("\n");
      out.write("        \n");
      out.write("//        var c = b.split(\":\");\n");
      out.write("\n");
      out.write("\n");
      out.write("         }\n");
      out.write("     \n");
      out.write("                \n");
      out.write("        \n");
      out.write("             \n");
      out.write("           \n");
      out.write("                  \n");
      out.write("         \n");
      out.write("         \n");
      out.write("         </script>\n");
      out.write("         <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDaFex4-AjPI57E4c3WsWZuyAOStCN-9GI&callback=myMap\"></script>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("<div>\n");
      out.write("\n");
      out.write("    Pending Request\n");
      out.write("    ");


      stmt = con.createStatement();
          query = "SELECT a.CASE_ID,a.LATITUDE,a.LONGITUDE,d.CASE_ID,d.STATUS FROM CUSTOMER_CASE a,CASE_LOG d WHERE  a.CASE_ID = d.CASE_ID  and d.status='started'";
            rs = stmt.executeQuery(query);
     
            while(rs.next())
            {
                    


      out.write("\n");
      out.write("<div onclick=\"addMarker(");
      out.print(rs.getString("a.latitude"));
      out.write(',');
      out.print(rs.getString("a.longitude"));
      out.write(")\">");
      out.print(rs.getString("d.case_id"));
      out.write("</div>\n");

}

      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
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
