package com.kcloud.common;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data; 

 
 @Data
public class UserVO  implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private int id;
    private String username;
    private String password;
    private List<String> list = new ArrayList<String>();

   
}
