/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.common.PersonalInfoData;
import model.dataaction.PersonalInfoAction;

/**
 *
 * @author Esh
 */
public class InsertPerInfo extends HttpServlet {
   
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
            String Gender,Bday,HighSchool,Grad,HighSchoolYear,GradYear,Work,Company,HomeTown,PresLoc,AboutYou,UserName;
            

          Gender = request.getParameter("Gender");
          HighSchool = request.getParameter("HighSchool");
          HighSchoolYear = request.getParameter("HighSchoolYear");
          Grad = request.getParameter("Grad");
          GradYear = request.getParameter("GradYear");
           String s=request.getParameter("Date");
           java.sql.Date date=java.sql.Date.valueOf(s);
          Work = request.getParameter("Work");
          Company = request.getParameter("Company");
          HomeTown= request.getParameter("HomeTown");
          PresLoc= request.getParameter("PresLoc");
          AboutYou= request.getParameter("AboutYou");
          HttpSession sess=request.getSession();
          UserName= sess.getAttribute("name").toString();
          

      
                PersonalInfoData data=new PersonalInfoData();
                int i = 0;
                try {
                   
                } catch (Exception ex) {
                    response.sendRedirect("User/PerInfo.jsp?err=2");
                    i = 1;
                }
                if (i == 0) {
                    data.setGender(Gender);
                    data.setHighSchool(HighSchool);
                    data.setHighSchoolYear(HighSchoolYear);
                    data.setGrad(Grad);
                     data.setGradYear(GradYear);
                    data.setDate(date);
                     data.setWork(Work);
                       data.setCompany(Company);
                        data.setHomeTown(HomeTown);
                         data.setPresLoc(PresLoc);
                          data.setAboutYou(AboutYou);
                           data.setUserName(UserName);

                    if (new PersonalInfoAction().InsertPerInfo(data)) {
                        response.sendRedirect("User/PerInfo.jsp?err=3");
                    } else {
                        response.sendRedirect("User/PerInfo.jsp?err=4");
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

