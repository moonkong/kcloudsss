package com.kcloud.auth.service.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kcloud.auth.service.feign.FeignUserService;
import com.kcloud.common.UserVO; 
 
 
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private FeignUserService feignUserService;
 
    /**
     * 根据用户名获取登录用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserVO user = feignUserService.getUser(username);

        if(user == null){
             throw new UsernameNotFoundException("用户名："+ username + "不存在！");
        }
     /*   Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        Iterator<Role> iterator =  user.getList().iterator();*/
    /*    while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next().getRolename()));
        }*/ 
 
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if(user.getList()!=null){
    	    for (String role : user.getList()) {
    	        authorities.add(new SimpleGrantedAuthority(role));
    	    }  
        }

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
    }
}
