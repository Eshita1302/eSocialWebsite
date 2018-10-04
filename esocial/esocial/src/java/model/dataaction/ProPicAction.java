/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.common.FrnReqData;
import model.common.ProPicData;
import model.common.ProPicData;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

public class ProPicAction {

    public boolean InsertProPic(ProPicData data) {
        try {
            String query = "insert into profilepic(PhotoName,PhotoType,PhotoSize,UserName) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getPhotoName());
            stmt.setString(2, data.getPhotoType());
            stmt.setInt(3, data.getPhotoSize());
            stmt.setString(4, data.getUserName());
            if (stmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DataConnection.closeConnection();
        }
    }

    public String getPicName(String uname)
    {
        try {
            String query = "select PhotoName from ProfilePic where UserName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, uname);
            String fname=null;
            ResultSet rs=stmt.executeQuery();
            if(rs.next())
            {
                fname = rs.getString(1);
            }
            rs.close();
            stmt.close();
            return fname;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }

    public List<ProPicData> showProPix() {
        try {
            String query = "select * from profilepic";
            PreparedStatement stmt =  DataConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<ProPicData> data = null;
            if (rs.next()) {
                data = new ArrayList<ProPicData>();
                rs.beforeFirst();
                while (rs.next()) {
                    ProPicData d=new ProPicData();

                          d.setPicID(rs.getInt(1));
                          d.setPhotoName(rs.getString(2));
                          d.setPhotoType(rs.getString(3));
                          d.setPhotoSize(rs.getInt(4));
                          d.setUserName(rs.getString(5));

                    data.add(d);
                }
            }
            rs.close();
            stmt.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }

    
    
}
