/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
import java.sql.*;
import javax.servlet.http.HttpSession;
import model.common.ProPicData;


/**
 *
 * @author Grapess
 */
public class InsertPhoto {

    public void InsertData(String PhotoName,String PhotoType,int PhotoSize,String UserName) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esocial",
                    "root", "admin");
            String query = "insert into profilephoto(PhotoNAme,PhotoType,PhotoSize,UserName) values(?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(query);
            stmt.setString(1, PhotoName);
            stmt.setString(2, PhotoType);
            stmt.setInt(3,PhotoSize );
             stmt.setString(4,UserName);
            //   HttpSession sess = request.getSession();
            // stmt.setString(4,request.getAttribute(name));

            stmt.executeUpdate();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }



    }

