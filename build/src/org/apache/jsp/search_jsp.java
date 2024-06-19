package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import utopia.util.DBConnection;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String ic = request.getParameter("cust_ic");
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search Booking</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Search Booking</h1>\n");
      out.write("        <hr><br>\n");
      out.write("        \n");
      out.write("        <table cellpadding=\"5\" cellspacing=\"5\" border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Cust_ID</td>\n");
      out.write("                <td>Name</td>\n");
      out.write("                <td>Email</td>\n");
      out.write("                <td>Phone Num.</td>\n");
      out.write("                <td>Cust_IC</td>\n");
      out.write("                <td>Type</td>\n");
      out.write("                <td>Num. Of Tickets</td>\n");
      out.write("                <td></td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                try {
                    con = DBConnection.createConnection();
                    stmt = con.createStatement();
                    String sql = "SELECT * FROM UTOPIA.\"BOOKING\" WHERE \"CUST_IC\"= '" + ic + "'";
                    rs = stmt.executeQuery(sql);
                    
                    while (rs.next()) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString("CUST_ID"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("name"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("email"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("phone_no"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("cust_ic"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("type"));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("num_of_ticket"));
      out.write("</td>\n");
      out.write("                <td><a href=\"delete.jsp?ic=");
      out.print(rs.getString("cust_ic"));
      out.write("\"><button type=\"button\">Delete</button></a></td>\n");
      out.write("                <td><a href=\"updateForm.jsp?ic=");
      out.print(rs.getString("cust_ic"));
      out.write("\"><button type=\"button\">Update</button></a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                } 
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <br><a href=\"Search.html\">Search</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
