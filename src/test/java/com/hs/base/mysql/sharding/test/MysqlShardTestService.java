package com.hs.base.mysql.sharding.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.base.mysql.sharding.ShardingDataSourceStrategy;

@Service
public class MysqlShardTestService {
	@Autowired
	private MysqlShardTestRepository mysqlShardTestRepository;
	
	@Transactional
	@ShardingDataSourceStrategy(key = "data" , strategy = MysqlShardTestStrategy.class)
	public Integer add(String data) {
		return mysqlShardTestRepository.insert(data);
	}
}
