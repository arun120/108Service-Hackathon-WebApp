/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author antof
 */
public class Acceptance {
private String case_id;
private String driver;
private Date time;

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
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
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
    
    
    public static Integer getDistance(String origin,String destination) throws MalformedURLException, JSONException, IOException{
            
        URL url =  new URL("https://maps.googleapis.com/maps/api/distancematrix/json?mode=driving&origins="+origin+"&destinations="+destination+"&key="+Dbdetails.APIKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            char c;
            String s = new String();
            while ((c = (char) input.read()) != (char) -1)
                s += c;
            System.out.println(s);
            JSONObject aa=new JSONObject(s);
            String duration=aa.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
            String distance =aa.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text");
            int factor=1;
            if(!distance.contains("km"))
                factor=1000;
            distance=distance.substring(0, distance.indexOf(" "));
        
        return Integer.valueOf(distance)*factor;
    
    }
    
    public boolean isBetter(String driver1,String driver2){
    try {
        //TO-DO use google API to detect
        if(driver2.equals("null"))
            return true;
        
        Driver_Location dri1=Driver_Location.getLocation(driver1);
        Driver_Location dri2=Driver_Location.getLocation(driver2);
        LatLan caseloc=Customer_Case.getLocation(case_id);
            
        
            if(getDistance(caseloc.getLat()+","+caseloc.getLon(),dri1.getLatitude()+","+dri1.getLongitude())<getDistance(caseloc.getLat()+","+caseloc.getLon(),dri2.getLatitude()+","+dri2.getLongitude())){
            
            return true;
            }else{
            return false;
            }
            
             
        
        
    } catch (Exception ex) {
 ex.printStackTrace();
    }
    return false;
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
           
       if(isBetter(driver, rs.getString("driver_id")))
           
           rs.close();
       update+=stmt.executeUpdate("update acceptance set driver_id = '"+driver+"' where case_id like '"+case_id+"'");
       stmt.executeUpdate("update case_log set status='Processing' where case_id like '"+case_id+"'");
        
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
