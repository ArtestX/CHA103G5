package com.cha103g5.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        // 設定 Redis 連接工廠
        // 如果需要，這裡可以配置 Redis 服務器的地址和端口
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // 創建一個 RedisTemplate
        // 它可以更高效地執行 Redis 操作
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());

        // 序列化設定，這裡使用的是泛型字符串序列化器
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
}
