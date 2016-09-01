/**
 * 
 */
package com.unclechen.sp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;

import com.unclechen.sp.dao.IAdminUserDao;

/**
 * @author unclechen 所有数据库操作调用的正面类
 */

@Component("facade")
public class Facade {
	protected static final Logger log = Logger.getLogger(Facade.class);

	@Autowired
	public IAdminUserDao adminUserDao;

	@Autowired
	public JedisPool jedisPool;

	@Autowired
	public MongoTemplate mongoTemplate;

}
