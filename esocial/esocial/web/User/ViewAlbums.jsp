<%-- 
    Document   : ViewAlbums
    Created on : 12 Jul, 2012, 9:45:00 AM
    Author     : Esh
--%>

<%@page import="model.common.AlbumData"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="style.css" rel="stylesheet" type="text/css">
           <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
    </head>
    <body>
          <%@include file="Header.jsp" %><bR>
          <%
          HttpSession sess=request.getSession();
          String name=(String)sess.getAttribute("name");
         if(sess.getAttribute("albums")!=null)
             {
                List<AlbumData> data=(List<AlbumData>)session.getAttribute("albums");
                if(data!=null)
                {
                    
                    for(AlbumData ltd:data)
                    {
                        if(ltd.getUserName().equals(name))
                            {
                         out.println("<h1><a href=\"/esocial/ViewPix.Do?uid=" + ltd.getAlbumID() + "\">"
                                + ltd.getAlbumName() + "</a></h1>");
                          out.println("<h3>" + ltd.getDesc() + "</h3>");
                        out.println("<a href=\"AddPix.jsp?uid=" + ltd.getAlbumID() + "\">Add Pics to Album</a>");
                        out.println("<br>");
                        out.println("<br>");
                        }

                    }
                    
                }
             } 
          %>

          <br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
