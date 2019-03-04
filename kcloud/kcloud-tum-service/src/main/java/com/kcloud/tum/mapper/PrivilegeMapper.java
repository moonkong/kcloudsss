package com.kcloud.tum.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kcloud.common.Query;
import com.kcloud.tum.model.entity.Privilege;

/**
 * <p>
 * 管理员权限表 Mapper 接口
 * </p>
 *
 * @author Walle
 * @since 2019-01-23
 */
public interface PrivilegeMapper extends BaseMapper<Privilege> {
	
	List<String>  findPrivilegesByUserid(Long usereid);

	List<Object>  findPrivilegesPage(Query<Object> query, Map<String, Object> condition);
}
