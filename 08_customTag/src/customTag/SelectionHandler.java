package customTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectionHandler extends SimpleTagSupport {
   private String border;
   private String bgcolor;
   
   
   public String getBorder() {
      return border;
   }



   public void setBorder(String border) {
      this.border = border;
   }



   public String getBgcolor() {
      return bgcolor;
   }



   public void setBgcolor(String bgcolor) {
      this.bgcolor = bgcolor;
   }



   public void doTag() throws IOException, JspException {
      Selection s=new Selection();

      JspFragment body=getJspBody();
      
      JspWriter out=getJspContext().getOut();
      
      out.println("<h1>");
      body.invoke(null);
      out.println("</h1>");
      
      out.println("<table border="+border+" bgcolor="+bgcolor+">");
      for(String v:s.getNameList()) {
         out.println("<tr><td>"+v+"</tr></td>");
      }
      out.println("</table>");
   }
}