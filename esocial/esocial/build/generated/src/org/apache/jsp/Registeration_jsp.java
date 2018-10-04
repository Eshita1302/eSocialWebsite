package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Registeration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body><center>\n");
      out.write("        ");
      out.write("<center>\n");
      out.write("<div class=container>\n");
      out.write("    \n");
      out.write("<!-- head -->\n");
      out.write("<div class=head><div style=\"padding-top: 50px\"><div style=\"background-image: url(images/logo.png); background-repeat: no-repeat; height: 80px;\"> <div style=\"position: relative; left: 100px; top: -20px; text-align: left;\">\n");
      out.write("\t<table width=80%>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td style=\"text-align: left; font: 25px arial; color: #000000;\">My Social Network</td>\n");
      out.write("\t\t<td align=right>\n");
      out.write("\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n");
      out.write("\t\t\t<form name=\"loginform\" method=post action=\"\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>Username</td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"username\" size=\"13\" value=\"\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>Password</td>\n");
      out.write("\t\t\t\t<td><input type=\"Password\" name=\"password\" size=\"13\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input class=button type=\"submit\" name=\"Submit\" value=\"Log In\"></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</div></div></div></div>\n");
      out.write("\n");
      out.write("<!-- navigation menu -->\n");
      out.write("<div class=nav>\n");
      out.write("\t<a class=nav_text href=\"\">Home</a>\n");
      out.write("\t<a class=nav_text href=\"\">Sign Up</a>\n");
      out.write("\t<a class=nav_text href=\"\">Login</a>\n");
      out.write("\t<a class=nav_text href=\"\">Photos</a>\n");
      out.write("\t<a class=nav_text href=\"\">Chat Room</a>\n");
      out.write("\t<a class=nav_text href=\"\">Forum</a>\n");
      out.write("\t<a class=nav_text href=\"\">Groups</a>\n");
      out.write("</div></div>\n");
      out.write("    </center>\n");
      out.write("<!--\n");
      out.write("COPYRIGHT\n");
      out.write("Do not change or remove the reference to DatingSiteBuilder if you use the free version\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table cellpadding=\"10\" cellspacing=\"10\" border=\"0\">\n");
      out.write("            <form method=\"post\" action=\"InsertReg.Do\">\n");
      out.write("            <tr>\n");
      out.write("                <td>User Name <input type=\"text\" name=\"uname\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Password <input type=\"password\" name=\"pass\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Email ID <input type=\"text\" name=\"email\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Sceurity Question <select name=\"secQues\">\n");
      out.write("                        <option> What is your favorite color?</option>\n");
      out.write("                        <option> What is your hometown?</option>\n");
      out.write("                        <option> What is your pet's name?</option>\n");
      out.write("                        <option> What is your spouse's name?</option>\n");
      out.write("                        <option> What is your favorite car?</option>\n");
      out.write("                        <option> What is best friend's name?</option>\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> Security Answer <input type=\"text\" name=\"secAns\"/></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> <input type=\"submit\" value=\"Submit\"></td>\n");
      out.write("            </tr>\n");
      out.write("              <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"center\">\n");
      out.write("                        ");

                            String err=request.getParameter("err");
                            if(err!=null)
                            {
                                if(err.equals("1"))
                                {
                                    out.println("<b>Please Enter Some Data In al the Fields</b>");
                                }else if(err.equals("2"))
                                {
                                    out.println("<b>UserName already exists</b>");
                                }
                                else if(err.equals("3"))
                                {
                                    out.println("<b>You have been registered successfully !!</b>");
                                    
                                    response.sendRedirect("User/Home.jsp");

                                }
                                else if(err.equals("4"))
                                {
                                    out.println("<b>Registeration Unsuccessful !!</b>");
                                }
                            }
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("                    \n");
      out.write("        </table></center>\n");
      out.write("                    ");
      out.write("<div class=foot>Copyright &copy; 2012. All Rights Reserved. <a href=\"http://www.eshitathedesire.blogspot.com\">eSocial..by Eshita Gupta</a></div>");
      out.write("\n");
      out.write("                        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
