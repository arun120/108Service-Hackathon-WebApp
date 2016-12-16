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
public class Case_Link {
   private String case_id; 
   private String cust_id;
   private String driver_id;

    /**
     * @return the case_id
     */
    public String getCase_id() {
        return case_id;
    }

    /**
     * @param case_id the case_id to set
     */
    public void setCase_id(String case_id) {
        this.case_id = case_id;
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
   
    public boolean add(){
    
        Connection conn=null;
        Statement stmt=null;
        int update=0;
        
        
        try{
        conn=new Dbdetails().getConnection();
        stmt=conn.createStatement();
  
        ResultSet rs=stmt.executeQuery("select driver_id from acceptance where case_id like '"+case_id+"'");
       if(rs.next()){
       if(rs.getString("driver_id").equals(driver_id))
       update+=stmt.executeUpdate("insert into case_link values('"+case_id+"','"+driver_id+"')");
        if(update==1)
       stmt.executeUpdate("delete from notification where caseid like '"+case_id+"'");
       rs.close();
       }
       
           
        
        
        
        }catch(Exception e){e.printStackTrace();}finally{try {
            if(stmt!=null)stmt.close();if(conn!=null)conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}
    
        if(update==1)
            return true;
        else
        return false;
    
 
    
    }
}
