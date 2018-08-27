package hello.db2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.Customer;

public interface CustomerRepositoryDB2 extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
