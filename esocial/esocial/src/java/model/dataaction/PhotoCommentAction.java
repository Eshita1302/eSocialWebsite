/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.common.PhotoCommentData;

/**
 *
 * @author Esh
 */
public class PhotoCommentAction {
    public List<PhotoCommentData> showComments(int pid) {
        try {
            String query = "select * from photocomment where photoID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
             stmt.setInt(1, pid);
             ResultSet rs = stmt.executeQuery();
            List<PhotoCommentData> data = null;

            if (rs.next()) {
                data = new ArrayList<PhotoCommentData>();
                rs.beforeFirst();
                while (rs.next()) {
                    PhotoCommentData dat;
                    dat = new PhotoCommentData();
                    dat.setCommentID(rs.getInt(1));
                    dat.setCommentText(rs.getString(2));
                    dat.setUserName(rs.getString(3));
                    dat.setDate(rs.getDate(4));
                    dat.setTime(rs.getDate(5));
                    dat.setPhotoID(rs.getInt(6));
                    dat.setTotalLike(rs.getInt(7));
                     dat.setTotalUnlike(rs.getInt(8));
                    data.add(dat);
                }
            }
            rs.close();
            stmt.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("HI");
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }
 public boolean InsertComment(PhotoCommentData ld) {
        try {
            String query = "insert into photocomment(commentText,userName,date,time,photoID,totalLike,totalUnlike) values(?,?,curdate(),curtime(),?,0,0)";
           PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(3, ld.getPhotoID());
            stmt.setString(1, ld.getCommentText());
            stmt.setString(2, ld.getUserName());

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