package com.kcloud.tum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcloud.common.GoodsVO;
import com.kcloud.common.UserVO;
import com.kcloud.tum.feign.FeignGoodsService;
import com.kcloud.tum.model.entity.User;
import com.kcloud.tum.service.PrivilegeService;
import com.kcloud.tum.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

  
@RestController
@RequestMapping("/users") 
@Api(value = "用户")
public class UserController {
 
	@Autowired
	UserService userService;
	
	@Autowired
	PrivilegeService privilegeService;
	
	@Autowired
	FeignGoodsService feignGoodsService;
	
	@PreAuthorize("hasAuthority('sys.user.select')")
	@ApiOperation(value = "通过ID获取用户信息", notes = "xxx")
    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long userid) { 
         return new User();
    }  
    
	@ApiOperation(value = "通过名称获取用户密码", notes = "xxx")
    @RequestMapping(value = "credits/{username}", method = RequestMethod.GET)
    public UserVO getUser3(@PathVariable String username) { 
		UserVO vo = new UserVO();
		// 根据名称查用户
		User user = userService.findUserByUsername(username);
		List<String> rolelist= new ArrayList<String>();
		if(user!=null){
			// 根据用户查权限
			rolelist=privilegeService.findPrivilegesByUserid(user.getId());
			BeanUtils.copyProperties(user, vo);
		}
		vo.setList(rolelist);
         return vo;
    }

	@PreAuthorize("hasAuthority('sys.user.select')")
	@ApiOperation(value = "通过用户ID获取关联用户的商品信息", notes = "xxx")
    @RequestMapping(value = "/goods/{goodsId}", method = RequestMethod.GET)
    public GoodsVO getUserIn(@PathVariable Long goodsId) {  
         return feignGoodsService.getGoods(goodsId);
    }
 
}
