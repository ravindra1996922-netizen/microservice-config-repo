package com.productsservice.microservice.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "product-service")
public class AppProperties {
	
	private  Map<String, String> messages=new HashMap<>();
	

}
