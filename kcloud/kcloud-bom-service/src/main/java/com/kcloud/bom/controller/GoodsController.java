package com.kcloud.bom.controller;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcloud.bom.model.entity.Goods;
import com.kcloud.bom.service.GoodsService;
import com.kcloud.common.GoodsVO;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Walle
 * @since 2019-01-25
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


	@Autowired
	GoodsService goodsService;
	 
	  
	@PreAuthorize("hasAuthority('sys.good.select')")
	@ApiOperation(value = "通过商品ID获取商品", notes = "xxx")
    @RequestMapping(value = "/{goodsId}", method = RequestMethod.GET)
    public Goods  getGoods(@PathVariable(value="goodsId") Long goodsId) {  
         return goodsService.selectById(goodsId);
    } 
	
	@PreAuthorize("hasAuthority('sys.good.select')")
	@ApiOperation(value = "通过商品ID获取商品", notes = "xxx")
    @RequestMapping(value = "/feign/{goodsId}", method = RequestMethod.GET)
    public GoodsVO  getFeignGoods(@PathVariable(value="goodsId") Long goodsId) throws IllegalAccessException, InvocationTargetException {  
		Goods gs  = goodsService.selectById(goodsId);
		GoodsVO vo =new GoodsVO();
		BeanUtils.copyProperties(vo, gs);
         return vo;
    } 
	
 
	@ApiOperation(value = "通过品", notes = "xxx")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String  getGoodssss() {  
         return "hello";
    } 
}

