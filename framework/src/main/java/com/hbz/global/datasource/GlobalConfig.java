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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author mahy
 * @Time 2019-12-05 15:29
 * @Describe : mysql 数据源的配置
 */
@Configuration
@MapperScan(basePackages = "com.hbz.module.*.dao.global", sqlSessionFactoryRef = "sqlSessionFactoryGlobal")
public class GlobalConfig {

	@Bean(name = "datasourceGlobal")
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource getDateSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sqlSessionFactoryGlobal")
	public SqlSessionFactory sqlSessionFactory2(@Qualifier("datasourceGlobal") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		VFS.addImplClass(SpringBootVFS.class);//mybatis的facroty需要加载SpringBoot独特的虚拟文件系统，才能识别类路
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*/global/*.xml"));
		return bean.getObject();
	}

	@Bean("sqlSessionTemplateGlobal")
	public SqlSessionTemplate sqlSessionTemplate2(
			@Qualifier("sqlSessionFactoryGlobal") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}
}
