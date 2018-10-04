<%-- 
    Document   : Album
    Created on : 9 Jul, 2012, 8:44:16 PM
    Author     : Esh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>       <link href="style.css" rel="stylesheet" type="text/css">
         <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
    </head>
    <body>
        <%@include file="Header.jsp" %><bR>
          <br><center>
              <h3>Create a new Album</h3>
        <form action="/esocial/Album1.Do"  method="post">
            Name of the album <input type="text" name="aname"><br><br>
             Description of the album <textarea cols="15" rows="5" name="Desc"></textarea><br><br>
            <input type="submit" value="Create Album">
        </form><br><BR></center>

          <%@include file="Footer.jsp" %>
    </body>
</html>
