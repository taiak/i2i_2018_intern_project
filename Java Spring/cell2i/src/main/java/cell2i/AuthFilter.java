package cell2i;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/pages/*")
public class AuthFilter implements Filter {

	private static final String loginPage = "/login.xhtml";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		Auth auth = (Auth) httpServletRequest.getSession().getAttribute("auth");

		if (auth == null || !auth.isAuthenticated()) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + loginPage);
			return;
		}

		chain.doFilter(request, response);

	}

}
