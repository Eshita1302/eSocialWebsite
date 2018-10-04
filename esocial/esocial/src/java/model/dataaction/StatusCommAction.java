/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.common.StatusCommData;

/**
 *
 * @author Esh
 */
public class StatusCommAction {

 public boolean InsertStatus(StatusCommData ld) {
        try {
            String query = "insert into statuscomment(statusID,commentText,commentDate,commentTime,userName,totalLike,totalUnlike) values(?,?,curdate(),curtime(),?,0,0)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, ld.getStatusID());
            stmt.setString(2, ld.getCommentText());
            stmt.setString(3, ld.getUserName());

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

 public List<StatusCommData> showAllComments(int sid) {
        try {
            String query = "select * from statuscomment where statusID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
             stmt.setInt(1, sid);
             ResultSet rs = stmt.executeQuery();
            List<StatusCommData> data = null;

            if (rs.next()) {
                data = new ArrayList<StatusCommData>();
                rs.beforeFirst();
                while (rs.next()) {
                    StatusCommData dat;
                    dat = new StatusCommData();
                    dat.setCommentID(rs.getInt(1));
                    dat.setStatusID(rs.getInt(2));
                    dat.setCommentText(rs.getString(3));
                    dat.setCurdate(rs.getDate(4));
                    dat.setCurtime(rs.getDate(5));
                    dat.setUserName(rs.getString(6));
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

    public boolean updateStatusCommentLike(int cid) {
          try {
            String query = "update statuscomment set totalLike=totalLike+1 where commentID=?";
             PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setInt(1, cid);

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

    public boolean updateStatusCommentUnlike(int cid) {

        try {
            String query = "update statuscomment set totalUnlike=totalUnlike+1 where commentID=?";
             PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setInt(1, cid);

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
