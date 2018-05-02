package com.exilant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


@Configuration
public class MongoConfig {

	//======================================================
	@Bean
	public MongoClient mongoDbClient() throws Exception {
		return new MongoClient(new ServerAddress("127.0.0.1"));
	}
 
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongoDbClient(), "test");
	}
 
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTypeMapper typeMapper = new DefaultMongoTypeMapper(null);	
		MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(typeMapper);
 
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		return mongoTemplate;
	}
}
