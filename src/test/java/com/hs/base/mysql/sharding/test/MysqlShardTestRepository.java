package com.hs.base.mysql.sharding.test;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlShardTestRepository {
	public Integer insert(@Param("data") String data);
}
