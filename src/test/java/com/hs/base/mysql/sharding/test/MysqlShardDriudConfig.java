package com.hs.base.mysql.sharding.test;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hs.base.mysql.sharding.ShardingDataSourceConfig;

@Component
public class MysqlShardDriudConfig extends ShardingDataSourceConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasources.ds0")
    public DataSource dataSource0() {
		return DataSourceBuilder.create().build();
    }
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasources.ds1")
    public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
    }
}
