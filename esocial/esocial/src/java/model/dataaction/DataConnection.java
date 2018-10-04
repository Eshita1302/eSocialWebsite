
package model.dataaction;
import java.sql.*;

public class DataConnection {
    private DataConnection(){}
    private static Connection con=null;
    public static Connection getConnection()
    {
        try
        {
            if(con==null)
            {
                Class.forName("com.mysql.jdbc.Driver").getInterfaces();
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/esocial", "root", "admin");
            }
            return con;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void closeConnection()
    {
        if(con!=null)
        {
            try{
            con.close();
            }catch(Exception exc){}

        }
        con=null;
    }
}
