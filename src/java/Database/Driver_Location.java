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

/**
 *
 * @author antof
 */
public class Driver_Location {
    private String driver_id;
    private String latitude;
    private String longitude;

    /**
     * @return the driver_id
     */
    public String getDriver_id() {
        return driver_id;
    }

    /**
     * @param driver_id the driver_id to set
     */
    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
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
 
    public int insert(){
    
     
        Connection conn=null;
        Statement stmt=null;
        int update=0;
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        LatLan loc=new LatLan(latitude, longitude);
        update=stmt.executeUpdate("insert into driver_location values("
                + "'"+driver_id+"','"+latitude+"','"+longitude+"','"+LatLan.getRegionCode(loc)+"')");
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
        return update;
    }
    
    
        public int update(){
    
     
        Connection conn=null;
        Statement stmt=null;
        int update=0;
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        LatLan loc=new LatLan(latitude, longitude);
        update=stmt.executeUpdate("update  driver_location set latitude='"+latitude+"', longitude='"+longitude+"', regioncode='"+LatLan.getRegionCode(loc)+"' where driver_id like '"+driver_id+"'");
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
        return update;
    }
        
        public static Driver_Location getLocation(String driverid){
        Connection conn=null;
        Statement stmt=null;
     
        Driver_Location loc=new Driver_Location();
        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from driver_location where driver_id like '"+driverid+"'");
       if(rs.next()){
           loc.setLatitude(rs.getString("latitude"));
           loc.setLongitude(rs.getString("longitude"));
           loc.setDriver_id(driverid);
           
           
        
       }
        
        
        
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
            return loc;
        }
}
