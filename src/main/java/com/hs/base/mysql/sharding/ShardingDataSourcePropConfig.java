package com.hs.base.mysql.sharding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "propConfig")
@Component
public class ShardingDataSourcePropConfig {
	private String dsKeyPrefix;
	private Integer sharding;
	
	public String getDsKeyPrefix() {
		return dsKeyPrefix;
	}
	public void setDsKeyPrefix(String dsKeyPrefix) {
		this.dsKeyPrefix = dsKeyPrefix;
	}
	public Integer getSharding() {
		return sharding;
	}
	public void setSharding(Integer sharding) {
		this.sharding = sharding;
	}
}
