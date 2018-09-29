package com.tupperware.auto.config;

import java.io.IOException;
//http://www.cnblogs.com/lianggp/p/7573653.html
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

@Configuration

@MapperScan(basePackages = MybatisPlusConfigMysql.PACKAGE, sqlSessionFactoryRef = "extraSqlSessionFactory")
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisPlusConfigMysql {

	@Autowired
	private MybatisProperties properties;
	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();
	@Autowired(required = false)
	private Interceptor[] interceptors;
	@Autowired(required = false)
	private DatabaseIdProvider databaseIdProvider;

	// 精确到 master 目录，以便跟其他数据源隔离
	static final String PACKAGE = "com.tupperware.auto.mysql.mapper";
	static final String MAPPER_LOCATION = "classpath:mapper/mysql/*.xml";
	static final String MODEL_LOCATION = "com.tupperware.auto.mysql.model";

	@Value("${spring.mysql.datasource.url}")
	private String url;

	@Value("${spring.mysql.datasource.username}")
	private String user;

	@Value("${spring.mysql.datasource.password}")
	private String password;

	@Value("${spring.mysql.datasource.driverClassName}")
	private String driverClass;

	/**
	 * 配置DataSource
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Bean(name = "extraDataSource")
	public DataSource druidDataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	/**
	 * @Description : mybatis-plus分页插件 ---------------------------------
	 * @Author : Liang.Guangqing
	 * @Date : Create in 2017/9/19 13:59
	 */
	@Bean(name = "extrapaginationInterceptor")
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;
	}

	/**
	 * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定 配置文件和mybatis-boot的配置文件同步
	 * 
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	@Bean(name = "extraSqlSessionFactory")
	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(
			@Qualifier("extraDataSource") DataSource druidDataSource) throws IOException {
		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();

		mybatisPlus.setDataSource(druidDataSource);

		mybatisPlus.setVfs(SpringBootVFS.class);
		if (StringUtils.hasText(this.properties.getConfigLocation())) {
			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
		}
		mybatisPlus.setConfiguration(properties.getConfiguration());
		if (!ObjectUtils.isEmpty(this.interceptors)) {
			mybatisPlus.setPlugins(this.interceptors);
		}
		// MP 全局配置，更多内容进入类看注释
		GlobalConfiguration globalConfig = new GlobalConfiguration();
		globalConfig.setDbType(DBType.MYSQL.name());
		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID")
		// ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
		globalConfig.setIdType(2);
		mybatisPlus.setGlobalConfig(globalConfig);
		MybatisConfiguration mc = new MybatisConfiguration();
		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		mybatisPlus.setConfiguration(mc);
		if (this.databaseIdProvider != null) {
			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
		}
		// if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
		// mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
		// // System.out.println(this.properties.getTypeAliasesPackage());
		// }
		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
		}
		// if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
		// mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
		// }
		mybatisPlus.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(MybatisPlusConfigMysql.MAPPER_LOCATION));
		mybatisPlus.setTypeAliasesPackage(MybatisPlusConfigMysql.MODEL_LOCATION);
		return mybatisPlus;
	}

}