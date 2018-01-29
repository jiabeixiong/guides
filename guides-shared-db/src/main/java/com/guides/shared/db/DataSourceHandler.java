package com.guides.shared.db;

import com.guides.shared.db.annotations.DataSourceOptionType;

public class DataSourceHandler {

	private static ThreadLocal<DataSourceOptionType> holder = new ThreadLocal<DataSourceOptionType>();
	
	
	public static void putDataSourceTarget(DataSourceOptionType dataSourceTarget) {
		holder.set(dataSourceTarget);
	}
	
	public static DataSourceOptionType getDataSourceTarget() {
		return holder.get();
	}
	
}
