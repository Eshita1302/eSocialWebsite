<%-- 
    Document   : ProPic
    Created on : 6 Jul, 2012, 12:31:19 PM
    Author     : Esh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
         <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
    </head>
    <body>
          <%@include file="Header.jsp" %><bR>
          <br><center>
        <form action="/esocial/UploadPic.Do" enctype="multipart/form-data" method="post">
            Chose a photo to upload as display pic <input type="file" name="dp"><br/>
            <input type="submit" value="Upload Display Pic">
        </form><br><BR></center>
          
          <%@include file="Footer.jsp" %>
    </body>
</html>
