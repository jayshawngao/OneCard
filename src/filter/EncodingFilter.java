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
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })
public class EncodingFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("filter working...");
		String encoding=getFilterConfig().getServletContext().getInitParameter("encoding");
//		System.out.println(encoding);
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}
}
