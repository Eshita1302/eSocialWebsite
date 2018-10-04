/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.common.FrnListData;
import model.common.FrnReqData;

/**
 *
 * @author Esh
 */
public class FrnListAction {
  public boolean InsertFriend(FrnListData ld) {
        try {
            String query = "insert into friendlist(f1UserName,f2UserName,isBlocked) values(?,?,0)";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getF1UserName());
            stmt.setString(2, ld.getF2UserName());


            if (stmt.executeUpdate() > 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DataConnection.closeConnection();
        }


    }

    public List<FrnListData> showSearch(String uname) {
        try {
            String query = "select * from friendlist where f1UserName=? and isBlocked=0";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);
            System.out.println(uname);
            stmt.setString(1,uname);
             ResultSet rs = stmt.executeQuery();
            List<FrnListData> data = null;

            if (rs.next()) {
                data = new ArrayList<FrnListData>();
                rs.beforeFirst();
                while (rs.next()) {
                    FrnListData dat;
                    dat = new FrnListData();
                    dat.setF2UserName(rs.getString(3));
                    dat.setIsBlocked(rs.getInt(4));

                    data.add(dat);
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
