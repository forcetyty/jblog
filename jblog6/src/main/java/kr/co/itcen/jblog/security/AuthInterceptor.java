package kr.co.itcen.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.itcen.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);

		// 1. handler 종류 (DefaultServletHttpRequestHandler, HandlerMethod)
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		// 4. @Auth가 없으면 class type에 없을 수 있으므로...
		if (auth == null) {
			// 과제 : class type에서 @Auth가 있는 지를 확인해 봐야한다.
			auth = handlerMethod.getBeanType().getAnnotation(Auth.class);
			if (auth == null) {
				// 과제 : class type에서 @Auth가 있는지를 확인해 봐야 한다.
				return true;
			}
		}

		// 6.@Auth가 class나 method에 붙어 있기 때문에 인증 여부를 체크한다.
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (session == null || authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		// 7. Role 가져오기
		String role = auth.value();

		// 9. 메소드의 @Auth의 Role이 "USER"인 경우.
		// 인증만 되어 있으면 모두 통과
		// role == "USER"
		if ("USER".equals(role)) {
			return true;
			
		}

		// 10. 메소드의 @Auth의 Role이 "ADMIN"인 경우.
		// -- 과제
		// 9.메소드의 @Auth의 Role이 "ADMIN"인 경우//과제
//		if ("ADMIN".equals(role)) {
//			//사용자의 ADMIN 인증 정보를 가지고 관리자인지 아닌지 판단
//			if (!"ADMIN".equals(authUser.getRole())) {
//				response.sendRedirect(request.getContextPath() + "/");
//				return false;
//			}
//			return true;
//		}
		return true;
	}

}
