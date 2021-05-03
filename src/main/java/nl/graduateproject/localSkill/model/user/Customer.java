package nl.graduateproject.localSkill.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
//            (nullable = false, unique = true)
    private String emailAdress;

    @Column
//            (nullable = false)
    private String areaCode;

    @Column
    private String city;


    @Column
//            (nullable = false)
    private String password;


    @Column
//            (nullable = false)
    private boolean enabled;

    @Column
    private String guild;


    @Enumerated(EnumType.STRING)
    private CustomerType userRole;

    @OneToMany(
            mappedBy = "customer"
//            ,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Item> items = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer"
//            ,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Order> orders = new ArrayList<>();


    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public CustomerType getUserRole() {
        return userRole;
    }

    public void setUserRole(CustomerType userRole) {
        this.userRole = userRole;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
