package jp.co.keit.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import jp.co.keit.entity.User;

@Component
public class LoginCheckFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String requestURL = httpRequest.getRequestURI();
		
		if(isStatic(requestURL)) {
			chain.doFilter(request, response);
			return;
		}
		
		if (isValid(requestURL)) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = httpRequest.getSession();
			
			User user = (User)session.getAttribute("user");
			
			if (user == null) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				
				httpResponse.sendRedirect("/keit/login");
			} else {
				chain.doFilter(request, response);
			}
		}	
	}
	
	private boolean isValid(String uri) {
		return uri.endsWith("/login")
				|| uri.endsWith("/")
				|| uri.contains("/user")
				|| uri.endsWith("/profile")
				|| uri.endsWith("/contact");
	}
	
	private boolean isStatic(String uri) {
		return uri.contains("/js/")
				|| uri.contains("/css/")
				|| uri.contains("/fonts/")
				|| uri.contains("/img/")
				|| uri.contains("/pdf/");
	}
}
