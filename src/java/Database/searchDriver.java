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
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class searchDriver implements Runnable {

    Customer_Case c;
    Set<Long> RegionCode;
    Set<String> Notified;
    public searchDriver(Customer_Case c) {
    this.c=c;
    Notified=new TreeSet<>();
    }

    
    
    @Override
    public void run() {
        Connection conn=null;
        Statement stmt=null;
        try {
            
            if(RegionCode==null){
            RegionCode = new TreeSet<>();
            RegionCode.add(Long.valueOf(LatLan.getRegionCode(new LatLan(c.getLatitude(), c.getLongitude()))));
            }else{
           Thread.sleep(20000);
            try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        
       ResultSet rs=stmt.executeQuery("select * from acceptance where case_id like '"+c.getCase_id()+"'");
        if(rs.next()){
            String driver_id=rs.getString("driver_id");
            if(driver_id==null){
            RegionCode.addAll(LatLan.getAdjacentCells(RegionCode));
            
            }else{
            return;
            }
        
        }
       
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
        }
       

        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        
        List<String> driver=new ArrayList<>();
        
        for(Long rc:RegionCode){
        driver.addAll(getDrivers(rc));
        }
        
        for(String id:driver){
            if(Notified.contains(id))
                continue;
            else{
                Notified.add(id);
                stmt.executeUpdate("insert into notification values('"+ c.getCase_id() + "','" + id + "')" );
            }
        }
        
       
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
            
        } catch (Exception ex) {
            Logger.getLogger(searchDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<String> getDrivers(Long RegionCode){
        
        //TO_DO return only valid drivers
        
        List<String> driver=new ArrayList<>();
                Connection conn=null;
        Statement stmt=null;

        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
        
        ResultSet rs=stmt.executeQuery("select * from driver_location where regioncode like '"+RegionCode+"'");
        while(rs.next()){
            driver.add(rs.getString("driver_id"));
            
        }
        
        
       
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
    return driver;
    }
    
    
}
