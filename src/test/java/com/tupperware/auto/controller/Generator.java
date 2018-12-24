package com.tupperware.auto.controller;
import com.tupperware.auto.generator.AutoGenerator;
import com.tupperware.auto.generator.InjectionConfig;
import com.tupperware.auto.generator.config.*;
import com.tupperware.auto.generator.config.rules.DbType;
import com.tupperware.auto.generator.config.rules.NamingStrategy;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
public class Generator {

    private static final Log logger = LogFactory.getLog(Generator.class);
    private  AutoGenerator mpg;

    private Properties props;
    // 全局配置
    private GlobalConfig gc;
    // 数据源配置
    private DataSourceConfig dsc;
    private PackageConfig pc;
    // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
    private InjectionConfig cfg;
    private TemplateConfig tc;
    private StrategyConfig sc;
    private   String dbtype;

    public Generator() {
        props = getProperties();
        dbtype=props.getProperty("generator.dbtype");
    }

    public InjectionConfig getCfg() {
        return cfg;
    }

    public void setCfg(InjectionConfig cfg) {
        this.cfg = cfg;
    }

    public StrategyConfig getSc() {
        return sc;
    }

    public void setSc(StrategyConfig sc) {
        this.sc = sc;
    }

    @Before
    public void setProps() {
        props = getProperties();
        dbtype=props.getProperty("generator.dbtype");
        sc=this.getStrategyConfig();
        setGlobalConfig();
        setDataSourceConfig();
        setPackageConfig();
        setInjectionConfig();

        setTemplateConfig();
        setAutoGenerator();
    }

    public void setDataSourceConfig() {
        // 数据源配置
        dsc = new DataSourceConfig();
        if(dbtype.equals("MYSQL")){
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName(props.getProperty("spring.mysql.datasource.driverClassName"));
            dsc.setUsername(props.getProperty("spring.mysql.datasource.username"));
            dsc.setPassword(props.getProperty("spring.mysql.datasource.password"));
            dsc.setUrl(props.getProperty("spring.mysql.datasource.url"));
        }
      else  if(dbtype.equals("MSSQL")){
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName(props.getProperty("spring.mssql.datasource.driverClassName"));
            dsc.setUsername(props.getProperty("spring.mssql.datasource.username"));
            dsc.setPassword(props.getProperty("spring.mssql.datasource.password"));
            dsc.setUrl(props.getProperty("spring.mssql.datasource.url"));
        }
       else if(dbtype.equals("ORACLE")){
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName(props.getProperty("spring.oracle.datasource.driverClassName"));
            dsc.setUsername(props.getProperty("spring.oracle.datasource.username"));
            dsc.setPassword(props.getProperty("spring.oracle.datasource.password"));
            dsc.setUrl(props.getProperty("spring.oracle.datasource.url"));
        }else{
            System.out.println("error");
        }


    }

    public void setGlobalConfig() {
        // 全局配置
        gc = new GlobalConfig();

//        gc.setOutputDir("src/main/resources/code/###/src/main/".replaceAll("###",dbtype.toLowerCase()));

        gc.setOutputDir("src/main/".replaceAll("###",dbtype.toLowerCase()));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("patrick.wang");
//         自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setFormName("%sHelper");

        gc.setListName("%s");
        gc.setAddName("%sAdd");
        gc.setEditName("%sEdit");
    }

    private StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix("bmd_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setInclude(props.getProperty("generator.tables").split(",")); // 需要生成的表
       strategy.setExclude(String.valueOf("config_controller").split(",")); // 需要排除生成的表
//
    //    strategy.setInclude(String.valueOf("config_controller").split(",")); // 需要生成的表

//        strategy.setInclude(new String[]{"auth_role_operation"}); // 需要生成的表
        // strategy.setExclude(new String[]{"test"
        // 字段名生成策略
        strategy.setFieldNaming(NamingStrategy.underline_to_camel);
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        //strategy.setSuperControllerClass("com.tupperware.commons.base.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        return strategy;
    }

    public void setPackageConfig() {
        // 包配置
        pc = new PackageConfig();
        pc.setParent("com.tupperware.auto");
//        pc.setResource("resources".replaceAll("###",dbtype.toLowerCase()));
        pc.setModuleName(null); // 所属模块
        pc.setController("controller");
        pc.setForm("form");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper.###".replaceAll("###",dbtype.toLowerCase()));
        pc.setMapper("###.mapper".replaceAll("###",dbtype.toLowerCase()));
        pc.setEntity("###.model".replaceAll("###",dbtype.toLowerCase()));


    }

    public void setTemplateConfig() {

        tc = new TemplateConfig();
        tc.setController("/template/controller.java.vm");
        tc.setEntity("/template/entity.java.vm");
        tc.setMapper("/template/mapper.java.vm");
        tc.setXml("/template/mapper.xml.mysql.vm");
        tc.setService("/template/service.java.vm");
        tc.setServiceImpl("/template/serviceImpl.java.vm");
        tc.setForm("/template/form.java.vm");

    }

    public void setInjectionConfig() {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dbtype", dsc.getDbType().toString().toLowerCase());
                this.setMap(map);
            }

            public void initMap(String table) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dbtype", dsc.getDbType().toString().toLowerCase());
                this.setMap(map);
            }
        };
    }

    public AutoGenerator setAutoGenerator(){

        mpg = new AutoGenerator();

        mpg.setGlobalConfig(gc);
        // 数据源配置
        mpg.setDataSource(dsc);
        // 策略配置
        mpg.setStrategy(sc);
        // 包配置
        mpg.setPackageInfo(pc);

        mpg.setCfg(cfg);

        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();

        return mpg;
    }
    @Test
    public void execute() {
        // 执行生成
//        mpg.execute();
        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("dbtype"));
    }
    @Test
    public void clear() {
        // 执行生成
        mpg.clear();
        // 打印注入设置
        logger.debug("==========================打印注入设置！！！==========================");
        logger.debug(mpg.getCfg().getMap().get("dbtype").toString());
        logger.debug("==========================打印注入设置！！！==========================");
    }

    public static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/application.properties");
        Properties _props = new Properties();
        try {
            _props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return _props;
    }
}
