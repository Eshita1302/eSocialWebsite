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
public class AlbumPicData implements Serializable{
    private String PhotoName,PhotoType;
    private int AlbumID,PhotoSize,TotalLike,TotalUnlike;

    public int getAlbumID() {
        return AlbumID;
    }

    public void setAlbumID(int AlbumID) {
        this.AlbumID = AlbumID;
    }

    public String getPhotoName() {
        return PhotoName;
    }

    public void setPhotoName(String PhotoName) {
        this.PhotoName = PhotoName;
    }

    public int getPhotoSize() {
        return PhotoSize;
    }

    public void setPhotoSize(int PhotoSize) {
        this.PhotoSize = PhotoSize;
    }

    public String getPhotoType() {
        return PhotoType;
    }

    public void setPhotoType(String PhotoType) {
        this.PhotoType = PhotoType;
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

}
