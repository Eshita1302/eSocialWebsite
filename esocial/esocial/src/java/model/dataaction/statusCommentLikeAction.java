/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import model.common.StatusCommentLikeData;

/**
 *
 * @author Esh
 */
public class statusCommentLikeAction {

    public boolean InsertStatusCommentLike(StatusCommentLikeData ld) {
        try {
            String query = "insert into statuscommentlike(commentID,userName,date,type) values(?,?,curdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, ld.getCommentID());
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


    public boolean InsertStatusCommentUnlike(StatusCommentLikeData ld) {
        try {
            String query = "insert into statuscommentlike(commentID,userName,date,type) values(?,?,curdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, ld.getCommentID());
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
