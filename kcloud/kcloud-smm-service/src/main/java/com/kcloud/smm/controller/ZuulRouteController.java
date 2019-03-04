package com.kcloud.smm.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kcloud.common.ZuulRouteVO;
import com.kcloud.smm.model.entity.ZuulRoute;
import com.kcloud.smm.service.ZuulRouteService;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 动态路由配置表 前端控制器
 * </p>
 *
 * @author Walle
 * @since 2019-01-24
 */
@RestController
@RequestMapping("routes")
public class ZuulRouteController {

    @Value("${server.port}")
    private String fromValue;
    
    //读取redis里的路由
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
	ZuulRouteService zuulRouteService;
	 
	  @GetMapping("/from")
	    @ResponseBody
	    public String returnFormValue(){
	        return fromValue;
	    }
	  
	@ApiOperation(value = "获取全部路由", notes = "xxx")
	@GetMapping
    public List<ZuulRoute> getUser() { 
		EntityWrapper<ZuulRoute> rol=new EntityWrapper<>();
		rol.eq("is_deleted", "0");
         return zuulRouteService.selectList(rol);
    }  
	
	@ApiOperation(value = "刷新全部路由", notes = "xxx") 
    @GetMapping("/cache")
    public Object putUser() throws IllegalAccessException, InvocationTargetException { 
		List<ZuulRoute>  routeList=zuulRouteService.selectList(new EntityWrapper<>());
		List<ZuulRouteVO> list = new ArrayList<ZuulRouteVO>() ;
		for(ZuulRoute route :routeList){
			ZuulRouteVO vo = new ZuulRouteVO();
			BeanUtils.copyProperties(vo,route);
			list.add(vo);
		}
		redisTemplate.opsForValue().set("routes", list);
		Object obj =redisTemplate.opsForValue().get("routes");
		List<ZuulRouteVO> list2 = (List<ZuulRouteVO>) redisTemplate.opsForValue().get("routes");
         return list2;
    }  
}

