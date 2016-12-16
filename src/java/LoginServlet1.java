/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.Dbdetails;
import Database.Driver_Location;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antof
 */
public class LoginServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    PrintWriter out = response.getWriter();
     String name = request.getParameter("uname1");
      String type = request.getParameter("type1");
      String mobile = request.getParameter("mob1");
      String age = request.getParameter("age1");
      String address = request.getParameter("address1");
      String sex = request.getParameter("sex1");
      try {
           
            Connection conn1 = new Dbdetails().getConnection();
            Statement stmt1 = conn1.createStatement();
            if(!conn1.isClosed())
            {  
            String query = "INSERT INTO DRIVER_DETAILS VALUES(NULL,'"+name+"','"+type+"','"+mobile+"','"+age+"','"+address+"','"+sex+"')";
            stmt1.executeUpdate(query);
//            stmt1.close();
            ResultSet rs=stmt1.executeQuery("select * from DRIVER_DETAILS where mobile like '"+mobile+"' and name like '"+name+"'");
            rs.afterLast();
            String driverid="";
            if(rs.previous())
                driverid=rs.getString("driver_id");
            String SALTCHARS = "1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
            }
            String saltStr ="DRI";
            saltStr+= salt.toString();
            String query1 = "INSERT INTO DRIVER_LOGIN VALUES("+driverid+",'"+saltStr+"')";
            
            stmt1.executeUpdate(query1);
            
            Driver_Location loc=new Driver_Location();
            loc.setDriver_id(driverid);
            loc.setLatitude("0.0");
            loc.setLongitude("0.0");
            loc.insert();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Driver Details Successfully Inserted');");
            out.println("location='home2.jsp';");
            out.println("</script>");
            }}catch(Exception ex)
    {
        ex.printStackTrace();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   // </editor-fold>

}
}