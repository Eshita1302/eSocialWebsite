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
public class FrnListData implements Serializable {
private String f1UserName,f2UserName;
int isBlocked;

    public String getF1UserName() {
        return f1UserName;
    }

    public void setF1UserName(String f1UserName) {
        this.f1UserName = f1UserName;
    }

    public String getF2UserName() {
        return f2UserName;
    }

    public void setF2UserName(String f2UserName) {
        this.f2UserName = f2UserName;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }
}
