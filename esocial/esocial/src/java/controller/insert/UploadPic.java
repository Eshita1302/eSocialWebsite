/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.insert;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.common.ProPicData;
import model.dataaction.ProPicAction;

@MultipartConfig
public class UploadPic extends HttpServlet {

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
            InputStream is=p.getInputStream();
            String fileName = getFileName(p);
            HttpSession sess=request.getSession();
            String UserName =(String) sess.getAttribute("name");
            ProPicData data=new ProPicData();
            data.setPhotoName(getFileName(p));
            data.setPhotoSize(is.available());
            data.setPhotoType(p.getContentType());
            data.setUserName(UserName);
            new ProPicAction().InsertProPic(data);
            int index = fileName.lastIndexOf('.');
            String ext = fileName.substring(index,fileName.length());
            String outputfile = getServletContext().getRealPath("upload/" + UserName + ext);
            FileOutputStream os = new FileOutputStream (outputfile);
            int ch = is.read();
            while (ch != -1) {
                 os.write(ch);
                 ch = is.read();

            }
            os.close();
          //  out.println(" Uploaded Successfully");
            response.sendRedirect("/esocial/User/Home.jsp");
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
