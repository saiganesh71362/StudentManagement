package com.stude.swaggerconfguration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentMangementSwaggerConfiguration
{

	@Bean
	public GroupedOpenApi controllerApi()
	{
	        return GroupedOpenApi.builder()
	                .group("Student-Management")
	                .packagesToScan("com.stude.controller")
	                .build();
	 }
}
