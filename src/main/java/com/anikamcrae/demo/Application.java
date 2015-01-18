package com.anikamcrae.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication //Same as @Configuration + @EnableAutoConfiguration + @ComponentScan
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
    	ConfigurableApplicationContext context = SpringApplication.run(Application.class);
    	CustomerRepository customerRepo = context.getBean(CustomerRepository.class);
    	
    	Customer aries = new Customer("Anika", "McRae");
    	customerRepo.save(aries);
    	
    	Iterable<Customer> customers = customerRepo.findAll();
    	
    	for(Customer customer : customers) {
    		System.out.println(customer);
    	}
    	
    	context.close();
    }
}
