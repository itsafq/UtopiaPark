package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import utopia.controller.bookingFormServlet;
import utopia.bean.BookingBean;

public final class bookingForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.release();
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
      if (_jspx_meth_sql_setDataSource_0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');

    String type_list = "Child, Student, Adult, Senior Citizen";
    String[] type = null;
    type = type_list.split(",");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Utopia : Booking Form</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body> \n");
      out.write("        ");
      utopia.bean.BookingBean BookingBean = null;
      synchronized (_jspx_page_context) {
        BookingBean = (utopia.bean.BookingBean) _jspx_page_context.getAttribute("BookingBean", PageContext.PAGE_SCOPE);
        if (BookingBean == null){
          BookingBean = new utopia.bean.BookingBean();
          _jspx_page_context.setAttribute("BookingBean", BookingBean, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "name", request.getParameter("name"), request, "name", false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "email", request.getParameter("email"), request, "email", false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "phone_no", request.getParameter("phone_no"), request, "phone_no", false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "cust_ic", request.getParameter("cust_ic"), request, "cust_ic", false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "num_ticket", request.getParameter("num_ticket"), request, "num_ticket", false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("BookingBean"), "type", request.getParameter("type"), request, "type", false);
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        <h1 align=\"center\">Buy Tickets</h1>\n");
      out.write("        ");

            List errorMsgs = (List) request.getAttribute("errorMsgs");
            if(errorMsgs != null) {
        
      out.write("\n");
      out.write("        <p>\n");
      out.write("            <font color='red'>Please correct the following errors:\n");
      out.write("            <ul>\n");
      out.write("                ");

                    Iterator items = errorMsgs.iterator();
                    while(items.hasNext()) {
                        String message = (String) items.next();
                
      out.write("\n");
      out.write("                <li>");
      out.write("</li>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </p>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <form action=\"bookingFormServlet\" method=\"POST\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email</td>\n");
      out.write("                        <td><input type=\"text\" name=\"email\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Phone Number</td>\n");
      out.write("                        <td><input type=\"text\" name=\"phone_no\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Identification No.</td>\n");
      out.write("                        <td><input type=\"text\" name=\"cust_ic\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Num. of Tickets</td>\n");
      out.write("                        <td><input type=\"number\" name=\"num_ticket\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        String types = request.getParameter("type");
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Type</td>\n");
      out.write("                        <td><select name=\"type\" value=\"Select type\">\n");
      out.write("                                ");

                                    for(int i=0; i<type.length; i++)
                                    {
                                        String type_item = type[i];
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( type_item );
      out.write("\">\n");
      out.write("                                ");

                                    if(type_item.equals(type)) {
                                        out.print("Selected");
                                    }
                                
      out.write("\n");
      out.write("                                ");
      out.print( type_item );
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"hidden\" name=\"typeform\" value=\"booking\"/></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Book\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("                            \n");
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

  private boolean _jspx_meth_sql_setDataSource_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent(null);
    _jspx_th_sql_setDataSource_0.setVar("myDatasource");
    _jspx_th_sql_setDataSource_0.setDriver("org.apache.derby.jdbc.ClientDriver");
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:derby://localhost:1527/utopia");
    _jspx_th_sql_setDataSource_0.setUser("utopia");
    _jspx_th_sql_setDataSource_0.setPassword("123");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
      return true;
    }
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }
}
