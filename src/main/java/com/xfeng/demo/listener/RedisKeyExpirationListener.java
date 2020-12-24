package com.xfeng.demo.listener;

import org.apache.shiro.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
//        if(lockBySecondsTime(expiredKey, 30)){
        logger.info("过期key:{}", message.toString());
//        }

    }

    public boolean lockBySecondsTime(String key, long expirationTime) {
        Long timeStamp = new Date().getTime() + (expirationTime * 1000);
        return ifAbsent(key, String.valueOf(timeStamp), expirationTime, TimeUnit.SECONDS);
    }

    public boolean ifAbsent(String key, String value, long expirationTime, TimeUnit timeUnit) {
        Boolean res = (Boolean) redisTemplate.execute(new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.stringCommands().set(key.getBytes(), value.getBytes(),
                        Expiration.from(expirationTime, timeUnit), RedisStringCommands.SetOption.ifAbsent());
            }
        });
        return res == null ? false : res;
    }
}
