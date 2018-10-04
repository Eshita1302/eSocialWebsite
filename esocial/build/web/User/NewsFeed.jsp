<%-- 
    Document   : NewsFeed
    Created on : 15 Jul, 2012, 2:46:11 PM
    Author     : Esh
--%>

<%@page import="model.dataaction.PhotoCommentAction"%>
<%@page import="model.common.PhotoCommentData"%>
<%@page import="model.common.StatusCommData"%>
<%@page import="model.dataaction.StatusCommAction"%>
<%@page import="model.common.ProPicData"%>
<%@page import="model.common.StatusData"%>
<%@page import="java.util.List"%>
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
        <script type="text/javascript">
            function makeRequestObject()
            {
                var xmlhttp=false;
                try
                {
                    xmlhttp=new ActiveXObject('Msxml2.XMLHTTP');
                }
                catch(e)
                {
                    try
                    {
                        xmlhttp=new ActiveXObject('Microsoft.XMLHTTP');
                    }
                    catch(E)
                    {
                        if(!xmlhttp && typeof XMLHttpRequest!='undefined')
                        {
                            xmlhttp=new XMLHttpRequest();
                        }
                    }
                }
                return xmlhttp;
            }
            function StatusLike(sid)
            {
                
                var path="/esocial/InsertStatusLike.Do?sid=" + sid ;
               // alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {
                                
                                var val = document.getElementById("stlike" + sid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                           //     alert(ans);
                                document.getElementById("stlike" + sid).innerHTML=ans;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                                 var id = "sllike" + sid;
                                document.getElementById("sllike" + sid).disabled=true;
                            }
                        }
                        xmlhttp.send(null);
            }
            
            function StatusCommentLike(cid)
            {
                var path="/esocial/InsertStatusCommentLike.Do?cid=" + cid ;
               // alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("splike" + cid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                          //      alert(ans);
                                document.getElementById("splike" + cid).innerHTML=ans;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                                 var id = "commlike" + cid;
                                document.getElementById("commlike" + cid).disabled=true;
                            }
                        }
                        xmlhttp.send(null);
            }

               function StatusCommentUnlike(cid)
            {
                var path="/esocial/InsertStatusCommentUnlike.Do?cid=" + cid ;
             //   alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("spunlike" + cid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                             //   alert(ans);
                                document.getElementById("spunlike" + cid).innerHTML=ans;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                                 var id = "communlike" + cid;
                                document.getElementById("communlike" + cid).disabled=true;
                            }
                        }
                        xmlhttp.send(null);
            }
             function StatusUnlike(sid)
            {
                var path="/esocial/InsertStatusUnlike.Do?sid=" + sid ;
              //  alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("stunlike" + sid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                           //     alert(ans);
                                document.getElementById("stunlike" + sid).innerHTML=ans;
                                 var id = "slunlike" + sid;
                                document.getElementById("slunlike" + sid).disabled=true;
                            }
                        }
                        xmlhttp.send(null);
            }
            var ans = 0;
	
            function disableEnterKey(e,tdata,sid)
            {
                var key;
                if(window.event)
                {
                    key=window.event.keyCode;
                }
                else
                {
                    key=e.which;
                }
                if(key==13)
                {
                    if(sid!="")
                    {
                      //  alert(tdata + " " + sid);
                        var path="/esocial/InsertComment.Do?sid=" + sid + "&value=" + tdata;
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {
                                alert("Comment Added To System");
                                document.getElementById("comment" + sid).value="";
                            }
                        }
                        xmlhttp.send(null);
                    }
                    return false;
                }
                else
                {
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <%@include file="Header.jsp" %><bR>
        <br>
        <br>
        <%
                    HttpSession sess = request.getSession();
                    if (sess.getAttribute("status") != null) {
                        List<StatusData> data = (List<StatusData>) session.getAttribute("status");
                        List<ProPicData> d1 = (List<ProPicData>) session.getAttribute("propix");
                        if (data != null) {
                            for (StatusData ltd : data) {
                                out.println("<div id=\"status" + ltd.getStatusID() + "\" style=\"border:2px solid green;padding:10px;width:70%;margin:0 auto;\">");
                                out.println("<h2>" + ltd.getUserName() + "</h2>");
                                if (d1 != null) {
                                    for (ProPicData ppd : d1) {
                                        if (ltd.getUserName().equals(ppd.getUserName())) {

                                            String pname = ppd.getPhotoName();
                                            int ind = pname.lastIndexOf('.');
                                            String extensionName = pname.substring(ind, pname.length());

                                            out.println("<img border=\"1\" class=\"magnify\" src=\"/esocial/upload/" + ppd.getUserName() + extensionName + "\" width=\"50px\" height=\"50px\"/>");
                                            break;
                                        }
                                    }
                                }

                                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h3>" + ltd.getStatusText() + "</h3>");
                                out.println("<span id=\"stlike" + ltd.getStatusID() +  "\">" +  ltd.getTotalLikes() +"</span>");
                                out.println("<a id=\"sllike" + ltd.getStatusID() + "\" href=\"#\" onclick=\"StatusLike(" + ltd.getStatusID() +  ")\">Like</a>");
                                out.println("<span id=\"stunlike" + ltd.getStatusID() +  "\">" +  ltd.getTotalUnlikes() +"</span>");
                                out.println("&nbsp;&nbsp;&nbsp;<a id=\"slunlike" + ltd.getStatusID() + "\" href=\"#\" onclick=\"StatusUnlike("+ltd.getStatusID() +")\">Unlike</a>");
                                List<StatusCommData> da = new StatusCommAction().showAllComments(ltd.getStatusID());
                                out.println("<div id=\"statuscomment" + ltd.getStatusID() + "\" style=\"border:2px solid red;padding:10px\">");
                                if (da != null) {
                                    
                                    for (StatusCommData scd : da) {
                                        out.println("<div>");
                                        if (d1 != null) {
                                            for (ProPicData ppd : d1) {
                                                if (scd.getUserName().equals(ppd.getUserName())) {

                                                    String pname = ppd.getPhotoName();
                                                    int ind = pname.lastIndexOf('.');
                                                    String extensionName = pname.substring(ind, pname.length());

                                                    out.println("<div style=\"float:left\"><img border=\"1\" class=\"magnify\" src=\"/esocial/upload/" + ppd.getUserName() + extensionName + "\" width=\"50px\" height=\"50px\"/></div>");
                                                    break;
                                                }

                                            }
                                        }
                                      
                                        out.print("<div><a href=\"/esocial/ViewProfile.Do?uname=" + scd.getUserName() + "\">"
                                            + scd.getUserName() + "</a></div>");
                                        out.println("<div>" + scd.getCommentText() + "</div>");
                                out.println("<span id=\"splike" + scd.getCommentID() +  "\">" +  scd.getTotalLike() +"</span>");
                                out.println("<a id=\"commlike" + scd.getCommentID() + "\" href=\"#\" onclick=\"StatusCommentLike(" + scd.getCommentID() +  ")\">Like</a>");
                                out.println("<span id=\"spunlike" + scd.getCommentID() +  "\">" +  scd.getTotalUnlike() +"</span>");
                                out.println("<a id=\"communlike" + scd.getCommentID() + "\" href=\"#\" onclick=\"StatusCommentUnlike(" + scd.getCommentID() +  ")\">Unlike</a><br><br><br>");
                                       // out.println("<div><a href=\"\">Like</a>&nbsp;&nbsp;&nbsp;<a href=\"\">Unlike</a></div><br><br><br>");
                                    
                                        out.println("</div>");
                                    }
                                    
                                }
                                out.println("</div>");
                                out.println("Comment");
                                out.println("<br><textarea id=\"comment" + ltd.getStatusID() + "\" onkeypress=\"disableEnterKey(event,this.value," + ltd.getStatusID() + ");\" col=\"5\" rows=\"2\"></textarea>");
                                out.println("</div><br/>");
                            }
                        }

                    }
        %>
        <br><br>
        <br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
