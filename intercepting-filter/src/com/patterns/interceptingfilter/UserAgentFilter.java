package com.patterns.interceptingfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//to create filter: pkg->new->filter->add mapping

@WebFilter("/*")
public class UserAgentFilter implements Filter {

   
    public UserAgentFilter() {
    }


	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userAgentHeader = ((HttpServletRequest)request).getHeader("User-Agent");
		System.out.println("userAgentHeader=="+userAgentHeader);
		if(userAgentHeader.contains("Chrome"))
			chain.doFilter(request, response);//goes to next filter or target (/homeServlet)
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("badBrowser.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
