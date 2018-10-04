/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.common;

import java.sql.Date;

/**
 *
 * @author Esh
 */
public class PhotoCommentData {
    private String CommentText,UserName;
    private int CommentID,PhotoID,TotalLike,TotalUnlike;

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public String getCommentText() {
        return CommentText;
    }

    public void setCommentText(String CommentText) {
        this.CommentText = CommentText;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getPhotoID() {
        return PhotoID;
    }

    public void setPhotoID(int PhotoID) {
        this.PhotoID = PhotoID;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date Time) {
        this.Time = Time;
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
    private Date Date,Time;


}
