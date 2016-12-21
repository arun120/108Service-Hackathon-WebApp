/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antof
 */
public class Customer_Case {
    private String cust_id;
    private String type;
    private String latitude;
    private String longitude;
    private String no_ppl_affected;
    private Date time;
    private String case_id;

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getCase_id() {
        return case_id;
    }

    /**
     * @return the cust_id
     */
    public String getCust_id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the no_ppl_affected
     */
    public String getNo_ppl_affected() {
        return no_ppl_affected;
    }

    /**
     * @param no_ppl_affected the no_ppl_affected to set
     */
    public void setNo_ppl_affected(String no_ppl_affected) {
        this.no_ppl_affected = no_ppl_affected;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
    
    
    public String add(){
        
        Connection conn=null;
        Statement stmt=null;
        
        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        stmt.executeUpdate("insert into customer_case(cust_id,type,latitude,longitude,no_ppl_affected,regioncode) values("
                + "'"+cust_id+"','"+type+"','"+latitude+"','"+longitude+"','"+no_ppl_affected+"','"+LatLan.getRegionCode(new LatLan(latitude,longitude))+"')");
        
        
        ResultSet rs=stmt.executeQuery("select case_id from customer_case where cust_id like '"+cust_id+"'");
        rs.afterLast();
        if(rs.previous())
        {  
            case_id=rs.getString("case_id");
            
            rs.close();
            
        
        stmt.executeUpdate("insert into case_log values('"+case_id+"','started')");
        stmt.executeUpdate("insert into acceptance values('"+case_id+"','null')");
        
        }
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
        return case_id;
    }
    
     public static LatLan getLocation(String caseid){
        Connection conn=null;
        Statement stmt=null;
     
        LatLan loc=new LatLan();
        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from customer_case where case_id like '"+caseid+"'");
       if(rs.next()){ 
           loc.setLat(rs.getString("latitude"));
           loc.setLon(rs.getString("longitude"));
           
           
        
       }
        
        
        
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
            return loc;
        }

     public static List<Customer_Case> getAllRecent(String regioncode){
        Connection conn=null;
        Statement stmt=null;
     
        List<Customer_Case> list=new ArrayList<>();
        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from customer_case where regioncode like '"+regioncode+"' and time <= now() and time>= now() -INTERVAL 1 HOUR");
       while(rs.next()){
           
           Customer_Case cust=new Customer_Case();
           cust.setCase_id(rs.getString("case_id"));
           cust.setLatitude(rs.getString("latitude"));
           cust.setLongitude(rs.getString("longitude"));
           list.add(cust);
           
           
        
       }
        
        
        
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
            return list;
        }


}
