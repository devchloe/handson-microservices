package spring.cloud.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.cloud.sample.domain.Item;
import spring.cloud.sample.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    private ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findOne(long id) {
        Item item = itemRepository.findOne(id);
        if (null == item) throw new IllegalArgumentException("Item does not exist!");

        return itemRepository.findOne(id);
    }

    public Collection<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(e -> items.add(e));
        return items;
    }
}
