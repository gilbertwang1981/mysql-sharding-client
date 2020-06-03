package com.hs.base.mysql.sharding.test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MysqlShardTestCaller {
	private static Logger logger = LoggerFactory.getLogger(MysqlShardTestCaller.class);
	
	@Autowired
	private MysqlShardTestService mysqlShardTestService;
	
	@PostConstruct
	private void init() {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			public void run() {
				call();
			}
		} , 5000 , 5000); 
	}
	
	private void call() {
		logger.info(mysqlShardTestService.add("this is a test " + UUID.randomUUID()) > 0 ? "插入成功" : "插入失败");
	}
}
