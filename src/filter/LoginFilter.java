package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "*.jsp" })
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getSession().getAttribute("userInfo")!=null)
			chain.doFilter(request, response);
		else
			response.sendRedirect(request.getContextPath()+"/login.html");
		
	}


}
