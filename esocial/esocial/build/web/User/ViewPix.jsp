<%-- 
    Document   : ViewPix
    Created on : 13 Jul, 2012, 8:33:05 AM
    Author     : Esh
--%>

<%@page import="model.common.ProPicData"%>
<%@page import="model.dataaction.PhotoCommentAction"%>
<%@page import="model.common.PhotoCommentData"%>
<%@page import="model.dataaction.AlbumPhotoAction"%>
<%@page import="model.common.AlbumPhotoData"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><link href="style.css" rel="stylesheet" type="text/css"/>
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
            function disableEnterKey(e,tdata,pid)
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
                    if(pid!="")
                    {
                        alert(tdata + " " + pid);
                        var path="/esocial/InsertPhotoComment.Do?pid=" + pid + "&value=" + tdata;
                        var xmlhttp=makeRequestObject();
                        xmlhttp.open("GET",path,true);
                        xmlhttp.onreadystatechange=function(){
                            if(xmlhttp.readyState==4 && xmlhttp.status==200)
                            {
                                alert("Comment Added To System");
                                document.getElementById("comment" + pid).value="";
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
         HttpSession sess=request.getSession();
         if(sess.getAttribute("dp")!=null)
             {
                List<AlbumPhotoData> data=(List<AlbumPhotoData>)session.getAttribute("dp");
                if(data!=null)
                {
                    out.println("<center>");
                                    
                    for(AlbumPhotoData ltd:data)
                    {
                        int huna=ltd.getPhotoID();
                        String fileNa =ltd.getPhotoName();
                       int index = fileNa.lastIndexOf('.');
                        String extensionNa = fileNa.substring(index,fileNa.length());
                         out.println("<img class=\"magnify\" border=\"1\" src=\"/esocial/albums/" + huna + extensionNa + "\" width=\"300px\" height=\"200px\"/>");
                         out.println("&nbsp;&nbsp;&nbsp;&nbsp; ");
                           List<ProPicData> d1 = (List<ProPicData>) session.getAttribute("propix");
                         List<PhotoCommentData> da= new PhotoCommentAction(). showComments(ltd.getPhotoID());
                            if(da!=null)
                                   {
                                for (PhotoCommentData scd : da)
                                    {
                                     if (d1 != null) {

                                    for (ProPicData ppd : d1) {
                                        if (scd.getUserName().equals(ppd.getUserName())) {

                                            String pname = ppd.getPhotoName();
                                            int ind = pname.lastIndexOf('.');
                                            String extensionName = pname.substring(ind, pname.length());

                                            out.println("<br><img class=\"magnify\" src=\"/esocial/upload/" + ppd.getUserName() + extensionName + "\" width=\"50px\" height=\"50px\"/>");
                                            break;
                                                    }
                                              }
                                         }
                                    out.print("<h1>"+ scd.getUserName()+ "</h1>");
                                    out.println("<h3>"+ scd.getCommentText()+ "</h3>");
                                    }
                             

}                          out.println("<br><br>");
                          out.println("Comment");
                      out.println("<br><textarea id=\"comment" + ltd.getPhotoID() + "\" onkeypress=\"disableEnterKey(event,this.value," + ltd.getPhotoID() + ");\" col=\"5\" rows=\"2\"></textarea><br><br><br>");
                    }
                }out.println("</center>");
             }
          %>
          <br><br>
          <br> <%@include file="Footer.jsp" %><bR>
    </body>
</html>
