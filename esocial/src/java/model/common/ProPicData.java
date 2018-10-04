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
public class ProPicData implements Serializable{
private String PhotoName,PhotoType,UserName;
private int PhotoSize,PicID;

    public int getPicID() {
        return PicID;
    }

    public void setPicID(int PicID) {
        this.PicID = PicID;
    }

  

    public int getPhotoSize() {
        return PhotoSize;
    }

    public void setPhotoSize(int PhotoSize) {
        this.PhotoSize = PhotoSize;
    }
    public String getPhotoName() {
        return PhotoName;
    }

    public void setPhotoName(String PhotoName) {
        this.PhotoName = PhotoName;
    }


    public String getPhotoType() {
        return PhotoType;
    }

    public void setPhotoType(String PhotoType) {
        this.PhotoType = PhotoType;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

}
