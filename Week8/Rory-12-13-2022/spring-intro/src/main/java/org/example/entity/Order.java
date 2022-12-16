package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired; // Equivalent to Java's Inject annotation
import org.springframework.beans.factory.annotation.Qualifier; // Equivalent to Java's Named annotation

public class Order {
    private int id;
    private Account account;
    // @Autowired on properties can take the place of setter methods
    @Autowired
    private Item item;

    public Item getItem() {
        return item;
    }

    // we can auto-wire setters:
    @Autowired
    public void setAccount(@Qualifier("ron") Account account) { // we use the qualifier annoation to distinguish between beans of the same type
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    // autowrite constructors:
    @Autowired // multiple beans are distinguished by object type
    public Order(@Qualifier("ron") Account account, Item item) {
        super();
        this.account = account;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "account=" + account +
                ", id=" + id +
                ", item=" + item +
                '}';
    }
}

