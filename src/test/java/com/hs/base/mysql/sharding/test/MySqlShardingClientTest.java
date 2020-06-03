package com.hs.base.mysql.sharding.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.hs.base.mysql.sharding.test")
@ComponentScan(basePackages="com")
public class MySqlShardingClientTest {
	public static void main(String [] args) {
		SpringApplication.run(MySqlShardingClientTest.class , args);
	}
}
