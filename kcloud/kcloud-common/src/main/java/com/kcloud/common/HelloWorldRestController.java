package com.kcloud.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldRestController {
    
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	 
      
    //-------------------Retrieve All Users--------------------------------------------------------
 
    
    @RequestMapping(value = "/wcl", method = RequestMethod.GET)
    @ResponseBody
    public String wcl() { 
    	redisTemplate.opsForValue().set("user:111", "xxxxx");
        return redisTemplate.opsForValue().get("user:111").toString(); 

    }
      
  
}