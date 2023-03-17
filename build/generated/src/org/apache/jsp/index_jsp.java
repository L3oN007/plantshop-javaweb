package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.AccountDAO;
import dto.Account;
import dao.PlantDAO;
import dto.Plant;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_import_url_nobody.release();
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

      out.write(" \n");
      out.write("\n");
      out.write("    \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html lang=\"en\">\n");
      out.write("        <head>\n");
      out.write("            <meta charset=\"UTF-8\" />\n");
      out.write("            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("            <title>Tech2etc Ecommerce Tutorial</title>\n");
      out.write("            <link\n");
      out.write("                rel=\"stylesheet\"\n");
      out.write("                href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\"\n");
      out.write("                integrity=\"sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==\"\n");
      out.write("                crossorigin=\"anonymous\"\n");
      out.write("                />\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\" />\n");
      out.write("            <link rel=\"stylesheet\" href=\"style.css\" />\n");
      out.write("            <link rel=\"stylesheet\" href=\"toast.css\" />\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("            ");

// get the token from the cookie
                Cookie[] cookies = request.getCookies();
                String token = null;
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("token")) {
                            token = cookie.getValue();
                            break;
                        }
                    }
                }

// check if the token matches the token in the database
                if (token != null) {
                    Account account = AccountDAO.getAccountByToken(token);
                    if (account != null) {
                        // set the account in the session
                        session.setAttribute("account", account);
                    }
                }
            
      out.write("\n");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            <section id=\"hero\">\n");
      out.write("                <h4>Plant shop</h4>\n");
      out.write("                <h2>Supernorwe badgwg</h2>\n");
      out.write("                <h1>on all product</h1>\n");
      out.write("                <p>Save more with coupons & up to 70% off</p>\n");
      out.write("                <button>Shop Now</button>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <section id=\"feature\" class=\"section-p1\">\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f1.png\" alt=\"\" />\n");
      out.write("                    <h6>Free Shipping</h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f2.png\" alt=\"\" />\n");
      out.write("                    <h6>Online Order</h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f3.png\" alt=\"\" />\n");
      out.write("                    <h6>Save Money</h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f4.png\" alt=\"\" />\n");
      out.write("                    <h6>Promotions</h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f5.png\" alt=\"\" />\n");
      out.write("                    <h6>Happy Sell</h6>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"fe-box\">\n");
      out.write("                    <img src=\"img/features/f6.png\" alt=\"\" />\n");
      out.write("                    <h6>24/7 Support</h6>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <section id=\"product1\" class=\"section-p1\">\n");
      out.write("                <h2>Featured Products</h2>\n");
      out.write("                <p>Summer Collection New Morden Design</p>\n");
      out.write("                <div class=\"pro-container\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <section id=\"banner\" class=\"section-m1\">\n");
      out.write("                <h4>Repair Services</h4>\n");
      out.write("                <h2>Up to <span> 70% Off</span> All T-Shirt & Accessories</h2>\n");
      out.write("                <button class=\"normal\">Explore More</button>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <section id=\"product1\" class=\"section-p1\">\n");
      out.write("                <h2>New Arrivals</h2>\n");
      out.write("                <p>Summer Collection New Morden Design</p>\n");
      out.write("                <div class=\"pro-container\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_import_1(_jspx_page_context))
        return;
      out.write("                \n");
      out.write("            <div id=\"toast\"></div>\n");
      out.write("            <script>\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    var addSuccess = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.addSuccess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("                    if (addSuccess !== '') {\n");
      out.write("                        showToast();\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                function showToast() {\n");
      out.write("                    toast({\n");
      out.write("                        title: 'Succeeded',\n");
      out.write("                        message: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.addSuccess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\n");
      out.write("                        type: 'success',\n");
      out.write("                        duration: 5000,\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            </script>               \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("            <script src=\"script.js\"></script>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("header_user.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PlantDAO.getPlantByCate('Garden Flowers')}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("r");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"pro\" onclick=\"window.location.href = 'MainController?action=sproduct&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'\">\n");
          out.write("                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.imgpath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" />\n");
          out.write("                            <div class=\"des\">\n");
          out.write("                                <!-- catename -->\n");
          out.write("                                <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.catename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                <!-- name -->\n");
          out.write("                                <h5>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\n");
          out.write("                                <div class=\"star\">\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                </div>\n");
          out.write("                                <!-- price -->\n");
          out.write("                                <h4>$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                            </div>\n");
          out.write("                            <a href=\"MainController?action=addtocart&amp;id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"fal fa-cart-plus cart\"></i></a>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PlantDAO.getAllPlants()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("r");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"pro\" onclick=\"window.location.href = 'MainController?action=sproduct&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("'\">\n");
          out.write("                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.imgpath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" />\n");
          out.write("                            <div class=\"des\">\n");
          out.write("                                <!-- catename -->\n");
          out.write("                                <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.catename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                <!-- name -->\n");
          out.write("                                <h5>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\n");
          out.write("                                <div class=\"star\">\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                    <i class=\"fas fa-star\"></i>\n");
          out.write("                                </div>\n");
          out.write("                                <!-- price -->\n");
          out.write("                                <h4>$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4>\n");
          out.write("                            </div>\n");
          out.write("                            <a href=\"MainController?action=addtocart&amp;id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${r.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><i class=\"fal fa-cart-plus cart\"></i></a>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_1.setPageContext(_jspx_page_context);
    _jspx_th_c_import_1.setParent(null);
    _jspx_th_c_import_1.setUrl("footer.jsp");
    int[] _jspx_push_body_count_c_import_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_1 = _jspx_th_c_import_1.doStartTag();
      if (_jspx_th_c_import_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_1.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_1);
    }
    return false;
  }
}
