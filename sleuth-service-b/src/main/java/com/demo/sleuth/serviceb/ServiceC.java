package com.demo.sleuth.serviceb;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SERVICE-C", qualifier = "serviceC")
public interface ServiceC {

	@RequestMapping(value = "/{id}")
	String fun3(@PathVariable("id") int id);

}
