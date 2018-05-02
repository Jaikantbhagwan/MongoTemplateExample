package com.exilant;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;

@SpringBootApplication
public class SpringBootMongoDbTemp1Application {
	 @Autowired
	 static MongoMappingContext mongoMappingContext;
	//@Autowired
	//MappingMongoConverter mappingMongoConverter;
	//private static final Log log = LogFactory.getLog(SpringBootMongoDbTemp1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbTemp1Application.class, args);
		
	    //MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "test"));

		//MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "test", );
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(), "test");
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoOperations mongoOps = new MongoTemplate(mongoDbFactory, converter);
	    Person p = new Person("Joe", 34);

	    // Insert is used to initially store the object into the database.
	    mongoOps.insert(p);
	    /*log.info("Insert: " + p);

	    // Find
	    p = mongoOps.findById(p.getId(), Person.class);
	    //log.info("Found: " + p);

	    // Update
	    mongoOps.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);
	    p = mongoOps.findOne(query(where("name").is("Joe")), Person.class);
	    //log.info("Updated: " + p);

	    // Delete
	    mongoOps.remove(p);

	    // Check that deletion worked
	    List<Person> people =  mongoOps.findAll(Person.class);
	    log.info("Number of people = : " + people.size());


	    mongoOps.dropCollection(Person.class);*/
	  }
	}

