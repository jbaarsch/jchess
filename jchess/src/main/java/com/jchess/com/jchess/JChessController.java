package com.jchess;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Controller
public class JChessController {

	@GetMapping(value = "/")
	public String index() {
		/*
		MongoClient mongoClient = MongoClients.create("mongodb://mongodb:27017");
		MongoDatabase database = mongoClient.getDatabase("myMongoDB");
		mongoClient.listDatabaseNames().forEach(System.out::println);
		
		
		JDBCPostgreSQLConnection app = new JDBCPostgreSQLConnection();
        app.connect();
		*/
		return "Home";
	}
	
}
