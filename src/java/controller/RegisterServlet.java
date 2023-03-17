/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author L3oN
 */
public class RegisterServlet extends HttpServlet {

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
        String URL = "login.jsp";
        try {
            // kiem tra xem session da ton tai hay chua
            String email = request.getParameter("txtemail");
            String fullname = request.getParameter("txtfullname");
            String password = request.getParameter("txtpassword");
            String confirmPassword = request.getParameter("txtcomfirmpassword");
            String phone = request.getParameter("txtphone");
            int status = 1;
            int role = 0;
            
            RegisterRegex block = new RegisterRegex();
            if (block.checkEmailExisted(email) != null) {
                request.setAttribute("block", block);
            } else if (block.checkEmailRegex(email) != null
                    || block.checkPasswordLength(password) != null
                    || block.checkConfirm(password, confirmPassword) != null
                    || block.checkFullname(fullname) != null
                    || block.checkPhoneRegex(phone) != null) {
                block.checkEmailRegex(email);
                block.checkPasswordLength(password);
                block.checkConfirm(password, confirmPassword);
                block.checkFullname(fullname);
                block.checkPhoneRegex(phone);
                request.setAttribute("block", block);
            } else {                
                Account account = new Account(email, password, fullname, status, phone, role);
                try {
                    AccountDAO.insertAccount(email, password, fullname, phone, status, role);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                URL = "index.jsp";

            }
            // lay ra session neu no da ton tai. Con neu khong ton tai, lay ra null

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(URL);
            rd.forward(request, response);
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
        processRequest(request, response);
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
