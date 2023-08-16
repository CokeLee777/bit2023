package web.dispatcher;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class BadRequestFilter implements Filter{
	private Logger work_log = 
	Logger.getLogger("work"); 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		String uri = ((HttpServletRequest)request).getRequestURI();
		work_log.debug("doFilter----"+uri);

		String path = uri.substring(uri.lastIndexOf("/"));
		work_log.debug("doFilter----"+path);
		if(path.equals("/")) {
			((HttpServletResponse)response).sendRedirect("main.bit");
			return;
		}
		
		
		
		
	

		// 2. ü���� ���� ���� ó��
		chain.doFilter(request, response);
		
		// 3. response �� �̿��� ��û ���͸� �۾� ����

		
	}
}
