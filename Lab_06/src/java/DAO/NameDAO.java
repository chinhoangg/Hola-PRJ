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
import java.util.ArrayList;
import java.util.List;
import model.Name;

/**
 *
 * @author chinhoag
 */
public class NameDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Name> getAllStudent() {
        List<Name> list = new ArrayList<>();
        String query = "select ID, Name from [DummyTBL]";
        try {
            conn = new BaseDAL().getConnection(); //mo ket noi
            ps = conn.prepareStatement(query);    //chuyen cau lenh query sang sql
            rs = ps.executeQuery();               //chay query
            while (rs.next()) {
                list.add(new Name(rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
