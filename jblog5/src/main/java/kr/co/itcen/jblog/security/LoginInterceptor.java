package kr.co.itcen.jblog.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.itcen.jblog.service.UserService;
import kr.co.itcen.jblog.vo.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
	   
	 
	   
	   String name = HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE;
	   Map pathVariables = (Map)request.getAttribute(name);
	
	   System.out.println("path Test :" + pathVariables.toString() ) ;	   
	   
      String id=request.getParameter("id");
      String password=request.getParameter("password");
      
      UserVo vo =new UserVo();
      
      vo.setId(id);
      vo.setPassword(password);
      
  

      //어플리케이션 어디서든지 Spring Container(ApplicationContext)를 가져오는 방법
      ApplicationContext appCtxt=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
      UserService userService=appCtxt.getBean(UserService.class);
      
      UserVo authUser=userService.getUser(vo);
      
      if(authUser == null) {
         response.sendRedirect(request.getContextPath()+"/user/login?result=fail");
         return false;
      }
      
      //session처리를 해주면 된다.
      HttpSession session=request.getSession(true);
      session.setAttribute("authUser", authUser);
      System.out.println(authUser);
      
      response.sendRedirect(request.getContextPath());
      return false;
   }
   
   
   public String test(@PathVariable String id) {
	   
	   return id;
   }
   
   

}