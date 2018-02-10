package com.demo.sleuth.servicea;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-B")
public interface ServiceB {

	@RequestMapping(value = "/{id}")
	String fun2(@PathVariable("id") int id);

}
