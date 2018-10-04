/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.common.AlbumData;
import model.dataaction.AlbumAction;

/**
 *
 * @author Esh
 */
@WebServlet(name="Album1", urlPatterns={"/Album1.Do"})
public class Album1 extends HttpServlet {
   
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
            String UserName,AlbumName,Desc;
            int TotalLike,TotalUnlike,CoverID;
           HttpSession sess=request.getSession();
           UserName = (String) sess.getAttribute("name");
            AlbumName= request.getParameter("aname");
            Desc=request.getParameter("Desc");


            if (UserName == null || AlbumName==null ) {
                response.sendRedirect("/esocial/User/Album.jsp?err=1");
            } else if (UserName.equals("") || AlbumName.equals("")) {
                response.sendRedirect("/esocial/User/Album.jsp?err=1");
            } else {
                AlbumData data=new AlbumData();
                int i = 0;
                try {
                    data.setUserName(UserName);
                } catch (Exception ex) {
                    response.sendRedirect("/esocial/User/Album.jsp?err=2");
                    i = 1;
                }
                if (i == 0) {
                    data.setAlbumName(AlbumName);
                    data.setDesc(Desc);

                    if (new AlbumAction().InsertAlbum(data)) {
                      //  HttpSession ses=request.getSession();
                      //  ses.setAttribute("name", UserName);
                        response.sendRedirect("/esocial/ViewAlbums.Do");
                    } else {
                        response.sendRedirect("/esocial/User/Album.jsp?err=4");
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
