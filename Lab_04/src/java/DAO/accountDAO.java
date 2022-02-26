package DAO;

import DAL.BaseDAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author chinhoag
 */
public class accountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account checkLogin(String username, String password) {
        try {
            String query = "select * from account\n"
                    + "where username = ? and password = ?";
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                Account a = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
                return a;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
