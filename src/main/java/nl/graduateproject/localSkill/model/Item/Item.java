package nl.graduateproject.localSkill.model.Item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.graduateproject.localSkill.model.image.Image;
import nl.graduateproject.localSkill.model.order.Order;
import nl.graduateproject.localSkill.model.user.Customer;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
        (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private String description;

    @Column
    private int number;

    @Column(nullable = false)
    private int count;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany(mappedBy ="orderedItems" )
    private List<Order> orders = new ArrayList<>();

@OneToMany(
           mappedBy ="item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
   @JsonIgnoreProperties("item")
    private List<Image> images  = new ArrayList<>();

    public Item() {
    }

    // getter and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}

