package nl.graduateproject.localSkill.model.order;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.message.Message;
import nl.graduateproject.localSkill.model.user.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
        (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties( "orders" )
    private List<Item>items = new ArrayList<>();

    // BUGGED - IF INSERTED ORDER_ID IN POSTGRES: APPLICATION CRASHES

    @OneToOne(
            mappedBy = "order",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("orders")
    @PrimaryKeyJoinColumn
    private Message message;


    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

