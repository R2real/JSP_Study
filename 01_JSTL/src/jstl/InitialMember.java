package jstl;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 리스너
// == 외부에서 동작을 감지하여(모니터링) 특정 메서드를 수행하는 대상
@WebListener
//== 어노테이션 == 애너테이션
public class InitialMember implements ServletContextListener{
// 인터페이스가 갖는 "강제성"
   @Override
   public void contextDestroyed(ServletContextEvent sce) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void contextInitialized(ServletContextEvent sce) {
	   //서버가 시작할때 단 한번 돌아감
      ArrayList<Member> datas=new ArrayList<Member>();
      for(int i=0;i<8;i++) {
         Member data=new Member("티모"+(i+1),"010-1234-123"+i);
         datas.add(data);
      }
      datas.add(new Member("아리",null));
      datas.add(new Member("가렌",null));
      
      ServletContext context=sce.getServletContext();
      // context는 서버 scope(application scope)
      context.setAttribute("datas",datas);
      context.setAttribute("data",new Member());
   
   }
   
}
