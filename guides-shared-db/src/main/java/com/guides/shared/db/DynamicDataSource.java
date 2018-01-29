package com.guides.shared.db;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import com.guides.shared.db.annotations.DataSourceOptionType;

@Primary
@Component("dynamicDataSource")
public class DynamicDataSource extends AbstractRoutingDataSource{


	@Resource(name="writeDataSource")
	private DataSource writeDataSource;
	
	@Resource(name="read01DataSource")
	private DataSource read01DataSource;

	
	private Map<Object, Object> targetDataSources = new HashMap<Object,Object>();
	
	@PostConstruct
	public void init() {
		targetDataSources.put(DataSourceOptionType.WRITE, writeDataSource);
		targetDataSources.put(DataSourceOptionType.READ, read01DataSource);
		super.setTargetDataSources(targetDataSources);
	}
	
	
	@Override
	public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
		defaultTargetDataSource = writeDataSource;
		super.setDefaultTargetDataSource(defaultTargetDataSource);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHandler.getDataSourceTarget();
	}

}
