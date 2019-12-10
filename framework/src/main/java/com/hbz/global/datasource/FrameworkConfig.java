package com.hbz.global.datasource;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author mahy
 * @Time 2019-12-05 15:29
 * @Describe : oracle 数据源的配置
 */

@Configuration //表示这个类为一个配置类
@MapperScan(basePackages = "com.hbz.module.*.dao.framework", sqlSessionFactoryRef = "sqlSessionFactoryFramework")
public class FrameworkConfig {

	// 将这个对象放入Spring容器中
	@Bean(name = "dataSourceFramework")
	// 表示这个数据源是默认数据源
	@Primary
	// 读取application.properties中的配置参数映射成为一个对象
	// prefix表示参数的前缀
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource getDateSource1() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "sqlSessionFactoryFramework")
	@Primary // 表示这个数据源是默认数据源
	// @Qualifier表示查找Spring容器中名字为test1DataSource的对象
	public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSourceFramework") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		VFS.addImplClass(SpringBootVFS.class);//mybatis的facroty需要加载SpringBoot独特的虚拟文件系统，才能识别类路
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*/framework/*.xml"));
		return bean.getObject();
	}


	@Bean("sqlSessionTemplateFramework")
	// 表示这个数据源是默认数据源
	@Primary
	public SqlSessionTemplate sqlSessionTemplate1(
			@Qualifier("sqlSessionFactoryFramework") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}

}
