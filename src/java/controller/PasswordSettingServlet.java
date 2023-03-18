/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author L3oN
 */
public class PasswordSettingServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            String currentPassword = request.getParameter("currentPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            String newPassword = request.getParameter("newPassword");
            String newFullname = request.getParameter("newFullname");
            String newPhone = request.getParameter("newPhone");

            // Check if the current password is correct
            boolean passwordMatch = AccountDAO.checkPassword(email, currentPassword);

            if (!passwordMatch) {
                // If the current password is incorrect, show an error message
                request.setAttribute("errorMessage", "Current password is incorrect.");
                request.getRequestDispatcher("AccountSetting.jsp").forward(request, response);
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                request.setAttribute("errorConfirmMessage", "New password and confirm password is not match.");
                request.getRequestDispatcher("AccountSetting.jsp").forward(request, response);
                return;
            }

            // If the current password is correct, update the account information
            boolean updateResult = AccountDAO.updateAccount(email, newPassword, newFullname, newPhone);

            if (updateResult) {
                // If the update is successful, show a success message
                request.setAttribute("successMessage", "Account information updated successfully.");
                request.getRequestDispatcher("AccountSetting.jsp").forward(request, response);
                return;
            } else {
                // If the update fails, show an error message
                request.setAttribute("errorMessage", "Failed to update account information.");
                request.getRequestDispatcher("AccountSetting.jsp").forward(request, response);
                return;
            }
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
