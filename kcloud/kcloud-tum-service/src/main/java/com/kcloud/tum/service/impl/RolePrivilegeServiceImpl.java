package com.kcloud.tum.service.impl;

import com.kcloud.tum.model.entity.RolePrivilege;
import com.kcloud.tum.mapper.RolePrivilegeMapper;
import com.kcloud.tum.service.RolePrivilegeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和权限的关联表 服务实现类
 * </p>
 *
 * @author Walle
 * @since 2019-01-23
 */
@Service
public class RolePrivilegeServiceImpl extends ServiceImpl<RolePrivilegeMapper, RolePrivilege> implements RolePrivilegeService {

}
