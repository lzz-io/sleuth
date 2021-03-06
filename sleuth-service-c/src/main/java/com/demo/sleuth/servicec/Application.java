package com.demo.sleuth.servicec;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/{id}")
	public String fun3(@PathVariable("id") int id) {

		try {
			Thread.sleep(300L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("{}", id);

		if (3 == id) {
			return "service c - id:" + id + " - " + new Date().toString();
		}

		return "service c - id:" + id + " - " + new Date().toString();
	}

}
