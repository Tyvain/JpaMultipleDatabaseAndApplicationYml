package hello.db1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.Customer;

public interface CustomerRepositoryDB1 extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
