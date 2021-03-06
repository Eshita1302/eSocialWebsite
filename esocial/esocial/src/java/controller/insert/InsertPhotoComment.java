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
import model.common.PhotoCommentData;
import model.dataaction.PhotoCommentAction;

/**
 *
 * @author Esh
 */
public class InsertPhotoComment extends HttpServlet {
   
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
           String commentText, UserName;
            int PhotoID;

            HttpSession sess = request.getSession();
            commentText = request.getParameter("value");
            UserName = sess.getAttribute("name").toString();
       PhotoID = Integer.parseInt(request.getParameter("pid"));

            if (UserName == null || commentText == null) {
            } else if (UserName.equals("") || commentText.equals("")) {
            } else {
               PhotoCommentData data = new PhotoCommentData();
                int i = 0;
                try {
                    data.setPhotoID(PhotoID);
                } catch (Exception ex) {

                    i = 1;
                }
                if (i == 0) {
                    data.setCommentText(commentText);
                    data.setUserName(UserName);
                    data.setPhotoID(PhotoID);
                    new PhotoCommentAction().InsertComment(data);


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
