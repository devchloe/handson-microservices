package spring.cloud.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.sample.domain.Item;
import spring.cloud.sample.service.ItemService;

import java.util.Collection;

@RestController
public class ItemController {

    private static Logger log = LoggerFactory.getLogger(ItemController.class);
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public Collection<Item> items() throws InterruptedException {
        log.info("Received request /items..");

        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable long id) {
        return itemService.findOne(id);
    }
}
