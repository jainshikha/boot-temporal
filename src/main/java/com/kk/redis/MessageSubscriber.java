//package com.kk.redis;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageSubscriber implements MessageListener {
//	private static final Logger LOGGER = LoggerFactory.getLogger(MessageSubscriber.class);
//
//	ObjectMapper objectMapper = new ObjectMapper();
//
//	public void onMessage(final Message message, final byte[] pattern) {
//		try {
//			Release release = objectMapper.readValue(message.toString(), Release.class);
//			LOGGER.info("I got a message received - {}", release);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//	}
//}