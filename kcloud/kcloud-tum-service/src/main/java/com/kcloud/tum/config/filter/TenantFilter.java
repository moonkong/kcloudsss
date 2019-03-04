package com.kcloud.tum.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

import com.kcloud.tum.config.RequestHolder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@WebFilter(filterName = "TenantFilter", urlPatterns = "/*") 
public class TenantFilter implements Filter {

	@Autowired
    private RedisTemplate redisTemplate;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init"); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
		log.info("doFilter");  
		request.getAttributeNames();
		String token=  (String) request.getAttribute("OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE");
	/*	redisTemplate.opsForValue().set("tid:"+token, "1");*/
		String tenid=(String) redisTemplate.opsForValue().get("tid:"+token);
		RequestHolder.setId(Long.parseLong(tenid));
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("destroy"); 
		
	}

}
