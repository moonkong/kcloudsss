package com.kcloud.auth.service.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kcloud.common.UserVO;
 

@Service
public class FeignUserServiceImpl implements FeignUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

	public UserVO getUser(String name) {
		logger.error("调用{}异常:{}", "getUser",name);
		return null;
	}
 
     
}
