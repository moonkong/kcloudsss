package com.kcloud.auth.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kcloud.common.UserVO;
 
@FeignClient(value = "kcloud-tum-service",fallback = FeignUserServiceImpl.class)
public interface FeignUserService {
	 

  /*  @GetMapping("/auths") */
    @RequestMapping(value = "/users/credits/{username}", method = RequestMethod.GET)
    UserVO getUser(@PathVariable("username") String username);
 
}
