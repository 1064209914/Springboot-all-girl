package com.example.demo.common;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

		/*@Bean
	    public RemoteIpFilter remoteIpFilter() {
	        return new RemoteIpFilter();
	    }*/

		@Bean
	    public FilterRegistrationBean testFilterRegistration() {

	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new TimeFilter());
	        registration.addUrlPatterns("/hello");
	       // registration.addInitParameter("paramName", "paramValue");
	        registration.setName("MyFilter");
	        registration.setOrder(1);
	        return registration;
	    }
	
}