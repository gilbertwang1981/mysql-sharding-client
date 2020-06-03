package com.hs.base.mysql.sharding.test;

import com.hs.base.mysql.sharding.ShardingStrategy;

public class MysqlShardTestStrategy implements ShardingStrategy {

	@Override
	public Integer sharding(Object key, Integer shard) {
		return Math.abs(key.hashCode()) % shard;
	}
}
