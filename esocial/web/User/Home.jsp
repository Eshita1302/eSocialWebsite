<%-- 
    Document   : Home
    Created on : 27 Jun, 2012, 11:05:13 PM
    Author     : Esh
--%>

<%@page import="model.dataaction.StatusCommAction"%>
<%@page import="model.common.StatusCommData"%>
<%@page import="model.common.ProPicData"%>
<%@page import="model.dataaction.StatusTableAction"%>
<%@page import="model.common.StatusData"%>
<%@page import="java.util.List"%>
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
            //    alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("stlike" + sid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                             //   alert(ans);
                                document.getElementById("stlike" + sid).innerHTML=ans;
                             //   alert("stllike" + sid);
                                var id = "stllike" + sid;
                                document.getElementById("stllike" + sid).disabled=true;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                            }
                        }
                        xmlhttp.send(null);
            }
            function StatusCommentLike(cid)
            {
                var path="/esocial/InsertStatusCommentLike.Do?cid=" + cid ;
        //        alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("splike" + cid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                               // alert(ans);
                                document.getElementById("splike" + cid).innerHTML=ans;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                            }
                        }
                        xmlhttp.send(null);
            }

               function StatusCommentUnlike(cid)
            {
                var path="/esocial/InsertStatusCommentUnlike.Do?cid=" + cid ;
          //      alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("spunlike" + cid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                            //    alert(ans);
                                document.getElementById("spunlike" + cid).innerHTML=ans;
                                //val = val + 1;
                                //document.getElementById("stlike" + sid).innerText=val;
                            }
                        }
                        xmlhttp.send(null);
            }
             function StatusUnlike(sid)
            {
                var path="/esocial/InsertStatusUnlike.Do?sid=" + sid ;
                //alert(path);
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {

                                var val = document.getElementById("stunlike" + sid).innerHTML;
                                var ans = parseInt(val);
                                ans = ans + 1;
                               // alert(ans);
                                document.getElementById("stunlike" + sid).innerHTML=ans;
                                  var id = "stlunlike" + sid;
                                document.getElementById("stlunlike" + sid).disabled=true;
                            }
                        }
                        xmlhttp.send(null);
            }
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
                     //   alert(tdata + " " + sid);
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

         <%@include file="Header.jsp" %>
         <center>
             
        <h1>Welcome User !! </h1>
        <h3>What's on your mind ??</h3>
       
        <form action="/esocial/InsertStatus.Do">
            <table>
                <tr>
                    <td><textarea name="status"></textarea></td>
            </tr>
            <tr>
                <td>
            <input type="submit" value="POST" name="Post">
                </td>
            </tr>
            </table>
 
        </form></center>
        <%
         HttpSession sess=request.getSession();
         List<ProPicData> d1 = (List<ProPicData>) session.getAttribute("propix");

            if(sess.getAttribute("mystat")!=null){

                        List<StatusData> data = (List<StatusData>) session.getAttribute("mystat");
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
                                out.println("<H1>" + ltd.getStatusText()+ "</H1>");
                                out.println("<span id=\"stlike" + ltd.getStatusID() +  "\">" +  ltd.getTotalLikes() +"</span>");
                                out.println("<a href=\"#\" id=\"stllike" + ltd.getStatusID() + "\" onclick=\"StatusLike(" + ltd.getStatusID() +  ")\">Like</a>");
                                out.println("<span id=\"stunlike" + ltd.getStatusID() +  "\">" +  ltd.getTotalUnlikes() +"</span>");
                                out.println("&nbsp;&nbsp;&nbsp;<a href=\"#\" id=\"stlunlike" + ltd.getStatusID() + "\" onclick=\"StatusUnlike("+ltd.getStatusID() +")\">Unlike</a>");
                                   
                                    out.println("</div><br><br><br>");
                                }
                        }}
        %>
       
        <%@include file="Footer.jsp" %>
    </body>
</html>
