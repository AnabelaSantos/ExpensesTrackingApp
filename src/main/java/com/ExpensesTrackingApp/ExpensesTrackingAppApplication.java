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

//	@Bean
//	public CommandLineRunner runner(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//
//				Customer customer1 = new Customer();
//				customer1.setEmail("kate@gmail.com");
//				customer1.setUsername("Kate Uphill");
//				customerRepository.save(customer1);
//
//				Customer customer2 = new Customer();
//				customer2.setEmail("late@gmail.com");
//				customer2.setUsername("Late Timing");
//				customerRepository.save(customer2);
//
//				Customer customer3 = new Customer();
//				customer3.setEmail("jose@gmail.com");
//				customer3.setUsername("Jose");
//				customerRepository.save(customer3);
//
//				Customer customer4 = new Customer();
//				customer4.setEmail("maria@gmail.com");
//				customer4.setUsername("Maria");
//				customerRepository.save(customer4);
//
//				Customer customer5 = new Customer();
//				customer5.setEmail("connie@gmail.com");
//				customer5.setUsername("Connie");
//				customerRepository.save(customer5);
//
//				Category category1 = new Category();
//				category1.setDescription("Food");
//				categoryRepository.save(category1);
//
//				Category category2 = new Category();
//				category2.setDescription("Fuel");
//				categoryRepository.save(category2);
//
//				Category category3 = new Category();
//				category3.setDescription("Accommodation");
//				categoryRepository.save(category3);
//
//				Expense expense1 = new Expense();
//				expense1.setAmount(35.48F);
//				expense1.setNote("Team Lunch");
//				expense1.setStatus(false);
//				expense1.setCategory(category1);
//				expense1.setCustomer(customer1);
//				expenseRepository.save(expense1);
//
//				Expense expense2 = new Expense();
//				expense2.setAmount(100.78F);
//				expense2.setNote("Conference");
//				expense2.setStatus(false);
//				expense2.setCategory(category3);
//				expense2.setCustomer(customer2);
//				expenseRepository.save(expense2);
//
//				Expense expense3 = new Expense();
//				expense3.setAmount(75.0F);
//				expense3.setNote("Branch Visit");
//				expense3.setStatus(true);
//				expense3.setCategory(category2);
//				expense3.setCustomer(customer2);
//				expenseRepository.save(expense3);
//
//				Expense expense4 = new Expense();
//				expense4.setAmount(95.0F);
//				expense4.setNote("Merchandise");
//				expense4.setStatus(true);
//				expense4.setCategory(category2);
//				expense4.setCustomer(customer1);
//				expenseRepository.save(expense4);
//			}
//		};
//	}

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
