//package com.kk.redis;
//
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessagePublisher {
//    //@Autowired
//    private RedisTemplate<String, Release> redisTemplate = new RedisTemplate<>();
//
//    //@Autowired
//    private ChannelTopic topic;
//
//    public MessagePublisher() {
//    }
//
//
//    public MessagePublisher(final RedisTemplate<String, Release> redisTemplate, final ChannelTopic topic) {
//        this.redisTemplate = redisTemplate;
//        this.topic = topic;
//    }
//    public void handleMessage(final Release message) {
//        redisTemplate.convertAndSend(topic.getTopic(), message);
//    }
//
//}
