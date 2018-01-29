package com.guides.shared.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DataSourceConfig {

	
	@Bean("writeDataSource")
	@ConfigurationProperties(prefix = "jdbc.write")
	public DataSource writeDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	
	@Bean("read01DataSource")
	@ConfigurationProperties(prefix = "jdbc.read01")
	public DataSource read01DataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
}
