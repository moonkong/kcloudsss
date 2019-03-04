package com.kcloud.bom.service.impl;

import com.kcloud.bom.model.entity.Order;
import com.kcloud.bom.mapper.OrderMapper;
import com.kcloud.bom.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Walle
 * @since 2019-01-25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
