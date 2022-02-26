package DAO;

import DAL.BaseDAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author chinhoag
 */

public class StudentDAO {                         //su dung, tuong tac du lieu voi database

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[gender]\n"
                + "      ,[dob]\n"
                + "  FROM [Student]";
        try {
            conn = new BaseDAL().getConnection(); //mo ket noi
            ps = conn.prepareStatement(query);    //chuyen cau lenh query sang sql
            rs = ps.executeQuery();               //chay query
            while (rs.next()) {
                list.add(new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteStudent(String id) {
        String query = "delete from Student\n"
                + "where id = ?";
        try {
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate(); // ko co du lieu tra ve thi dung exupdate, co du lieu tra ve thi dung exquery  
        } catch (Exception e) {
        }
    }

    public void insertStudent(String name, String gender, String DOB) {
        String query = "insert into\n"
                + "Student\n"
                + "values(?,?,?)";
        try {
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, DOB);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Student getStudentByID(String id) {
        String query = "select * from Student\n"
                + "where id = ?";
        try {
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateStudent(String id, String name, String gender, String dob) {
        String query = "update Student\n"
                + "set [name] = ?,\n"
                + "gender = ?,\n"
                + "dob = ?\n"
                + "where id = ?";
        try {
            conn = new BaseDAL().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, dob);
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
