package spring.cloud.sample.repository;

import spring.cloud.sample.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
