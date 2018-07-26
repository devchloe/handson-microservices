package spring.cloud.sample.repository;

import spring.cloud.sample.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
