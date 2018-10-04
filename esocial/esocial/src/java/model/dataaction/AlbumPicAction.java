/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import com.mysql.jdbc.PreparedStatement;
import model.common.AlbumPicData;

/**
 *
 * @author Esh
 */
public class AlbumPicAction {
public boolean InsertAlbumPic(AlbumPicData ld) {
        try {
            String query = "insert into albumphoto(photoName,albumID,photoType,photoSize,totalLikes,totalUnlike) values(?,?,?,?,0,0)";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getPhotoName());
            stmt.setInt(2, ld.getAlbumID());
            stmt.setString(3, ld.getPhotoType());
            stmt.setInt(4, ld.getPhotoSize());
            
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
