package com.kcloud.common;
 
import java.util.Date; 
import java.io.Serializable;  
import lombok.Data;
import lombok.EqualsAndHashCode; 

/**
 * <p>
 * 动态路由配置表
 * </p>
 *
 * @author Walle
 * @since 2019-01-24
 */
@Data 
public class ZuulRouteVO implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Integer id;
    /**
     * 路由路径
     */
    private String path;
    /**
     * 服务名称
     */ 
    private String serviceId;
    /**
     * url代理
     */
    private String url;
    /**
     * 转发去掉前缀
     */ 
    private String stripPrefix;
    /**
     * 是否重试
     */
    private String retryable;
    /**
     * 是否启用
     */
    private String enabled;
    /**
     * 敏感请求头
     */ 
    private String sensitiveheadersList;  


}
