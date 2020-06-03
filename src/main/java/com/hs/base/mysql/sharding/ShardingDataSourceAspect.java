package com.hs.base.mysql.sharding;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ShardingDataSourceAspect implements Ordered { 
	private Logger logger = LoggerFactory.getLogger(ShardingDataSourceAspect.class);
	
	@Autowired
	private ShardingDataSourcePropConfig shardingDataSourcePropConfig;
	
	@Pointcut("@annotation(com.hs.base.mysql.sharding.ShardingDataSourceStrategy)")
    public void dataSourcePointCut() {
    }
	
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
    	MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
 
        ShardingDataSourceStrategy ds = method.getAnnotation(ShardingDataSourceStrategy.class);
        if(ds == null){
            ShardingDataSource.setDataSource(shardingDataSourcePropConfig.getDsKeyPrefix() + "0");
        }else {
        	int index = 0;
        	for (String parameterName : signature.getParameterNames()) {
	        	if (parameterName.equalsIgnoreCase(ds.key())) {
	        		ShardingStrategy ss = (ShardingStrategy)ds.strategy().newInstance();
	        		
		            ShardingDataSource.setDataSource(shardingDataSourcePropConfig.getDsKeyPrefix() + ss.sharding(point.getArgs()[index] , shardingDataSourcePropConfig.getSharding()));
		            
		            logger.info("选择的数据源：{}" , shardingDataSourcePropConfig.getDsKeyPrefix() + ss.sharding(point.getArgs()[index] , shardingDataSourcePropConfig.getSharding()));
		            
		            break;
		        }
	        	
	        	index ++;
        	}
        }
 
        try {
            return point.proceed();
        } finally {
            ShardingDataSource.clearDataSource();
        }
    }
 
    @Override
    public int getOrder() {
        return 1;
    }
}
