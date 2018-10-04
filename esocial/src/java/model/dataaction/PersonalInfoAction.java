/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dataaction;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.common.PersonalInfoData;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

/**
 *
 * @author Esh
 */
public class PersonalInfoAction {
public boolean InsertPerInfo(PersonalInfoData ld)
    {
             try {
            String query = "insert into personalinfo(Gender,HighSchool,Grad,HighSchoolYear,GradYear,Work,Company,HomeTown,PresLoc,AboutYou,Birthday,UserName) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getGender());
            stmt.setString(2, ld.getHighSchool());
            stmt.setString(3, ld.getGrad());
            stmt.setString(4, ld.getHighSchoolYear());
            stmt.setString(5, ld.getGradYear());
             stmt.setString(6, ld.getWork());
              stmt.setString(7, ld.getCompany());
               stmt.setString(8, ld.getHomeTown());
                stmt.setString(9, ld.getPresLoc());
                 stmt.setString(10, ld.getAboutYou());
                 stmt.setDate(11, (Date) ld.getDate());
                stmt.setString(12, ld.getUserName());


            if (stmt.executeUpdate() > 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DataConnection.closeConnection();
        }

        }

 public boolean updateInfo(PersonalInfoData sd) {

        try {
            String query = "update personalinfo set Gender=?,HighSchool=?,Grad=?,HighSchoolYear=?,GradYear=?,Work=?,Company=?,HomeTown=?,PresLoc=?,AboutYou=?,Birthday=? where UserName=?";
             PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setString(1, sd.getGender());
            stmt.setString(2, sd.getHighSchool());
            stmt.setString(3, sd.getHighSchoolYear());
            stmt.setString(4, sd.getGrad());
            stmt.setString(5, sd.getGradYear());
            stmt.setString(6, sd.getWork());
            stmt.setString(7, sd.getCompany());
            stmt.setString(8, sd.getHomeTown());
            stmt.setString(9, sd.getPresLoc());
            stmt.setString(10, sd.getAboutYou());
            stmt.setDate(11,  sd.getDate());
             stmt.setString(12,sd.getUserName());

           
            if (stmt.executeUpdate() > 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DataConnection.closeConnection();
        }

    }

   

    public PersonalInfoData showInfoData(String name) {
        try {
          
            String query = "select * from personalinfo where userName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            PersonalInfoData dat = null;
            if (rs.next()) {
                
               
            dat=new PersonalInfoData();
                    dat.setGender(rs.getString(1));
                     dat.setHighSchool(rs.getString(2));
                    dat.setHighSchoolYear(rs.getString(3));
                     dat.setGrad(rs.getString(4));
                      dat.setGradYear(rs.getString(5));
                       dat.setDate(rs.getDate(6));
                       dat.setWork(rs.getString(7));
                        dat.setCompany(rs.getString(8));
                        dat.setHomeTown(rs.getString(9));
                         dat.setPresLoc(rs.getString(10));
                          dat.setAboutYou(rs.getString(11));
                          dat.setUserName(rs.getString(12));
                        
                }
            
            rs.close();
            stmt.close();
            return dat;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("HI");
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }

    public List<PersonalInfoData> showGenderData() {
        try {
            String query = "select * from personalinfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<PersonalInfoData> data = null;
            if (rs.next()) {
                data = new ArrayList<PersonalInfoData>();
                rs.beforeFirst();
                while (rs.next()) {
                    PersonalInfoData d=new PersonalInfoData();
                    d.setGender(rs.getString(1));
                     d.setHighSchool(rs.getString(2));
                    d.setHighSchoolYear(rs.getString(3));
                     d.setGrad(rs.getString(4));
                      d.setGradYear(rs.getString(5));
                       d.setDate(rs.getDate(6));
                       d.setWork(rs.getString(7));
                        d.setCompany(rs.getString(8));
                        d.setHomeTown(rs.getString(9));
                         d.setPresLoc(rs.getString(10));
                          d.setAboutYou(rs.getString(11));
                          d.setUserName(rs.getString(12));
                    data.add(d);
                }
            }
            rs.close();
            stmt.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }
    
}






