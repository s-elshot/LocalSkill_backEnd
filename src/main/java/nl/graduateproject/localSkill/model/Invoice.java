package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
@Table
public class Invoice {

    @Id
    // used to be @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String description;

    // nullable of verplicht in constructor?
    // compositional relationship ((child)can't exist without parent)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // aggregational relationship ((child)can exist without parent)
    @OneToOne
    private Message message;

    @ManyToMany
    @JoinTable(
            name = "invoice_items",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "items_id")
    )
    @JsonIgnoreProperties("invoices")
    private List<Item> invoiceItems = new ArrayList<>();


}
