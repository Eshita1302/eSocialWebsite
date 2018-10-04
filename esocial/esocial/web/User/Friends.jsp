<%-- 
    Document   : Friends
    Created on : 9 Jul, 2012, 9:09:00 PM
    Author     : Esh
--%>

<%@page import="model.common.FrnListData"%>
<%@page import="model.common.FrnReqData"%>
<%@page import="model.common.FrnReqData"%>
<%@page import="model.common.ProPicData"%>
<%@page import="model.common.ProPicData"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/jquerymagnifier.js"></script>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="Header.jsp" %><bR><br><center>
            <h2><u>Friend List</u></h2>
            <%
                        HttpSession sess = request.getSession();

                        if (sess.getAttribute("requ") != null) {

                            List<FrnListData> data = (List<FrnListData>) session.getAttribute("requ");
                            if (data != null) {
                                List<ProPicData> d1 = (List<ProPicData>) session.getAttribute("propix");
                                for (FrnListData ltd : data) {
                                    if (d1 != null) {
                                        boolean yes = false;
                                        for (ProPicData ppd : d1) {
                                            if (ltd.getF2UserName().equals(ppd.getUserName())) {

                                                String pname = ppd.getPhotoName();
                                                int ind = pname.lastIndexOf('.');
                                                String extensionName = pname.substring(ind, pname.length());
                                                out.println("<img border=\"1\" class=\"magnify\" src=\"/esocial/upload/" + ppd.getUserName() + extensionName + "\" width=\"50px\" height=\"50px\"/>");
                                                yes=true;
                                                break;
                                            }
                                        }
                                        if(yes==false)
                                        {
                                            out.println("<img border=\"1\" class=\"magnify\" src=\"/esocial/User/ProfilePic/Male.jpg\" width=\"50px\" height=\"50px\"/>");
                                        }
                                    }
                                    out.println("<a href=\"/esocial/ViewProfile.Do?uname=" + ltd.getF2UserName() + "\">"
                                            + ltd.getF2UserName() + "</a><br><br>");

                                }
                            }
                        }
            %>
        </center>        <br><br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
