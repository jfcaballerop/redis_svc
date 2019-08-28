package com.logesta.redissvc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * RedisConfig
 */
@Configuration
@ComponentScan("com.logesta")
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String REDIS_HOSTNAME;
    @Value("${spring.redis.port}")
    private int REDIS_PORT;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        // return new JedisConnectionFactory();

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(REDIS_HOSTNAME, REDIS_PORT);
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
        factory.afterPropertiesSet();
        return factory;
    }

    // @Bean
    // public RedisTemplate<String, Object> redisTemplate() {
    // final RedisTemplate<String, Object> template = new RedisTemplate<String,
    // Object>();
    // template.setConnectionFactory(jedisConnectionFactory());
    // // template.setValueSerializer(new
    // GenericToStringSerializer<Object>(Object.class));
    // return template;
    // }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    public StringRedisTemplate strRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    // @Bean
    // MessageListenerAdapter messageListener() {
    // return new MessageListenerAdapter(new MessageSubscriber());
    // }

    // @Bean
    // RedisMessageListenerContainer redisContainer() {
    // final RedisMessageListenerContainer container = new
    // RedisMessageListenerContainer();
    // container.setConnectionFactory(jedisConnectionFactory());
    // container.addMessageListener(messageListener(), topic());
    // return container;
    // }

    // @Bean
    // MessagePublisher redisPublisher() {
    // return new MessagePublisherImpl(redisTemplate(), topic());
    // }

    // @Bean
    // ChannelTopic topic() {
    // return new ChannelTopic("pubsub:queue");
    // }
}