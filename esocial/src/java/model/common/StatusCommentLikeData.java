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
public class StatusCommentLikeData {
private int LikeID,CommentID;
private Date date;

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public int getLikeID() {
        return LikeID;
    }

    public void setLikeID(int LikeID) {
        this.LikeID = LikeID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
private String UserName, Type;

}
