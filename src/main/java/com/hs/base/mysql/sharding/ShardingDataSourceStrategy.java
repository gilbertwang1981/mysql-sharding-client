package com.hs.base.mysql.sharding;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShardingDataSourceStrategy {
	/**
	 * 分库字段
	 * @return
	 */
    String key();
    
    /**
	 * 分库策略实现类
	 * @return
	 */
    Class<?> strategy();
}
