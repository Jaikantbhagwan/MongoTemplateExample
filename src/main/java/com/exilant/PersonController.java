package com.exilant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@PostMapping("/add")
	public void addPerson(@RequestBody Person person) {
		mongoTemplate.insert(person);
	}
}
