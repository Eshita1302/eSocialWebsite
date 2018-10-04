/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.common.FrnReqData;

/**
 *
 * @author Esh
 */
public class FrnReqAction {

    public boolean InsertReq(FrnReqData ld) {
        try {
            String query = "insert into friendrequest(sUserName,rUserName,date,isApproved) values(?,?,curdate(),0)";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getsUserName());
            stmt.setString(2, ld.getrUserName());

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

    public List<FrnReqData> showSearch(String uname) {
        try {
            String query = "select * from friendrequest where isApproved=0 and rUserName=?";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);

            stmt.setString(1, uname);
            ResultSet rs = stmt.executeQuery();
            List<FrnReqData> data = null;

            if (rs.next()) {
                data = new ArrayList<FrnReqData>();
                rs.beforeFirst();
                while (rs.next()) {
                    FrnReqData dat;
                    dat = new FrnReqData();
                    dat.setFrID(rs.getInt(1));
                    dat.setsUserName(rs.getString(2));
                    dat.setrUserName(rs.getString(3));
                    dat.setDate(rs.getDate(4));


                    data.add(dat);
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

    public FrnReqData showInfoData(String name) {
        try {

            String query = "select * from friendrequest where rUserName=?";
            PreparedStatement stmt = (PreparedStatement) DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            FrnReqData dat = null;
            if (rs.next()) {


                dat = new FrnReqData();
                dat.setFrID(rs.getInt(1));
                dat.setDate(rs.getDate(4));
                dat.setsUserName(rs.getString(2));
                dat.setrUserName(rs.getString(3));
                dat.setIsApproved(1);

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

    public boolean updateInfoData(int n) {

        try {
            String query = "update friendrequest set isApproved=1 where frID=?";
            PreparedStatement stmt =  DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, n);
            boolean ans=stmt.executeUpdate()>0;
            stmt.close();
            return ans;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally
        {
            DataConnection.closeConnection();
        }
    }
}
