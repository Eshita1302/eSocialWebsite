/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.common.FrnListData;
import model.common.FrnReqData;
import model.common.ProPicData;
import model.dataaction.FrnListAction;
import model.dataaction.FrnReqAction;
import model.dataaction.LoginTableAction;
import model.dataaction.ProPicAction;

/**
 *
 * @author Esh
 */
@WebServlet(name="AddFrn", urlPatterns={"/AddFrn.Do"})
public class AddFrn extends HttpServlet {
   
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
            String f1UserName,f2UserName;
            int isBlocked = 0;
            String sUserName,rUserName;
           int isApproved=0;
           Date Date = null;
            HttpSession sess=request.getSession();
            f1UserName =(String) sess.getAttribute("name");
            
           
          f2UserName= request.getParameter("sname");

            if (f1UserName == null || f2UserName == null ) {
                response.sendRedirect("/esocial/User/FrnList.jsp?err=1");
            } else if (f1UserName.equals("")  || f2UserName.equals("")) {
                response.sendRedirect("/esocial/User/FrnList.jsp?err=1");
            } else {
                FrnListData data=new FrnListData();
                FrnListData dat=new FrnListData();
                 FrnReqData d=new FrnReqData();
                 
                int i = 0;
                try {
                   // data.setF1UserName(UserName);
                } catch (Exception ex) {
                    response.sendRedirect("/esocial/User/FrnList.jsp?err=2");
                    i = 1;
                }
                if (i == 0) {
                    int n=Integer.parseInt(request.getParameter("frID"));
                   boolean da=new FrnReqAction().updateInfoData(n);
                    
                    data.setF1UserName(f1UserName);
                    data.setF2UserName(f2UserName);
                    data.setIsBlocked(isBlocked);

                      dat.setF1UserName(f2UserName);
                    dat.setF2UserName(f1UserName);
                    dat.setIsBlocked(isBlocked);
                   
                    if (new FrnListAction().InsertFriend(data)) {
                        new FrnListAction().InsertFriend(dat);
                       List<ProPicData> daa = new ProPicAction().showProPix();
           sess.setAttribute("propix", daa);
                        response.sendRedirect("/esocial/Friends.Do");
                    } else {
                        response.sendRedirect("/esocial/User/FrnList.jsp?err=4");
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
