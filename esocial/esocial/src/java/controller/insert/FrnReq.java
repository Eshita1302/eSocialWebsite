/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.common.FrnReqData;
import model.dataaction.FrnReqAction;

/**
 *
 * @author Esh
 */
@WebServlet(name="FrnReq", urlPatterns={"/FrnReq.Do"})
public class FrnReq extends HttpServlet {
   
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
           String sUserName,rUserName;
           int isApproved=0;
           Date Date = null;

           HttpSession sess=request.getSession();
          // sUserName = (String) sess.getAttribute("name");
         //rUserName=request.getParameter("searchName");


               FrnReqData data=new FrnReqData();
                int i = 0;
                try {
                    HttpSession ses=request.getSession();
                    data.setsUserName(ses.getAttribute("name").toString());
                } catch (Exception ex) {
                    response.sendRedirect("/esocial/User/ViewProfile.jsp?err=2");
                    i = 1;
            }
                if (i == 0) {
                    rUserName=(String)request.getParameter("funame");
                    data.setrUserName(rUserName);
                    data. setDate((java.sql.Date) Date);
                    data.setIsApproved(0);
                    if (new FrnReqAction().InsertReq(data)) {
                        response.sendRedirect("/esocial/User/ViewProfile.jsp?err=3");
                    } else {
                        response.sendRedirect("/esocial/User/ViewProfile.jsp?err=4");
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
