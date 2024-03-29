package com.kcloud.bom.config;
 
import java.util.ArrayList;
import java.util.List; 
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
 
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
 

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
 
	public static void main(String[] args) {
	    AutoGenerator mpg = new AutoGenerator();
	
	
	    // 全局配置
	    GlobalConfig gc = new GlobalConfig();
	    gc.setOutputDir("C://code");
	    gc.setFileOverride(true);
	    gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
	    gc.setEnableCache(false);// XML 二级缓存
	    gc.setBaseResultMap(true);// XML ResultMap
	    gc.setBaseColumnList(false);// XML columList
	    gc.setAuthor("Walle");// 作者
	
	
	    // 自定义文件命名，注意 %s 会自动填充表实体属性！
	    gc.setControllerName("%sController");
	    gc.setServiceName("%sService");
	    gc.setServiceImplName("%sServiceImpl");
	    gc.setMapperName("%sMapper");
	    gc.setXmlName("%sMapper");
	    mpg.setGlobalConfig(gc);
	
	
	    // 数据源配置
	    DataSourceConfig dsc = new DataSourceConfig();
	   /* dsc.setDbType(DbType.MYSQL);*/
	    dsc.setDriverName("com.mysql.jdbc.Driver");
	    dsc.setUsername("root");
	    dsc.setPassword("123456");
	    dsc.setUrl("jdbc:mysql://127.0.0.1:3306/kcloud-bom");
	    mpg.setDataSource(dsc);
	
	
	    // 策略配置
	    StrategyConfig strategy = new StrategyConfig();
	    strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
	    strategy.setExclude(new String[]{"oauth_client_details"}); 
	    strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
	  /*  strategy.setInclude(new String[] { "itcast_user" }); // 需要生成的表
*/	
	
	    strategy.setSuperServiceClass(null);
	    strategy.setSuperServiceImplClass(null);
	    strategy.setSuperMapperClass(null);
	
	
	    mpg.setStrategy(strategy);
	
	
	    // 包配置
	    PackageConfig pc = new PackageConfig();
	    pc.setParent("com.kcloud.bom");
	    pc.setController("controller");
	    pc.setService("service");
	    pc.setServiceImpl("service.impl");
	    pc.setMapper("mapper");
	    pc.setEntity("model.entity");
	    pc.setXml("xml");
	    mpg.setPackageInfo(pc);
	
	
	    // 执行生成
	    mpg.execute();
	    }
}