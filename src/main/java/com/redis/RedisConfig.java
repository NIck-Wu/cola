package com.redis;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	// TODO remove config of redis to application.yml
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost", 6379);
//		RedisPassword redisPassword = RedisPassword.of("lcex123");
//		configuration.setDatabase(5);
//		configuration.setPassword(redisPassword);
		return new LettuceConnectionFactory(configuration);
	}

	@Bean
	public RedisTemplate<String, Serializable> redisCacheTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean
	public RedisTemplate<String, Object> redisObjectTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> stringUserRedisTemplate = new RedisTemplate<>();
		stringUserRedisTemplate.setKeySerializer(new StringRedisSerializer());
		stringUserRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		stringUserRedisTemplate.setConnectionFactory(redisConnectionFactory);
		return stringUserRedisTemplate;
	}

}