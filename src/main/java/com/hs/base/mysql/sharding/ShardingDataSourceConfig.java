package com.hs.base.mysql.sharding;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ShardingDataSourceConfig {
	
	@Autowired
	private ShardingDataSourcePropConfig shardingDataSourcePropConfig;
 
    @Bean
    @Primary
    public ShardingDataSource dataSource(DataSource ... dsDataSources) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        int index = 0;
        for (DataSource datasource : dsDataSources) {
        	targetDataSources.put(shardingDataSourcePropConfig.getDsKeyPrefix() + index ++ , datasource);
        }
        
        return new ShardingDataSource(dsDataSources[0] , targetDataSources);
    }
}
