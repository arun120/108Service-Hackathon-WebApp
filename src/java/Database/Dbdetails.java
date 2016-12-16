package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Home on 13-11-2016.
 */
public class Dbdetails {
    
    final static public String APIKey="AIzaSyATXwF9E2lDwxpC0xfwVN5DhWqrWzTTtpU";
    final private String Driver="com.mysql.jdbc.Driver";
    final static private String UserName="root";
    final static private String Pass="1234";
    private String Url="jdbc:mysql://192.168.1.120:3306/108_service";

    public String getDriver() {
        return Driver;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPass() {
        return Pass;
    }

    public String getUrl() {
        return Url;
    }
    
    public Connection getConnection()
    {
        Connection con=null;
        try {  
             Class.forName(Driver).newInstance();
            con = DriverManager.getConnection(Url,UserName,Pass);
             
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    return con;
    }

}
