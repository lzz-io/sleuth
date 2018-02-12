package com.demo.sleuth.serviceb;

import java.util.Date;

import javax.annotation.Resource;

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

	@Resource
	private ServiceC serviceC;

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/{id}")
	public String fun2(@PathVariable("id") int id) throws Exception {

		try {
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("{}", id);

		if (2 == id) {
			// try {
			throw new Exception("service-b 异常！");
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// // return "service b - id:" + id + " - " + new Date().toString();
			// return null;
		}

		return serviceC.fun3(id);
	}

}
