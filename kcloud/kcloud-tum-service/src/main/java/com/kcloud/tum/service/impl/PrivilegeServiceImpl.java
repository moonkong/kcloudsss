package com.kcloud.tum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kcloud.common.Query;
import com.kcloud.tum.mapper.PrivilegeMapper;
import com.kcloud.tum.model.entity.Privilege;
import com.kcloud.tum.service.PrivilegeService;

/**
 * <p>
 * 管理员权限表 服务实现类
 * </p>
 *
 * @author Walle
 * @since 2019-01-22
 */
@Service
public class PrivilegeServiceImpl  extends ServiceImpl<PrivilegeMapper, Privilege> implements PrivilegeService {

	@Autowired
    PrivilegeMapper privilegeMapper;

    public List<String>  findPrivilegesByUserid(Long usereid) {
    	return privilegeMapper.findPrivilegesByUserid(usereid);
    }

	public Page selectPrivilegesWithPage(Query<Object> objectQuery) {
		objectQuery.setRecords(privilegeMapper.findPrivilegesPage(objectQuery, objectQuery.getCondition()));
		return objectQuery;
	}
 
}
