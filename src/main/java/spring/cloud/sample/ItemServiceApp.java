package spring.cloud.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.cloud.sample.domain.Item;
import spring.cloud.sample.repository.ItemRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ItemServiceApp {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceApp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    public void generateInitialData() {
        itemRepository.save(new Item("Banana", 550.0));
        itemRepository.save(new Item("Apple", 700.0));
        itemRepository.save(new Item("Strawberry", 4000.0));
        itemRepository.save(new Item("Peach", 5000.0));
        itemRepository.save(new Item("Water mellon", 9000.0));
    }

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApp.class, args);
    }
}
