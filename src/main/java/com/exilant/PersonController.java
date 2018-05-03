package com.exilant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	Utils utils;
	
	@PostMapping("/add")
	public void addPerson(@RequestBody Person person) {
		mongoTemplate.insert(person);
	}
	
	@GetMapping("/retrive")
	public List<Person> retrivePerson(){
		return mongoTemplate.findAll(Person.class);
	}
	
	@PostMapping("/addtest")
	public void addPersonTest(@RequestBody Person person) {
		MongoOperations mongoOps = utils.getMongoTemplate();
		mongoOps.insert(person);
	}
	
	@GetMapping("/retrivetest")
	public List<Person> retrivePersonTest(){
		MongoOperations mongoOps = utils.getMongoTemplate();
		return mongoOps.findAll(Person.class);
	}
	
	
	
}
