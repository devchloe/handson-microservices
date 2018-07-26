package spring.cloud.sample.repository;

import org.springframework.data.repository.CrudRepository;
import spring.cloud.sample.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
