package nl.graduateproject.localSkill.model.message;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.order.Order;
import nl.graduateproject.localSkill.model.user.Customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
        (name = "messages")
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private String title;

    @Column
    private String bodyText;

    @Column
    private LocalDate date;

    @OneToOne
    private Order order;

    public Message() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}