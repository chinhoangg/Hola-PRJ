package controller;

import DAO.accountDAO;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.displayNameType;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chinhoag
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
        
        accountDAO AccountDAO = new accountDAO();
        Account a = AccountDAO.checkLogin(username, password);
        
        if(a == null){
            response.getWriter().println("username/password is invalid");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("account", a);
            if (remember) {
                Cookie uCookie = new Cookie("username", username);
                uCookie.setMaxAge(3600 * 24 * 30);
                Cookie pCookie = new Cookie("password", password);
                pCookie.setMaxAge(3600 * 24 * 30);
                Cookie dCookie = new Cookie("cook", a.getDisplayName());
                dCookie.setMaxAge(3600 * 24 * 30);
                response.addCookie(uCookie);
                response.addCookie(pCookie);
                response.addCookie(dCookie);
            }
            response.sendRedirect("detail");
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
