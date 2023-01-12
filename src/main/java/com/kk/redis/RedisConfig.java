//package com.kk.redis;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Release> redisTemplate() {
//        final RedisTemplate<String, Release> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        RedisSerializer<Release> valueSerializer = new Jackson2JsonRedisSerializer<>(Release.class);
//		template.setValueSerializer(valueSerializer);
//        return template;
//    }
//
//    @Bean
//    MessageListenerAdapter messageListener() {
//        return new MessageListenerAdapter(new MessageSubscriber());
//    }
//
//    @Bean
//    RedisMessageListenerContainer redisContainer() {
//        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(jedisConnectionFactory());
//        container.addMessageListener(messageListener(), topic());
//        return container;
//    }
//
//    @Bean
//    MessagePublisher redisPublisher() {
//        return new MessagePublisher(redisTemplate(), topic());
//    }
//
//    @Bean
//    ChannelTopic topic() {
//        return new ChannelTopic("pubsub:release");
//    }
//}