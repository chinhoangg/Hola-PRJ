package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author chinhoag
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    private String RandName() {
        StringBuilder name = new StringBuilder();
        Random rand = new Random();
        int i, j;
        int leng = rand.nextInt(4) + 3;
        for (i = 0; i < leng; i++) {
            j = rand.nextInt(57) + 65;
            while (j >= 91 && j <= 96) {
                j = (rand.nextInt(57) + 65);
            }
            name.append((char) j);
        }
        return name.toString();
    }
    
    private Date RandDate() throws ParseException {
        Random rand = new Random();
        String year = String.valueOf(rand.nextInt(61) + 1960);
        String month = String.valueOf(rand.nextInt(11) + 1);
        String day = String.valueOf(rand.nextInt(30) + 1);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        date = s.parse(day + "/" + month + "/" + year);
        return date;
    }

    private boolean RandGenr() {
        Random rand = new Random();
        Boolean gender = rand.nextBoolean();
        return gender;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num = (String) request.getParameter("id");
        ArrayList<Student> students = new ArrayList<Student>();

        if (num != null) {
            try {
                for (int i = 1; i <= Integer.parseInt(num); i++) {
                    students.add(new Student(i, RandName(), RandGenr(), RandDate()));
                }
                request.setAttribute("generate", students);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            } catch (Exception ex) {
                response.sendRedirect("student.jsp");
            }
        } else {
            response.sendRedirect("student.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
