package no.uis.canvas.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import no.uis.portal.feidelogin.web.Constants;

public class CanvasFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String userId = request.getParameter("user_id");
		if (userId != null) {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpReq = (HttpServletRequest) request;
				httpReq.getSession(true).setAttribute(Constants.FEIDE_USER_ID_ATTRIBUTE, userId);
			}
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}
