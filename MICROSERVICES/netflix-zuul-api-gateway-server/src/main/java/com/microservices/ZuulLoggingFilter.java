package com.microservices;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public boolean shouldFilter() {
		return true; //should execute this filter for every request
	}

	//logic for logging comming request
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest(); //give current request
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;	
	}

	//it can return "pre" means  execute filter before request /"post" means after request/"error" means when error occurs
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1; //filter priority for the current order
	}

}
