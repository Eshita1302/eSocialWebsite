<%-- 
    Document   : Search
    Created on : 4 Jul, 2012, 3:21:47 PM
    Author     : Esh
--%>

<%@page import="java.util.List"%>
<%@page import="model.common.LoginTableData"%>
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
         <%@include file="Header.jsp" %><center>
        <form method="post" action="/esocial/Search.Do">
            <table border="0">
                <tr>
                    <td></td>
                </tr><tr></tr>
                <tr><td>
                        Enter UserName or Email ID  <input type="text" name="searchName"></td></tr>
                <tr>
                    <td>
                        <input type="submit" value="Search">

                    </td>
                </tr><tr><td></td></tr><tr><td></td></tr>
            </table>
        </form></center>
         <%
         HttpSession sess=request.getSession();
         if(sess.getAttribute("search")!=null || ("search")!="")
             {
                List<LoginTableData> data=(List<LoginTableData>)session.getAttribute("search");
                if(data!=null)
                {
                    for(LoginTableData ltd:data)
                    {
                        out.println("<h1><a href=\"/esocial/ViewProfile.Do?uname=" + ltd.getUserName() + "\">"
                                + ltd.getUserName() + "</a></h1>");
                    }
                }
             }
         %>
         <%@include file="Footer.jsp" %>
    </body>
</html>
