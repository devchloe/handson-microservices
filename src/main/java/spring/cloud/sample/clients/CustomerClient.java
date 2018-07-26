package spring.cloud.sample.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomerClient {

    private CustomerResource customerResource;

    @Autowired
    private CustomerClient(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    public Collection<Customer> findAll() {
        return customerResource.findAll();
    }

    public Customer getOne(long customerId) {
        return customerResource.getOne(customerId);
    }

    public boolean isValidCustomerId(long customerId) {
        Customer customer = customerResource.getOne(customerId);
        if (null == customer) return false;
        return true;
    }
}
