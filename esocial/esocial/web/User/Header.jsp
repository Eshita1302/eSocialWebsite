<%@page import="model.dataaction.ProPicAction"%>
<center>
<div class=container>
    
<!-- head -->
<div class=head><div style="padding-top: 50px"><div style="background-image: url(images/logo.png); background-repeat: no-repeat; height: 80px;"> <div style="position: relative; left: 100px; top: -20px; text-align: left;">
    <table width=80%>
	<tr>
		<td style="text-align: left; font: 25px arial; color: #000000;"> eSocial...</td>
		<td align=right>
			<table border="0" cellspacing="0" cellpadding="5">
			
			<tr>
                            <td>
                               
                                <%

                                    String huname = session.getAttribute("name").toString();
                                    String fileName = new ProPicAction().getPicName(huname);
                                    if(fileName!=null)
                                    {
                                        int index = fileName.lastIndexOf('.');
                                        String extensionName = fileName.substring(index,fileName.length());
                                        out.println("<img border=\"1\" class=\"magnify\" src=\"/esocial/upload/" + huname + extensionName + "\" width=\"90px\" height=\"90px\"/>");
                                    }
                                    else
                                    {

                                        out.println("<img border=\"1\" class=\"magnify\" src=\"ProfilePic/Female.gif\" width=\"90px\" height=\"90px\"/>");
                                    }


                                %>
                                </td>
                                <td align="right"><big><a href="/esocial/SignOut.Do"><h3>Sign Out</h3></a></big>
                                </td>
			</tr>

			</table>
		</td>
	</tr>
	</table>
                
            </div></div></div></div>
<div class=nav>
    <a class=nav_text href="/esocial/MainHome.Do">Home</a>
	<a class=nav_text href="/esocial/FetchInfo.Do">Personal Info</a>
	<a class=nav_text href="/esocial/User/Search.jsp">Search</a>
	<a class=nav_text href="/esocial/User/ProPic.jsp">ProfilePic</a>
	<a class=nav_text href="/esocial/FrnList.Do">New Friend Requests</a>
	<a class=nav_text href="/esocial/User/Album.jsp">Upload Album</a>
	<a class=nav_text href="/esocial/Friends.Do">Friends</a>
        <a class=nav_text href="/esocial/ViewAlbums.Do">Photos</a>
        <a class=nav_text href="/esocial/NewsFeed.Do">News Feed</a>
         <a class=nav_text href="/esocial/User/ChangePass.jsp">Change Password</a>
</div></div>
    </center>

