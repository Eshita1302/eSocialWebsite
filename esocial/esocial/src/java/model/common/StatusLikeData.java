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
public class StatusLikeData {
private int LikeID,StatusID;
private Date date;
private String UserName, Type;

    public int getLikeID() {
        return LikeID;
    }

    public void setLikeID(int LikeID) {
        this.LikeID = LikeID;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
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

}
