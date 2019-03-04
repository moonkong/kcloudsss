package com.kcloud.tum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kcloud.tum.mapper.UserMapper;
import com.kcloud.tum.model.entity.User;
import com.kcloud.tum.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Walle
 * @since 2019-01-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper; 
 
    public User  findUserByUsername(String username) {
    	return userMapper.findUserByUsername(username);
    }
}
