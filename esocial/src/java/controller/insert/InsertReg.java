/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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
public class InsertReg extends HttpServlet {

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
            String UserName,Password,SecQues,SecAns,Email,phoneno;
           

           UserName = request.getParameter("uname");
           Password = request.getParameter("pass");
            Email= request.getParameter("email");
             SecQues = request.getParameter("secQues");
             SecAns = request.getParameter("secAns");
              phoneno=request.getParameter("phoneno");

            if (UserName == null || Password == null || SecQues == null || SecAns==null || Email==null ||phoneno==null) {
                response.sendRedirect("Registeration.jsp?err=1");
            } else if (UserName.equals("") || Password.equals("") || phoneno.equals("") || Email.equals("")|| SecQues.equals("")|| SecAns.equals("")) {
                response.sendRedirect("Registeration.jsp?err=1");
            } else {
                LoginTableData data=new LoginTableData();
                int i = 0;
                try {
                    data.setUserName(UserName);
                } catch (Exception ex) {
                    response.sendRedirect("Registeration.jsp?err=2");
                    i = 1;
                }
                if (i == 0) {
                    data.setPassword(Password);
                    data.setEmailID(Email);
                    data.setSecQues(SecQues);
                    data.setSecAns(SecAns);
                    data.setPhoneno(phoneno);
                    if (new LoginTableAction().InsertRegisteration(data)) {
                        HttpSession sess=request.getSession();
                        sess.setAttribute("name", UserName);
                        response.sendRedirect("User/Home.jsp");
                    } else {
                        response.sendRedirect("Registeration.jsp?err=4");
                    }
                }
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
