package com.kcloud.tum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcloud.tum.model.entity.Role;
import com.kcloud.tum.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 
@RestController
@RequestMapping("/roles")
@Api(value = "角色")
public class RoleController {
 
	@Autowired
	RoleService roleService;

	@ApiOperation(value = "通过角色ID获取角色信息", notes = "xxx")
    @RequestMapping(value = "{roleid}", method = RequestMethod.GET)
    public Role getRole(@PathVariable(value="roleid") Long roleid ) { 
         return roleService.selectById(roleid);
    }
	

	 
}
