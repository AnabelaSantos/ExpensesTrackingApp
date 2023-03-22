package com.ExpensesTrackingApp;

import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableAutoConfiguration
public class ExpensesTrackingAppApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpensesTrackingAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				Customer customer = new Customer();
				customer.setEmail("kate@gmail.com");
				customer.setUsername("Kate Uphill");
				userRepository.save(customer);

				Customer customer1 = new Customer();
				customer1.setEmail("late@gmail.com");
				customer1.setUsername("Late Timing");
				userRepository.save(customer1);
			}
		};
	}

}
