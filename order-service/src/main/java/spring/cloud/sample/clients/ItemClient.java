package spring.cloud.sample.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.cloud.sample.controller.OrderController;

import java.util.Collection;

@Component
public class ItemClient {

    private static Logger log = LoggerFactory.getLogger(ItemClient.class);
    private ItemResource itemResource;
    private Collection<Item> itemsCache = null;

    @Autowired
    public ItemClient(ItemResource itemResource) {
        this.itemResource = itemResource;
    }



    @HystrixCommand(fallbackMethod = "getOneCache")
    public Item getOne(long itemId) {
        return itemResource.getOne(itemId);
    }

    public Item getOneCache(long itemId) {
        return itemsCache.stream().filter(i -> (i.getItemId() == itemId)).findFirst().get();
    }

    @HystrixCommand(fallbackMethod = "priceCache")
    public double price(long itemId) {
        return itemResource.getOne(itemId).getPrice();
    }

    public double priceCache(long itemId) {
        return getOneCache(itemId).getPrice();
    }

}
