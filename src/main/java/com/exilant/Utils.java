package com.exilant;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Component
public class Utils {	
	
	public MongoTemplate getMongoTemplate() {		
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(), "mongotest");
      	DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
      	MongoMappingContext mongoMappingContext = new MongoMappingContext();
	    MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return new MongoTemplate(mongoDbFactory, converter);		
	}

}
