package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.query.EnableQueryExecutor;

/**
 * Sample how to use the project query-executor
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 11/03/2018 20:31:15
 */
@Configuration
@SpringBootApplication
@EnableQueryExecutor
public class QueryExecutorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryExecutorClientApplication.class, args);
	}

}
