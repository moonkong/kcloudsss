package com.kcloud.tum.feign;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kcloud.common.GoodsVO;
 

@Service
public class FeignGoodsServiceImpl implements FeignGoodsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

	public GoodsVO getGoods(Long userid) {
		logger.error("调用{}异常:{}", "getUser",userid);
		return null;
	}

 
     
}
