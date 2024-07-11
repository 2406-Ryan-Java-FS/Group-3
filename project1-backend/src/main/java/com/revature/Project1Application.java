package com.revature;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application {

	private static final Logger logger= LoggerFactory.getLogger(Project1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

//	//Just making sure this jar knows about it's database
//	@Value("${DB_NAME}") private String dbName;
//
//	@PostConstruct
//	public void printStuff(){
//		logger.info("DB_NAME="+this.dbName);
//	}
}
