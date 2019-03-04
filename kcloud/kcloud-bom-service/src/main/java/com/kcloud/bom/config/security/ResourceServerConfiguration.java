package com.kcloud.bom.config.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
/*
    @Value(value = "${oauth2.resource.id}")
   private String oauth2ResourceId;

    @Autowired
    private TokenStore tokenStore;
*/
   /*
     * 资源服务器认证的配置：
     * 1、设置资源服务器的标识，从配置文件中读取自定义资源名称
     * 2、设置Access Token的数据源(默认内存中)，本项目使用 redis，所以需要配置
     * @param resources
     */
 /*   @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(oauth2ResourceId).tokenStore(tokenStore);
    }*/
	
/*	@Autowired
    private DataSource dataSource;
	
	@Bean // 声明TokenStore实现
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }*/
	
	   @Autowired
	    private OAuth2ClientProperties oAuth2ClientProperties;

	   @Resource(name = "authServerProp")
	    private AuthorizationServerProperties authorizationServerProperties;

	    @Bean(name = "authServerProp")
	    public AuthorizationServerProperties authorizationServerProperties(){
	        return new AuthorizationServerProperties();
	    }
	 
	    //验证Token时，需要oauth_client_details，数据库拆分后，业务服务不会有oauth_client_details，
	    //而资源服务器需要验证token，如果认证服务和资源服务分离，就只能远程调用调用认证服务来验证token
	    @Primary
	    @Bean
	    public RemoteTokenServices tokenServices() {
	        final RemoteTokenServices tokenService = new RemoteTokenServices();
	        tokenService.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
	        tokenService.setClientId(oAuth2ClientProperties.getClientId());
	        tokenService.setClientSecret(oAuth2ClientProperties.getClientSecret());
	        return tokenService;
	    } 


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
               /* .and().requestMatchers().anyRequest()
                .and()
                //配置访问权限控制，/anonymous/** 路径,必须可以匿名访问
                .anonymous()*/
               /* .and()
                .requestMatchers().anyRequest()*/
                .and()
                .authorizeRequests()  
                .antMatchers("/goods/test").permitAll() 
                .antMatchers(
                        "/webjars/**",
                        "/resources/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/v2/api-docs").permitAll()
                .anyRequest()
                .authenticated();
           /*     .antMatchers("/g1").authenticated()
                .antMatchers("/goods").authenticated()
                .anyRequest().permitAll();*/
                //配置访问权限控制，/api/** 路径,必须认证过后才可以访问
                ;

    }
}