package com.charter.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.charter.rewards.interceptor.SwaggerFilter;


@SpringBootApplication
public class RewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}
	
	 @Bean
	 public FilterRegistrationBean filterRegistrationBean(){
	        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	        filterRegistrationBean.setFilter(new SwaggerFilter());
	        return filterRegistrationBean;
	    }

}
