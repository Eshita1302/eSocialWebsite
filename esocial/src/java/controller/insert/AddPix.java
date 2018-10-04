/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.common.AlbumPhotoData;
import model.dataaction.AlbumPhotoAction;

/**
 *
 * @author Esh
 */
@WebServlet(name="AddPix", urlPatterns={"/AddPix.Do"})
public class AddPix extends HttpServlet {
   
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
            Part p=request.getPart("dp");
            Part p1=request.getPart("aid");
            Scanner sc = new Scanner( p1.getInputStream());
            int aid = sc.nextInt();
            InputStream is=p.getInputStream();
            String fileName = getFileName(p);
          
            AlbumPhotoData data=new AlbumPhotoData();
            data.setPhotoName(getFileName(p));
            data.setPhotoSize(is.available());
            data.setPhotoType(p.getContentType());
            
            data.setAlbumID(aid);
            int i=new AlbumPhotoAction().InsertAlbumPic(data);
            int index = fileName.lastIndexOf('.');
            String ext = fileName.substring(index,fileName.length());
            String outputfile = getServletContext().getRealPath("albums/" + i + ext);
            FileOutputStream os = new FileOutputStream (outputfile);
            int ch = is.read();
            while (ch != -1) {
                 os.write(ch);
                 ch = is.read();

            }
            os.close();
          //  out.println(" Uploaded Successfully");
            response.sendRedirect("/esocial/User/ViewAlbums.jsp");
        } finally {
            out.close();
        }
    }
private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
