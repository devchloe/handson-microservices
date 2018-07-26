package spring.cloud.sample.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Customer {

    @JsonProperty("id")
    private long customerId;
    private String name;
    private String firstname;
    private String email;
    private String street;
    private String city;

    public Customer() {
    }

    public Customer(long customerId, String name, String firstname, String email, String street, String city) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
