<%-- 
    Document   : Registeration
    Created on : 27 Jun, 2012, 9:30:02 AM
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
    <body><center>
        <%@include file="Header.jsp" %>
        <table cellpadding="10" cellspacing="10" border="0">
            <form method="post" action="InsertReg.Do">
            <tr>
                <td>User Name <input type="text" name="uname"/></td>
            </tr>
            <tr>
                <td>Password <input type="password" name="pass"/></td>
            </tr>
            <tr>
                <td>Email ID <input type="text" name="email"/></td>
            </tr>
             <tr>
                <td>Contact No. <input type="text" name="phoneno"/></td>
            </tr>
            <tr>
                <td>Sceurity Question <select name="secQues">
                        <option> What is your favorite color?</option>
                        <option> What is your hometown?</option>
                        <option> What is your pet's name?</option>
                        <option> What is your spouse's name?</option>
                        <option> What is your favorite car?</option>
                        <option> What is best friend's name?</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td> Security Answer <input type="text" name="secAns"/></td>
            </tr>
            <tr>
                <td> <input type="submit" value="Submit"></td>
            </tr>
              <tr>
                    <td colspan="2" align="center">
                        <%
                            String erro=request.getParameter("err");
                            if(erro!=null)
                            {
                                if(erro.equals("1"))
                                {
                                    out.println("<b>Please Enter Some Data In al the Fields</b>");
                                }else if(erro.equals("2"))
                                {
                                    out.println("<b>UserName already exists</b>");
                                }
                                else if(erro.equals("4"))
                                {
                                    out.println("<b>Registeration Unsuccessful !!</b>");
                                }
                            }
                        %>
                    </td>
                </tr>
            </form>
                    
        </table></center>
                    <%@include file="Footer.jsp" %>
                        
    </body>
</html>
