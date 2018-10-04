<%-- 
    Document   : PerInfo
    Created on : 27 Jun, 2012, 11:11:22 PM
    Author     : Esh
--%>

<%@page import="model.common.PersonalInfoData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/calendarDateInput.js"></script>
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
         <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <%
                    if (session.getAttribute("fdata") != null) {
                        PersonalInfoData d = (PersonalInfoData) session.getAttribute("fdata");
                        out.println(" <table cellpadding=\"10\" cellspacing=\"10\" border=\"0\">");
                        out.println("<form method=\"post\" action=\"/esocial/UpdateInfo.Do\">");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Basic Information</B></td>");
                        out.println("</tr>");

                        out.println("<tr>");

                        out.println("<td>Gender<select name=\"Gender\" value=\"" + d.getGender() + "\"/><option selected=\"selected\">Male</option><option selected=\"selected\">Female</option></select></td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td> Birthday </td>");

                        out.println("<td> <script>DateInput('Date',true,'YYYY-MM-DD','" + d.getDate() + "')</script></td>");

                        out.println(" </tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Work and Educational</B></td>");
                        out.println("</tr>");
                        out.println("<tr>");

                        out.println("<td>High School <input type=\"text\" name=\"HighSchool\" value=\"" + d.getHighSchool() + "\"/></td>");
                        out.println("<td>Year <input type=\"text\" name=\"HighSchoolYear\" value=\"" + d.getHighSchoolYear() + "\"/></td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td>Graduation School <input type=\"text\" name=\"Grad\" value=\"" + d.getGrad() + "\"/></td>");
                        out.println(" <td>Year <input type=\"text\" name=\"GradYear\" value=\"" + d.getGradYear() + "\"/></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td>Work <input type=\"text\" name=\"Work\" value=\"" + d.getWork() + "\"/></td>");
                        out.println("<td>Comapny / Institute <input type=\"text\" name=\"Company\" value=\"" + d.getCompany() + "\"></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Living</B></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td>HomeTown <input type=\"text\" name=\"HomeTown\" value=\"" + d.getHomeTown() + "\"/> </td>");
                        out.println("<td>Present Location <input type=\"text\" name=\"PresLoc\" value=\"" + d.getPresLoc() + "\"/> </td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">About you !!</td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><textarea cols=\"100\" rows=\"10\" name=\"AboutYou\">" + d.getAboutYou() + "</textarea></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<input type=\"submit\" value=\"Update\"/>");
                        out.println("</td>");
                        out.println(" </tr>");
                        out.println("</form>");
                        out.println("</table>");
                    } else {
                        out.println(" <table cellpadding=\"10\" cellspacing=\"10\" border=\"0\">");
                        out.println("<form method=\"post\" action=\"/esocial/InsertPerInfo.Do\">");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Basic Information</B></td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td>Gender<select name=\"Gender\"><option>Male</option><option>Female</option></select></td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td> <script type=\"text/javascript\">DateInput('Date',true,'YYYY-MM-DD')</script> </td>");
                        out.println(" </tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Work and Educational</B></td>");
                        out.println("</tr>");
                        out.println("<tr>");

                        out.println("<td>High School <input type=\"text\" name=\"HighSchool\"></td>");
                        out.println("<td>Year <input type=\"text\" name=\"HighSchoolYear\"></td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td>Graduation School <input type=\"text\" name=\"Grad\"></td>");
                        out.println(" <td>Year <input type=\"text\" name=\"GradYear\"></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td>Work <input type=\"text\" name=\"Work\"></td>");
                        out.println("<td>Comapny/Institute <input type=\"text\" name=\"Company\"></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><B>Living</B></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td>HomeTown <input type=\"text\" name=\"HomeTown\"/> </td>");
                        out.println("<td>Present Location <input type=\"text\" name=\"PresLoc\"/> </td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">About you !!</td>");
                        out.println(" </tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><textarea cols=\"100\" rows=\"10\" name=\"AboutYou\"></textarea></td>");
                        out.println("</tr>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<input type=\"submit\" value=\"Insert Info\"/>");
                        out.println("</td>");
                        out.println(" </tr>");
                        out.println("</form>");
                        out.println("</table>");
                    }
        %>


        <%@include file="Footer.jsp" %>
    </body>
</html>
