package com.logesta.redissvc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisSvcApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RedisSvcApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "16379"));
        app.run(args);
	}

}
