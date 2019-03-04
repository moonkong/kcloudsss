package com.kcloud.tum.service;

import com.baomidou.mybatisplus.service.IService;
import com.kcloud.tum.model.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Walle
 * @since 2019-01-22
 */
public interface UserService extends IService<User> {

	User  findUserByUsername(String username);
}
