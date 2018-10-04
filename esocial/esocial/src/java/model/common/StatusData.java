/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.common;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Esh
 */
public class StatusData implements Serializable{
private String  UserName,StatusText;
private Date StatusDate, StatusTime;
private int TotalLikes, TotalUnlikes,statusID;

    public String getGetStatusText() {
        return getStatusText;
    }

    public void setGetStatusText(String getStatusText) {
        this.getStatusText = getStatusText;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
    public String getStatusText;

    public Date getStatusDate() {
        return StatusDate;
    }

    public void setStatusDate(Date StatusDate) {
        this.StatusDate = StatusDate;
    }

    public String getStatusText() {
        return StatusText;
    }

    public void setStatusText(String StatusText) {
        this.StatusText = StatusText;
    }

    public Date getStatusTime() {
        return StatusTime;
    }

    public void setStatusTime(Date StatusTime) {
        this.StatusTime = StatusTime;
    }

    public int getTotalLikes() {
        return TotalLikes;
    }

    public void setTotalLikes(int TotalLikes) {
        this.TotalLikes = TotalLikes;
    }

    public int getTotalUnlikes() {
        return TotalUnlikes;
    }

    public void setTotalUnlikes(int TotalUnlikes) {
        this.TotalUnlikes = TotalUnlikes;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

}
