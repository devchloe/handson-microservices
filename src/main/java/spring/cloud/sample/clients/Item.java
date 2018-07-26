package spring.cloud.sample.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item {

    @JsonProperty("id")
    private long itemId;
    private String name;
    private double price;

    public Item() { super(); }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
