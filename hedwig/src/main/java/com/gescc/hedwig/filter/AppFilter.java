package com.gescc.hedwig.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gescc.hedwig.mapper.AppFileMapper;


/**
 * @author heedong111
 *
 */
public class AppFilter implements Filter {

	private Logger LOG = LoggerFactory.getLogger(AppFilter.class);
	@Autowired
	private AppFileMapper appFileMapper = new AppFileMapper();


	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getRequestURI();
		LOG.info(path);
		if (path.startsWith("/view")) {
			chain.doFilter(request, response); // Just continue chain.
		} 
		else if(path.startsWith("/WEB-INF/jsp")) {
			chain.doFilter(request, response);
		}
		else if(path.startsWith("/applications")) {
			chain.doFilter(request, response);
		}
		else if(path.startsWith("/users")) {
			chain.doFilter(request, response);
		}
		else if(path.startsWith("/favicon.ico")){
			chain.doFilter(request, response);
		}
		else{
			try{
				LOG.info(req.getRemoteAddr());
		        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		        response.setHeader("Access-Control-Max-Age", "3600");
		        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		        response.setHeader("Access-Control-Allow-Origin", "*");
				if(appFileMapper.hasApp(request.getRemoteAddr())){
					chain.doFilter(request, response);
				}
				else{
					throw new Exception("Register Application First");
				}
			}catch(Exception e){e.printStackTrace();}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}

