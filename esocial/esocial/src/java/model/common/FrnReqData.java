/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.common;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Esh
 */
public class FrnReqData implements Serializable{
    private int isApproved,frID;

    public int getFrID() {
        return frID;
    }

    public void setFrID(int frID) {
        this.frID = frID;
    }
private String sUserName,rUserName;

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getrUserName() {
        return rUserName;
    }

    public void setrUserName(String rUserName) {
        this.rUserName = rUserName;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

  
private Date Date;
}
