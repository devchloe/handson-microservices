package spring.cloud.sample.service;

import spring.cloud.sample.clients.CustomerClient;
import spring.cloud.sample.clients.ItemClient;
import spring.cloud.sample.domain.Order;
import spring.cloud.sample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerClient customerClient;
    private ItemClient itemClient;

    @Autowired
    private OrderService(OrderRepository orderRepository, CustomerClient customerClient, ItemClient itemClient) {
        super();
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.itemClient = itemClient;
    }

    public Order order(Order order) {
        if (order.getNumberOfItems() == 0) { throw new IllegalArgumentException("No items to order!"); }
        if (!customerClient.isValidCustomerId(order.getCustomerId())) { throw new IllegalArgumentException("Customer does not exist!"); }

        return orderRepository.save(order);
    }

    public double getPrice(long orderId) {
        return orderRepository.findOne(orderId).totalPrice(itemClient);
    }

    public Collection<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(e -> orders.add(e));
        return orders;
    }

}
