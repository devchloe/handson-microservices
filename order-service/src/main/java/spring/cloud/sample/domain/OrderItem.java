package spring.cloud.sample.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private long id;
    private long itemId;
    private int count;

    public OrderItem() {
    }

    public OrderItem(long itemId, int count) {
        this.itemId = itemId;
        this.count = count;
    }

    public long getItemId() {
        return itemId;
    }

    public int getCount() {
        return count;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
