package com.ExpensesTrackingApp;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableAutoConfiguration
public class ExpensesTrackingAppApplication{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ExpenseRepository expenseRepository;
	public static void main(String[] args) {
		SpringApplication.run(ExpensesTrackingAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String secret = "{bcrypt}" + encoder.encode("default");
				String password2 = "{bcrypt}" + encoder.encode("uphill");
				String password3 = "{bcrypt}" + encoder.encode("timing");
				String password4 = "{bcrypt}" + encoder.encode("gomez");
				String password5 = "{bcrypt}" + encoder.encode("tariq");


				Customer customer1 = new Customer();
				customer1.setEmail("kate.uphill@gmail.com");
				customer1.setUsername("kate.uphill@gmail.com");
				customer1.setPassword(password2);
				customerRepository.save(customer1);

				Customer customer2 = new Customer();
				customer2.setEmail("late.timing@gmail.com");
				customer2.setUsername("late.timing@gmail.com");
				customer2.setPassword(password3);
				customerRepository.save(customer2);

				Customer customer3 = new Customer();
				customer3.setEmail("maria.gomez@gmail.com");
				customer3.setUsername("maria.gomez@gmail.com");
				customer3.setPassword(password4);
				customerRepository.save(customer3);

				Customer customer4 = new Customer();
				customer4.setEmail("ali.tariq@gmail.com");
				customer4.setUsername("ali.tariq@gmail.com");
				customer4.setPassword(password5);
				customerRepository.save(customer4);

				Category category1 = new Category();
				category1.setDescription("Food");
				categoryRepository.save(category1);

				Category category2 = new Category();
				category2.setDescription("Fuel");
				categoryRepository.save(category2);

				Category category3 = new Category();
				category3.setDescription("Accommodation");
				categoryRepository.save(category3);

				Category category4 = new Category();
				category4.setDescription("Travel");
				categoryRepository.save(category4);

				Expense expense1 = new Expense();
				expense1.setAmount(35.48F);
				expense1.setNote("Team Lunch");
				expense1.setStatus(false);
				expense1.setCategory(category1);
				expense1.setCustomer(customer1);
				expenseRepository.save(expense1);

				Expense expense2 = new Expense();
				expense2.setAmount(100.78F);
				expense2.setNote("Conference");
				expense2.setStatus(false);
				expense2.setCategory(category3);
				expense2.setCustomer(customer2);
				expenseRepository.save(expense2);

				Expense expense3 = new Expense();
				expense3.setAmount(75.0F);
				expense3.setNote("Branch Visit");
				expense3.setStatus(true);
				expense3.setCategory(category4);
				expense3.setCustomer(customer3);
				expenseRepository.save(expense3);

				Expense expense4 = new Expense();
				expense4.setAmount(95.0F);
				expense4.setNote("Petrol");
				expense4.setStatus(true);
				expense4.setCategory(category2);
				expense4.setCustomer(customer4);
				expenseRepository.save(expense4);

			}
		};
	}

	@Bean
	public WebMvcConfigurer ExpensesTrackingAppConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
