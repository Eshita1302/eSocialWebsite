/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.common.AlbumPhotoData;

/**
 *
 * @author Esh
 */
public class AlbumPhotoAction {

    public List<AlbumPhotoData> showPix(int aid) {
        try {
            String query = "select * from albumphoto where albumid=?";
            PreparedStatement stmt =  DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, aid);
            ResultSet rs = stmt.executeQuery();
            List<AlbumPhotoData> data = null;
            if (rs.next()) {
                data = new ArrayList<AlbumPhotoData>();
                rs.beforeFirst();
                while (rs.next()) {
                    AlbumPhotoData d=new AlbumPhotoData();

                          d.setPhotoID(rs.getInt(1));
                          d.setPhotoName(rs.getString(2));
                          d.setAlbumID(rs.getInt(3));
                          d.setPhotoType(rs.getString(4));
                          d.setPhotoSize(rs.getInt(5));
                          d.setTotalLike(rs.getInt(6));
                          d.setTotalUnlike(rs.getInt(7));

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

    public int InsertAlbumPic(AlbumPhotoData ld) {
        try {
            String query = "insert into albumphoto(photoName,albumID,photoType,photoSize,totalLikes,totalUnlike) values(?,?,?,?,0,0)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getPhotoName());
            stmt.setInt(2, ld.getAlbumID());
            stmt.setString(3, ld.getPhotoType());
            stmt.setInt(4, ld.getPhotoSize());
            stmt.executeUpdate();
            stmt.close();
            query="select last_insert_id()";
            stmt= DataConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int i = rs.getInt(1);
            rs.close();
            stmt.close();
            return i;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DataConnection.closeConnection();
        }


    }
  
}
