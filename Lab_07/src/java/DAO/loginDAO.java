/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAL.BaseDAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author chinhoag
 */
public class loginDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean checkLogin(String username, String password) {
        try {
            String query = "select * from account\n"
                    + "where username = ? and password = ?";
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
            
        } catch (Exception e) {
        }
        return false;
    }
}
