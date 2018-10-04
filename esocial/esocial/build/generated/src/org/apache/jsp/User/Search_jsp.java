package org.apache.jsp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.common.LoginTableData;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      out.write("<center>\n");
      out.write("<div class=container>\n");
      out.write("    \n");
      out.write("<!-- head -->\n");
      out.write("<div class=head><div style=\"padding-top: 50px\"><div style=\"background-image: url(images/logo.png); background-repeat: no-repeat; height: 80px;\"> <div style=\"position: relative; left: 100px; top: -20px; text-align: left;\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("</div></div></div></div>\n");
      out.write("\n");
      out.write("<!-- navigation menu -->\n");
      out.write("<div class=nav>\n");
      out.write("\t<a class=nav_text href=\"\">Home</a>\n");
      out.write("\t<a class=nav_text href=\"/esocial/FetchInfo.Do\">Personal Info</a>\n");
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
      out.write("<center>\n");
      out.write("        <form method=\"post\" action=\"/esocial/Search.Do\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr><tr></tr>\n");
      out.write("                <tr><td>\n");
      out.write("                        Enter UserName or Email ID  <input type=\"text\" name=\"searchName\"></td></tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Search\">\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr><tr><td></td></tr><tr><td></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form></center>\n");
      out.write("         ");

         HttpSession sess=request.getSession();
         if(sess.getAttribute("search")!=null)
             {
                List<LoginTableData> data=(List<LoginTableData>)session.getAttribute("search");
                if(data!=null)
                {
                    for(LoginTableData ltd:data)
                    {
                        out.println("<h1><a href=\"/esocial/ViewProfile.Do?uname=" + ltd.getUserName() + "\">"
                                + ltd.getUserName() + "</a></h1>");
                    }
                }
             }
         
      out.write("\n");
      out.write("         ");
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
