package spring.cloud.sample.service;

import spring.cloud.sample.domain.Customer;
import spring.cloud.sample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private Collection<Customer> allCustomers;

    @Autowired
    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOne(long id) {
        Customer customer = customerRepository.findOne(id);
        if (null == customer) throw new IllegalArgumentException("Customer does not exist!");

        return customerRepository.findOne(id);
    }

    public Collection<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(e -> customers.add(e));
        return customers;
    }
}
