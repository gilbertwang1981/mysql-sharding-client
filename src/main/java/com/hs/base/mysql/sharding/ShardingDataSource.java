package com.hs.base.mysql.sharding;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ShardingDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    
    public ShardingDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSources));
        super.afterPropertiesSet();
    }
 
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
 
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }
 
    public static String getDataSource() {
        return contextHolder.get();
    }
 
    public static void clearDataSource() {
        contextHolder.remove();
    }
}
