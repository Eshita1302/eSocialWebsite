/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.common;

import java.io.Serializable;

/**
 *
 * @author Esh
 */
public class AlbumData implements Serializable {
private String AlbumName,UserName,Desc;
int albumID;

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
private  int TotalLike,TotalUnlike,CoverID;

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }

    public int getCoverID() {
        return CoverID;
    }

    public void setCoverID(int CoverID) {
        this.CoverID = CoverID;
    }

    public int getTotalLike() {
        return TotalLike;
    }

    public void setTotalLike(int TotalLike) {
        this.TotalLike = TotalLike;
    }

    public int getTotalUnlike() {
        return TotalUnlike;
    }

    public void setTotalUnlike(int TotalUnlike) {
        this.TotalUnlike = TotalUnlike;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }


}
