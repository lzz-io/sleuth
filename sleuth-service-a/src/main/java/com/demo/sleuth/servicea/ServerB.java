package com.demo.sleuth.servicea;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SERVICE-B")
public interface ServerB {

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	String index(int id);

}
