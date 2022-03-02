package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.Employee;
import model.Name;

/**
 *
 * @author chinhoag
 */
public class ThirdServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
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
//        processRequest(request, response);
        Name name1 = new Name("Chinh", "Hoang");
        Name name2 = new Name("Nuoc", "Nga");
        Name name3 = new Name("Chien", "Tranh");

        Address address1 = new Address("An Duong", "Hai Phong", "15");
        Address address2 = new Address("Ba Dinh", "Ha Noi", "29");
        Address address3 = new Address("Kon Tum", "DakLak", "47");
        
        Employee employee1 = new Employee(name1, address1);
        Employee employee2 = new Employee(name2, address2);
        Employee employee3 = new Employee(name3, address3);
        Employee[] employeeArray = {employee1, employee2, employee3};

        ArrayList<Name> nameArrayList = new ArrayList<Name>();

        nameArrayList.add(name1);
        nameArrayList.add(name2);
        nameArrayList.add(name3);
        
        request.setAttribute("nameArrayList", nameArrayList);
        request.setAttribute("employeeArray", employeeArray);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
