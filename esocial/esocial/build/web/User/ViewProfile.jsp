<%-- 
    Document   : ViewProfile
    Created on : 4 Jul, 2012, 4:23:07 PM
    Author     : Esh
--%>

<%@page import="model.common.PersonalInfoData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="style.css" rel="stylesheet" type="text/css">
         <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
          <title>JSP Page</title>
    </head>
    <body>
        <center>
         <%@include file="Header.jsp" %>
        <%
        if(session.getAttribute("fdata")!=null)
            {
            PersonalInfoData d=(PersonalInfoData) session.getAttribute("fdata");
             out.println(" <table cellpadding=\"10\" cellspacing=\"10\" border=\"0\">");
                out.println("<tr>");
                out.println("<td colspan=\"2\" align=\"center\">");
                 out.println("<form action=\"/esocial/FrnReq.Do\" method=\"post\">");
                 out.println("<input type=\"hidden\" value=\"" + d.getUserName() + "\" name=\"funame\"/>");
                 out.println("<input type=\"submit\" value=\"Add as a Friend\">");
            out.println("</form>");

                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td colspan=\"2\"><B>Basic Information</B></td>");
                out.println("</tr>");

                out.println("<tr>");

                    out.println("<td>Gender<td>");
                   out.println("<td>"+ d.getGender() + "</td>");
                  out.println(" </tr>");
                out.println("<tr>");
                out.println("<td> Birthday </td>");
                out.println("<td>" + d.getDate() + "</td>");
               out.println(" </tr>");

                out.println("<tr>");
                out.println("<td colspan=\"2\"><B>Work and Educational</B></td>");
                out.println("</tr>");
                out.println("<tr>");

                out.println("<td>High School </td>");
                out.println ("<td>" + d.getHighSchool() + "</td>");
               out.println("<td>Year </td>");
                out.println("<td>" + d.getHighSchoolYear() + "</td>");
               out.println(" </tr>");
                out.println("<tr>");
                    out.println("<td>Graduation School</td>");
                    out.println("<td>" + d.getGrad() + "</td>");
                   out.println(" <td>Year </td>");
                   out.println("<td>" + d.getGradYear() + "</td>");
                out.println("</tr>");
                 out.println("<tr>");
                    out.println("<td>Work </td>");
                    out.println("<td>" + d.getWork() + "</td>");
                    out.println("<td>Comapny/Institute </td> ");
                     out.println("<td>" + d.getCompany() + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td colspan=\"2\"><B>Living</B></td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Hometown </td>");
                    out.println("<td>" +  d.getHomeTown() + "</td>");
                    out.println("<td>Present Location </td>");
                   out.println("<td>" + d.getPresLoc() + "</td>");
               out.println(" </tr>");
                out.println("<tr>");
                    out.println("<td colspan=\"2\">About you !!</td>");
               out.println(" </tr>");
                out.println("<tr>");
                    out.println("<td colspan=\"2\">" + d.getAboutYou() + "</td>");
                out.println("</tr>");
              
            
        out.println("</table>");
            }



         %>
        </center>
  <%@include file="Footer.jsp" %>
        
    </body>
</html>
