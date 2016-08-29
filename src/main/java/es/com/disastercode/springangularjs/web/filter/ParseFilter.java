package es.com.disastercode.springangularjs.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ParseFilter implements Filter{


	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
	    	
	        HttpServletRequest request = (HttpServletRequest) req;
	        String requestURI = request.getRequestURI();
	        //StringBuffer requestURL = request.getRequestURL();
	        
	        if(request.getServerName().indexOf("localhost")!=-1 && 
	        		requestURI.indexOf("/springangularjs")!=-1 ){
	        	String newURI = requestURI.replace("/springangularjs", "");
	        	req.getRequestDispatcher(newURI).forward(req, res);
	        } else {
	            chain.doFilter(req, res);
	        }
	    }

		@Override
		public void destroy() {
			
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}

	    
	    
}
