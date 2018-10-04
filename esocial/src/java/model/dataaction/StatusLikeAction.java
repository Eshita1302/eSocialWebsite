/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import model.common.StatusLikeData;

/**
 *
 * @author Esh
 */
public class StatusLikeAction {


    public boolean InsertStatusLike(StatusLikeData ld) {
        try {
            String query = "insert into statuslike(statusID,userName,date,type) values(?,?,curdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, ld.getStatusID());
            stmt.setString(2, ld.getUserName());
            stmt.setString(3, ld.getType());

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


    public boolean InsertStatusUnlike(StatusLikeData ld) {
        try {
            String query = "insert into statuslike(statusID,userName,date,type) values(?,?,curdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, ld.getStatusID());
            stmt.setString(2, ld.getUserName());
            stmt.setString(3, ld.getType());

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
}
