package com.mobileapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@SpringBootApplication
public class MobileApiApplication extends SpringBootServletInitializer{

	
	/// hello from prince
	/// raksmey pull some code
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MobileApiApplication.class);
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(MobileApiApplication.class, args);
	}
}
