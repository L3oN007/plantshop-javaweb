/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import static dao.AccountDAO.generateToken;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author minhn
 */
public class LoginServlet extends HttpServlet {

    private static final String WELCOME_URL = "index.jsp";
    private static final String ADMIN_URL = "Admin.jsp";

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
        String destinationUrl = "login.jsp";
        try {
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            boolean rememberMe = request.getParameter("rememberMe") != null;
            Account account = AccountDAO.getAccount(email, password);
            if (account == null) {
                request.setAttribute("incorrectUsernamePassword", true);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                if (account.getRole() == 1) {
                    destinationUrl = ADMIN_URL;
                } else {
                    destinationUrl = WELCOME_URL;
                }
                if (rememberMe) { // if "remember me" is checked
                    String token = generateToken(); // generate a new token
                    account.setToken(token); // set the token in the Account object
                    AccountDAO.updateAccountToken(account); // update the token in the database
                    Cookie tokenCookie = new Cookie("token", token); // create a new cookie with the token
                    tokenCookie.setMaxAge(30 * 24 * 60 * 60); // set the cookie to expire in 30 days
                    response.addCookie(tokenCookie); // add the cookie to the response
                } else {
                    Cookie cookie = new Cookie("userToken", null);
                    cookie.setMaxAge(0); // Deletes the cookie
                    response.addCookie(cookie);
                }
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(destinationUrl);
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
