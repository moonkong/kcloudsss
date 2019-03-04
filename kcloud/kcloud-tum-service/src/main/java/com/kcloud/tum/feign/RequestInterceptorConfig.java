package com.kcloud.tum.feign;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration 
public class RequestInterceptorConfig implements RequestInterceptor { 
private final Logger logger = LoggerFactory.getLogger(getClass());

private static final String AUTHORIZATION_HEADER = "Authorization";

private static final String BEARER_TOKEN_TYPE = "Bearer";

public void apply(RequestTemplate requestTemplate) {
 /*   String accessToken = WebContextUtil.getAccessToken();*/
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    Enumeration<String> headerNames = request.getHeaderNames();
    if (headerNames != null) {
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String values = request.getHeader(name);
            logger.debug("RequestInterceptorConfig name :" +name+"val:"+values);
            requestTemplate.header(name, values);
        }
    } 
}

}