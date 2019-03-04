package com.kcloud.tum.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kcloud.common.GoodsVO;
 
 
@FeignClient(value = "kcloud-bom-service",configuration=RequestInterceptorConfig.class,fallback = FeignGoodsServiceImpl.class)
public interface FeignGoodsService {
	 
 
    @RequestMapping(value = "/goods/{goodsId}", method = RequestMethod.GET)
    GoodsVO getGoods(@PathVariable("goodsId") Long goodsId);
 
}
