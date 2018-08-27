package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.db1.CustomerRepositoryDB1;
import hello.db2.CustomerRepositoryDB2;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepositoryDB1 repository1, CustomerRepositoryDB2 repository2) {
		return (args) -> {
			// DB1
			repository1.save(new Customer("Jack", "Bauer"));
			repository1.save(new Customer("Chloe", "O'Brian"));
			
			// DB2
			repository2.save(new Customer("Kim", "Bauer"));

			// fetch all customers
			log.info("Customers found with findAll() DB1:");
			log.info("-------------------------------");
			for (Customer customer : repository1.findAll()) {
				log.info(customer.toString());
			}
			log.info("Customers found with findAll() DB2:");
			log.info("-------------------------------");
			for (Customer customer : repository2.findAll()) {
				log.info(customer.toString());
			}
		
		};
	}

}
