package com.softToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("${backbase/services-config}")
public class SoftTokenApplication extends SpringBootServletInitializer {

	private static Class<SoftTokenApplication> applicationClass = SoftTokenApplication.class;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	public static void main(String[] args) {
		SpringApplication.run(SoftTokenApplication.class, args);

	}

	

}
