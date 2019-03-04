package com.kcloud.tum.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.kcloud.common.Query;
import com.kcloud.tum.model.entity.Privilege;
import com.kcloud.tum.service.PrivilegeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 
@RestController
@RequestMapping("privileges")
@Api(value = "权限")
public class PrivilegeController {
 
	@Autowired
	PrivilegeService privilegeService;
    
	@ApiOperation(value = "通过权限ID获取权限信息", notes = "xxx")
	@GetMapping("{privilegeId}")
    public Privilege  getUser(@PathVariable(value="privilegeId") Long privilegeId) { 
         return privilegeService.selectById(privilegeId);
    }
	 
	@ApiOperation(value = "获取权限列表", notes = "xxx")
	@RequestMapping("rolePage")
    public Page getRoles(@RequestParam Map<String, Object> params) {   
	        return privilegeService.selectPrivilegesWithPage(new Query<>(params));
    }
	
}