package nl.graduateproject.localSkill.model.order;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.user.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToMany
//    @JoinTable(
//                name = "ordered_items",
//            joinColumns = @JoinColumn(name = "orders_id"),
//            inverseJoinColumns = @JoinColumn(name = "items_id")
//            )
////    @JsonIgnore
//    private List<Item> orderedItems = new ArrayList<>();


    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public List<Item> getOrderedItems() {
//        return orderedItems;
//    }
//
//    public void setOrderedItems(List<Item> orderedItems) {
//        this.orderedItems = orderedItems;
//    }
}

