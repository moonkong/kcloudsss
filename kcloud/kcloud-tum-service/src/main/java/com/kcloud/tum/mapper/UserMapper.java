package com.kcloud.tum.mapper;

import com.kcloud.tum.model.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Walle
 * @since 2019-01-23
 */
public interface UserMapper extends BaseMapper<User> {

	User  findUserByUsername(String username);
}
