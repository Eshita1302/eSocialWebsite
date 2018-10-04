<%-- 
    Document   : Contact.jsp
    Created on : 28 Jul, 2012, 7:26:50 PM
    Author     : Esh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <br> <%@include file="Header.jsp" %><bR><center>
              <font face="ComicSans" color="red"><h2 width="80%">CONNECT & CONTACT US !!</h2></font>
                  <h2> Stay in touch and help us improve...</h2>
                  <form action="/esocial/index.jsp">
                  <table>
                      <tr>
                          <td>Name</td><td> <input type="text" name="pname"></td>
                      </tr><br>
                      <tr>
                          <td>Email</td><td> <input type="text" name="email"></td>
                      </tr><br>
                      <tr>
                          <td >Message/Comment</td>
                      <td> <textarea name="msg"></textarea rows="10" cols="5"></td>
                      </tr><br>
                      <tr>
                          <td colspan="2">
                              <input type="submit" value="Send"></td>
                      </tr>
                  </table>

              </form>
        </center>
              <br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
