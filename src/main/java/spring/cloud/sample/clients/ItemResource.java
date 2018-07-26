package spring.cloud.sample.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

@FeignClient(name = "items")
public interface ItemResource {

    @GetMapping("/")
    Collection<Item> findAll();

    @GetMapping("/{itemId}")
    Item getOne(@PathVariable("itemId") long itemId);
}
