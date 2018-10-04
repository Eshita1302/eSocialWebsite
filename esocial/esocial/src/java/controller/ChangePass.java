/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.common.LoginTableData;
import model.dataaction.LoginTableAction;

/**
 *
 * @author Esh
 */
@WebServlet(name="ChangePass", urlPatterns={"/ChangePass.Do"})
public class ChangePass extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

         HttpSession sess=request.getSession();
        String name=(String) sess.getAttribute("name");
        String newPass=request.getParameter("newpass");
         String oldPass=request.getParameter("oldpass");
         String cnewPass=request.getParameter("cnewpass");
         if(newPass.equals(cnewPass) )
         {
            String phnno= new LoginTableAction().fetchphone(name);
         new LoginTableAction().changePass(name,oldPass,newPass);
        if(phnno!=null)
        {
         way2sms.Way2Sms.login("9555199716","asdfghjkl");
         way2sms.Way2Sms.login(phnno,"Your eSocial password has been changed to " + newPass);
             }
         response.sendRedirect("/esocial/User/ChangePass.jsp?err=2");
            }
 else
         {
             response.sendRedirect("/esocial/User/ChangePass.jsp?err=1");
            }

        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
