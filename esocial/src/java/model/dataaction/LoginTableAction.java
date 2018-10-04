package model.dataaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.common.LoginTableData;

public class LoginTableAction {

    public boolean checkLogin(LoginTableData ltd) {
        try {
            String query = "select * from logintable where userName=? and password=password(?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ltd.getUserName());
            stmt.setString(2, ltd.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            DataConnection.closeConnection();
        }
    }

    public boolean InsertRegisteration(LoginTableData ld) {
        try {
            String query = "insert into logintable(UserName,Password,EmailID,SecQues,SecAns,CreatedDate,LastLogin,phoneno) values(?,password(?),?,?,?,curdate(),curdate(),?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ld.getUserName());
            stmt.setString(2, ld.getPassword());
            stmt.setString(3, ld.getEmailID());
            stmt.setString(4, ld.getSecQues());
            stmt.setString(5, ld.getSecAns());
            stmt.setString(6, ld.getPhoneno());

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

    public List<LoginTableData> showSearch(String searchName) {
        try {
            String query = "select * from logintable where userName like '" + searchName + "%' or emailID like '" + searchName + "%'";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
             ResultSet rs = stmt.executeQuery();
            List<LoginTableData> data = null;

            if (rs.next()) {
                data = new ArrayList<LoginTableData>();
                rs.beforeFirst();
                while (rs.next()) {
                    LoginTableData dat;
                    dat = new LoginTableData();
                    dat.setUserName(rs.getString(1));
                    dat.setPassword(rs.getString(2));
                    dat.setEmailID(rs.getString(3));
                    dat.setSecQues(rs.getString(4));
                    dat.setSecAns(rs.getString(5));
                    dat.setCreatedDate(rs.getDate(6));
                    dat.setLastLogin(rs.getDate(7));
                    data.add(dat);
                }
            }
            rs.close();
            stmt.close();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("HI");
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }

     public String fetchphone(String name) {
        try {

            String query = "select phoneno from logintable where userName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            String phnno = null;
            if (rs.next()) {
                phnno = rs.getString(1);
                }

            rs.close();
            stmt.close();
            return phnno;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("HI");
            return null;
        } finally {
            DataConnection.closeConnection();
        }

    }

    public boolean changePass(String name,String oldpass,String newpass) {
        try {
            String query = "update logintable set password=password(?) where userName=? and password=password(?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, newpass);
            stmt.setString(2, name);
            stmt.setString(3, oldpass);


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

}
