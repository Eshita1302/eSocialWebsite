package org.apache.jsp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.dataaction.ProPicAction;

public final class Album_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/User/Header.jsp");
    _jspx_dependants.add("/User/Footer.jsp");
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
      out.write("        <title>JSP Page</title>       <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<center>\n");
      out.write("<div class=container>\n");
      out.write("    \n");
      out.write("<!-- head -->\n");
      out.write("<div class=head><div style=\"padding-top: 50px\"><div style=\"background-image: url(images/logo.png); background-repeat: no-repeat; height: 80px;\"> <div style=\"position: relative; left: 100px; top: -20px; text-align: left;\">\n");
      out.write("    <table width=80%>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td style=\"text-align: left; font: 25px arial; color: #000000;\"> eSocial...</td>\n");
      out.write("\t\t<td align=right>\n");
      out.write("\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<tr>\n");
      out.write("                            <td>\n");
      out.write("                                ");

                                    String huname = session.getAttribute("name").toString();
                                    String fileName = new ProPicAction().getPicName(huname);
                                    if(fileName!=null)
                                    {
                                        int index = fileName.lastIndexOf('.');
                                        String extensionName = fileName.substring(index,fileName.length());
                                        out.println("<img src=\"/esocial/upload/" + huname + extensionName + "\" width=\"50px\" height=\"50px\"/>");
                                    }
                                    else
                                    {

                                        out.println("<img src=\"ProfilePic/Female.gif\" width=\"50px\" height=\"50px\"/>");
                                    }


                                
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td align=\"right\"<big><a href=\"/esocial/SignOut.Do\"><h3>Sign Out</h3></a></big>\n");
      out.write("                                </td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t</table>\n");
      out.write("                \n");
      out.write("            </div></div></div></div>\n");
      out.write("<div class=nav>\n");
      out.write("    <a class=nav_text href=\"/esocial/User/Home.jsp\">Home</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/FetchInfo.Do\">Personal Info</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/User/Search.jsp\">Search</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/User/ProPic.jsp\">ProfilePic</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/FrnList.Do\">New Friend Requests</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/User/Album.jsp\">Upload Album</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/Friends.Do\">Friends</a>\n");
      out.write("</div></div>\n");
      out.write("    </center>\n");
      out.write("<!--\n");
      out.write("COPYRIGHT\n");
      out.write("Do not change or remove the reference to DatingSiteBuilder if you use the free version\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<bR>\n");
      out.write("          <br><center>\n");
      out.write("              <h3>Create a new Album</h3>\n");
      out.write("        <form action=\"/esocial/Album1.Do\"  method=\"post\">\n");
      out.write("            Name of the album <input type=\"text\" name=\"aname\"><br>\n");
      out.write("            Description of the album <textarea cols=\"10\" rows=\"5\" name=\"Desc\"></textarea>\n");
      out.write("            <input type=\"submit\" value=\"Create Album\">\n");
      out.write("        </form><br><BR></center>\n");
      out.write("\n");
      out.write("          ");
      out.write("<div class=foot>Copyright &copy; 2012. All Rights Reserved. <a href=\"http://www.eshitathedesire.blogspot.com\">eSocial..by Eshita Gupta</a></div>");
      out.write("\n");
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
