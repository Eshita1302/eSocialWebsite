<%-- 
    Document   : FrnList
    Created on : 9 Jul, 2012, 2:51:04 PM
    Author     : Esh
--%>

<%@page import="model.common.FrnReqData"%>
<%@page import="java.util.List"%>
<%@page import="model.common.ProPicData"%>
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
        <%@include file="Header.jsp" %><bR><br><center>
            <h3><u>Pending Friend Requests</u></h3>

            <%
            HttpSession sess=request.getSession();
         
            if(sess.getAttribute("req")!=null || ("req")!=""){

                        List<FrnReqData> data = (List<FrnReqData>) session.getAttribute("req");
                        if (data != null) {
                            for (FrnReqData ltd : data) {
                                if (ltd.getIsApproved() == 0) {
                                    out.println("<a href=\"/esocial/ViewProfile.Do?uname=" + ltd.getsUserName() + "\">"
                                            + ltd.getsUserName() + "</a>");
                                   out.println(" <a href=\"/esocial/AddFrn.Do?sname=" + ltd.getsUserName() +"&frID=" + ltd.getFrID() + "\">");
                                            out.println("Confrm Friend Request");
                                            out.println("</a><br><br>");
                                            
                                   
                                }
                            }
                        }}
            %>
        </center>        <br><br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
