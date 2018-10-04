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
public class PersonalInfoData implements Serializable{
    String Gender,HighSchool,Grad,HighSchoolYear,GradYear,Work,Company,HomeTown,PresLoc,AboutYou,UserName;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

 
    public String getAboutYou() {
        return AboutYou;
    }

    public void setAboutYou(String AboutYou) {
        this.AboutYou = AboutYou;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String Grad) {
        this.Grad = Grad;
    }

    public String getGradYear() {
        return GradYear;
    }

    public void setGradYear(String GradYear) {
        this.GradYear = GradYear;
    }

    public String getHighSchool() {
        return HighSchool;
    }

    public void setHighSchool(String HighSchool) {
        this.HighSchool = HighSchool;
    }

    public String getHighSchoolYear() {
        return HighSchoolYear;
    }

    public void setHighSchoolYear(String HighSchoolYear) {
        this.HighSchoolYear = HighSchoolYear;
    }

    public String getHomeTown() {
        return HomeTown;
    }

    public void setHomeTown(String HomeTown) {
        this.HomeTown = HomeTown;
    }

    public String getPresLoc() {
        return PresLoc;
    }

    public void setPresLoc(String PresLoc) {
        this.PresLoc = PresLoc;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String Work) {
        this.Work = Work;
    }


}
