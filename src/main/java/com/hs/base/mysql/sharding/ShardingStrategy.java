package com.hs.base.mysql.sharding;

public interface ShardingStrategy {
	public Integer sharding(Object key , Integer shard);
}
