<%-- 
    Document   : ChangePass
    Created on : 28 Jul, 2012, 1:04:27 PM
    Author     : Esh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
       <%@include file="Header.jsp" %><bR><br><center>
           <form method="post" action="/esocial/ChangePass.Do">
       <table>
           <tr>
               <td> Old Password</td><td> <input type="password" name="oldpass" ></td>
           </tr>
           <tr>
               <td> New Password</td> <td><input type="password" name="newpass"></td>
           </tr>
           <tr>
               <td> Confirm New Password</td><td> <input type="password" name="cnewpass" ></td>
           </tr>
           <tr><td colspan="2">
                   <input type="submit" value="Change Password"></td>
           </tr>
            </table> </form>
                   <%
                            String erro=request.getParameter("err");
                            if(erro!=null)
                            {
                                if(erro.equals("1"))
                                {
                                    out.println("<br><b>New Passwords did not match. Try Again !!</b>");
                                }
                                else if(erro.equals("2"))
                                {
                                    out.println("<br><b>Password Changed Successfully !!</b>");
                                }
                            }
                        %>
       </center>
       <br><br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
