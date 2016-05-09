/**	
 * <br>
 * Copyright 2011 IFlyTek.All rights reserved.<br>
 * <br>			 
 * Package: com.iflytek.cacheserver.cache.jedis <br>
 * FileName: JedisPool.java <br>
 * <br>
 * @version
 * @author xkfeng@iflytek.com
 * @created 2014-11-21
 * @last Modified 
 * @history
 */
package com.xiongwu.lingzhong.support.redis;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool.BasePoolableObjectFactory;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 *  重写JedisPool
 *  @author xkfeng@iflytek.com
 *  @created 2014-11-21 上午11:51:45
 *  @lastModified       
 *  @history           
 */
@SuppressWarnings("rawtypes")
public class JedisPool extends Pool{

	private static class JedisFactory extends BasePoolableObjectFactory
    {

        public Object makeObject() throws Exception
        {
            Jedis jedis;
            if(timeout > 0)
                jedis = new Jedis(host, port, timeout);
            else
                jedis = new Jedis(host, port);
            jedis.connect();
            if(StringUtils.isNotBlank(password)){
                jedis.auth(password);
            }
            return jedis;
        }

        public void destroyObject(Object obj)
            throws Exception
        {
            if(obj instanceof Jedis)
            {
                Jedis jedis = (Jedis)obj;
                if(jedis.isConnected())
                    try
                    {
                        try
                        {
                            jedis.quit();
                        }
                        catch(Exception e) { }
                        jedis.disconnect();
                    }
                    catch(Exception e) { }
            }
        }

        public boolean validateObject(Object obj)
        {
            if(obj instanceof Jedis)
            {
                Jedis jedis = (Jedis)obj;
                try
                {
                    return jedis.isConnected() && jedis.ping().equals("PONG");
                }
                catch(Exception e)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }

        private final String host;
        private final int port;
        private final int timeout;
        private final String password;

        public JedisFactory(String host, int port, int timeout, String password)
        {
            this.host = host;
            this.port = port;
            this.timeout = timeout <= 0 ? -1 : timeout;
            this.password = password;
        }
    }


    public JedisPool(org.apache.commons.pool.impl.GenericObjectPool.Config poolConfig, String host)
    {
        this(poolConfig, host, 6379, 2000, null);
    }

    public JedisPool(String host, int port)
    {
        super(new org.apache.commons.pool.impl.GenericObjectPool.Config(), new JedisFactory(host, port, 2000, null));
    }

    public JedisPool(org.apache.commons.pool.impl.GenericObjectPool.Config poolConfig, String host, int port, int timeout, String password)
    {
        super(poolConfig, new JedisFactory(host, port, timeout, password));
    }

    public JedisPool(org.apache.commons.pool.impl.GenericObjectPool.Config poolConfig, String host, int port)
    {
        this(poolConfig, host, port, 2000, null);
    }

    public JedisPool(org.apache.commons.pool.impl.GenericObjectPool.Config poolConfig, String host, int port, int timeout)
    {
        this(poolConfig, host, port, timeout, null);
    }

	public Jedis getResource(){
		return (Jedis) super.getResource();
	}

}
