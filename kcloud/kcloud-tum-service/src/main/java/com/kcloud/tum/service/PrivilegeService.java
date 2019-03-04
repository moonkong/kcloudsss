package com.kcloud.tum.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.kcloud.common.Query;
import com.kcloud.tum.model.entity.Privilege;

/**
 * <p>
 * 管理员权限表 服务类
 * </p>
 *
 * @author Walle
 * @since 2019-01-22
 */
public interface PrivilegeService  extends IService<Privilege>{

	List<String>  findPrivilegesByUserid(Long usereid);
 
   Page  selectPrivilegesWithPage(Query<Object> objectQuery);
}
