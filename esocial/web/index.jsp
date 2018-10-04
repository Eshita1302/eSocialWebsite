<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>eSocial..</title>
<meta name="Keywords" content="">
<meta name="Description" content="">
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    function me ()
    {
        alert(" First SignIn your accout or Sign Up..")
    }
</script>
</head>

<body>

<center>
<div class=container>

<!-- head -->
<div class=head><div style="padding-top: 50px"><div style="background-image: url(images/logo.png); background-repeat: no-repeat; height: 80px;"> <div style="position: relative; left: 100px; top: -20px; text-align: left;">
	<table width=80%>
	<tr>
		<td style="text-align: left; font: 25px arial; color: #000000;">eSocial...</td>
		<td align=right>
			<table border="0" cellspacing="0" cellpadding="5">
			<form name="loginform" method="post" action="CheckLogin.Do">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uname" size="13" value=""></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="Password" name="upass" size="13"></td>
			</tr>
			<tr>
				<td><input class=button type="submit" name="Submit" value="Log In"></td>
			</tr>
                        <tr>
                            <td colspan="2" align="center">
                                
                                

                                   <%
                            String err=request.getParameter("err");
                            if(err!=null)
                            {
                                if(err.equals("1"))
                                {
                                    out.println("<b>Please Enter Some Data In Text Box</b>");
                                }else if(err.equals("2"))
                                {
                                    out.println("<b>UserName and Password cannot be blank</b>");
                                }
                                else if(err.equals("3"))
                                {
                                    out.println("<b>Invalid User Name and Password</b>");
                                }
                            }
                        %>
                            </td>
                        </tr>
			</form>
			</table>
		</td>
	</tr>
	</table>
</div></div></div></div>

<!-- navigation menu -->
<div class=nav>
	<a class=nav_text href="/esocial/index.jsp">Home</a>
	<a class=nav_text href="/esocial/Registeration.jsp">Sign Up</a>
	<a class=nav_text href="/esocial/Contact.jsp.jsp">Get In Touch</a>
	<a class=nav_text href="/esocial/New.jsp">New @ eSocial</a>
	
</div>

<div style="padding: 10px; text-align: left;">
<!-- body  content -->
<table cellpadding=10 width=100%>
<tr>
	<td>
		<img src="images/pic.png" width="518" height="137" border="0" alt="">
		<h2>Meet New Friends </h2>

		<table width=100%>
		<tr valign=top align=center>
			<td><a onclick="me()"  href="#"><img src="images/smart.jpg" width="100" height="150" border="0" alt=""></a><br>Joe Sparks<br>Age: 23<br>New York</td>
			<td><a  onclick="me()" href="#"><img src="images/users.jpg" width="100" height="150" border="0" alt=""></a><br>Lorea Jollie<br>Age: 20<br>Delhi</td>
			<td><a onclick="me()" href="#"><img src="images/user3.jpg" width="100" height="150" border="0" alt=""></a><br>Cindrella<br>Age: 18<br>Paris</td>
			<td><a onclick="me()" href="#"><img src="images/images.jpg" width="100" height="150" border="0" alt=""></a><br>Andrew George<br>Age: 27<br>Noida</td>
		</tr>
		</table>

		<h2>Blog</h2>


		<b>eSocial...where Friends meet !!!!<br><br><Br></b>
                <font color="red">Just like real life...</font>
                <br><br>
Share with all or separated groups of friends, controlling who sees what.
Connect with your best friend, your boss and your grandma with confidence.
Get the conversation started
<br><br>
Chat, comment and talk with each group of your friends for a conversation you control.
Have fun!
<br><br>
Easily share photos, videos and news. Join communities to discuss topics of your interest.

	</td>
	<td>
		<img src="images/main.png" width="245" height="474" border="0" alt="">

		
	
	</td>
</tr>
</table>

</div>

<!--
COPYRIGHT
Do not change or remove the reference to DatingSiteBuilder if you use the free version
-->
<div class=foot>Copyright &copy; 2012. All Rights Reserved. <a href="http://www.eshitathedesire.blogspot.com">eSocial..by Eshita Gupta</a></div>
</div>
</center>


</body>
</html>
