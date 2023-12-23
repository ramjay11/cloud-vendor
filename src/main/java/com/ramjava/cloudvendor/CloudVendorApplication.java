package com.ramjava.cloudvendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class CloudVendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudVendorApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/cloudvendor/*"))
				.apis(RequestHandlerSelectors.basePackage("com.ramjava.cloudvendor"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData() {
		return new ApiInfo(
				"Cloud Vendor API Application",
				"Cloud Vendor Documentation",
				"1.0",
				"Cloud Vendor Service Terms",
				new Contact("Ramjay Romorosa", "http://ramjayromorosa.com", "ramjayromorosa@yahoo.com"),
				"Ramjava Licence",
				"http://ramjayromorosa.com",
				Collections.emptyList()
		);
	}


}
