/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.common.AlbumData;

/**
 *
 * @author Esh
 */
public class AlbumAction {
public boolean InsertAlbum(AlbumData ld) {
        try {
            String query = "insert into album(albumName,userName,totalLike,totalUnlike,coverID,`Desc`) values(?,?,0,0,0,?)";
            PreparedStatement stmt =  DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getAlbumName());
            stmt.setString(2, ld.getUserName());
            stmt.setString(3, ld.getDesc());


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

         public List<AlbumData> showAlbums() {
        try {
            String query = "select * from album";
            PreparedStatement stmt =  DataConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<AlbumData> data = null;
            if (rs.next()) {
                data = new ArrayList<AlbumData>();
                rs.beforeFirst();
                while (rs.next()) {
                    AlbumData d=new AlbumData();

                          d.setAlbumID(rs.getInt(1));
                          d.setAlbumName(rs.getString(2));
                          d.setUserName(rs.getString(3));
                          d.setTotalLike(rs.getInt(4));
                          d.setTotalUnlike(rs.getInt(5));
                          d.setCoverID(rs.getInt(6));
                          d.setDesc(rs.getString(7));
                          //System.out.println(d.getAlbumName());
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
