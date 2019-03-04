package com.kcloud.tum.model.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserPrivilege implements Serializable {

    private static final long serialVersionUID = 1L;
 
    private Long useId;
 
    private String name;
   
    private Integer currentPage;
    
    private Integer pageSize;
}
