package com.guides.shared.db.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * mybatis 相关配置
 * @author yangming
 *
 */
@Configuration
@MapperScan(basePackages= {"com.**.dao"})
public class MybatisConfig implements TransactionManagementConfigurer{


	@Autowired
	@Qualifier("dynamicDataSource")
	private DataSource dynamicDataSource;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		try {
			PathMatchingResourcePatternResolver pathMatchResolver = new PathMatchingResourcePatternResolver();
			Resource[] mapperLocations = pathMatchResolver.getResources("classpath*:mybatis/mapper/**/*.xml");
			// 指定mapper xml目录
			bean.setMapperLocations(mapperLocations);
			// 驼峰映射
			bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
			return bean.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Transaction 相关配置
	 * 因为有两个数据源，所有使用ChainedTransactionManager把两个DataSourceTransactionManager包括在一起。
	 */
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dynamicDataSource);
		return transactionManager;
	}

}
