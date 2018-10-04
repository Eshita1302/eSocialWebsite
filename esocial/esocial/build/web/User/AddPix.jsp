<%-- 
    Document   : AddPix
    Created on : 13 Jul, 2012, 8:07:32 PM
    Author     : Esh
--%>
<%
    String str="";
    if(request.getParameter("uid")==null)
    {
        response.sendRedirect("ViewAlbums.jsp");
    }
    else
    {
        str=request.getParameter("uid");
    }
%>
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
          <br><center>
               <form action="/esocial/AddPix.Do" enctype="multipart/form-data" method="post">
            Chose a photo to upload <input type="file" name="dp"><br/>
            <input type="hidden" name="aid" value="<%= str %>"/>
            <input type="submit" value="Upload Pic">
              
        </form><br><BR></center>

          <%@include file="Footer.jsp" %>
    </body>
</html>
