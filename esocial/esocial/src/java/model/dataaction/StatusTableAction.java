/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.common.StatusData;

/**
 *
 * @author Esh
 */
public class StatusTableAction {

    public boolean InsertStatus(StatusData sd) {
        try {
            String query = "insert into status(userName,statusText,statusDate,statusTime,totalLike,totalUnlike) values(?,?,curdate(),curtime(),0,0)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, sd.getUserName());
            stmt.setString(2, sd.getStatusText());
            // stmt.setInt(3, sd.getTotalLikes());
            //stmt.setInt(4, sd.getTotalUnlikes());

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
    public boolean updateStatusLike(int sid) {

        try {
            String query = "update status set totalLike=totalLike+1 where statusID=?";
             PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setInt(1, sid);

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
     public boolean updateStatusUnlike(int sid) {

        try {
            String query = "update status set totalUnlike=totalUnlike+1 where statusID=?";
             PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setInt(1, sid);

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


    public List<StatusData> showStatus(String uname) {
        try {
            String query = "select distinct statusID,s.userName,statusText,statusDate,statusTime,totalLike,totalUnlike from `status` s where s.userName in (SELECT f1UserName from friendlist where f2UserName=? and isBlocked=0) order by statusdate desc,statustime desc";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, uname);
            ResultSet rs = stmt.executeQuery();
            List<StatusData> data = null;
            if (rs.next()) {
                data = new ArrayList<StatusData>();
                rs.beforeFirst();
                while (rs.next()) {
                    StatusData d = new StatusData();
                    d.setStatusID(rs.getInt(1))    ;
                    d.setUserName(rs.getString(2));
                    d.setStatusText(rs.getString(3));
                    d.setStatusDate(rs.getDate(4));
                    d.setStatusTime(rs.getDate(5));
                    d.setTotalLikes(rs.getInt(6));
                    d.setTotalUnlikes(rs.getInt(7));

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


     public List<StatusData> showMyStatus(String name){
        try {

            String query = "select * from status where userName=? order by statusdate desc,statustime desc";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
              List<StatusData> data = null;
            if (rs.next()) {
               data = new ArrayList<StatusData>();
                rs.beforeFirst();
                while (rs.next()) {
                    StatusData dat;
                    dat = new StatusData();
                    dat.setStatusID(rs.getInt(1));
                    dat.setUserName(rs.getString(2));
                    dat.setStatusText(rs.getString(3));
                    dat.setStatusDate(rs.getDate(4));
                     dat.setStatusTime(rs.getDate(5));
                      dat.setTotalLikes(rs.getInt(6));
                        dat.setTotalUnlikes(rs.getInt(7));
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
