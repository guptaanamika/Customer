package com.customer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource("classpath:spring/application-context.xml")
@ComponentScan({ "com.customer" })
@EnableAspectJAutoProxy
@EnableScheduling
@EnableCaching
@PropertySource("file:${config.path:src/main/resources/conf}/application.properties")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(CustomerApplication.class);
		application.setShowBanner(false);
		application.run(args);
	}
	
}
