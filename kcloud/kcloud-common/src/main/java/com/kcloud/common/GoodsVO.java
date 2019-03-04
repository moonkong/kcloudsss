package com.kcloud.common;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data; 

 
 @Data
public class GoodsVO  implements Serializable {

		private static final long serialVersionUID = 2L;
		
	  private Long id;

	    private String name;
	    
	    private String userid; 
	 

   
}
