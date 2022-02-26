
import DAO.StudentDAO;
import java.util.List;
import model.Student;


/**
 *
 * @author chinhoag
 */
public class testdata {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = dao.getStudentByID("4");
        System.out.println(s);
    }
}
