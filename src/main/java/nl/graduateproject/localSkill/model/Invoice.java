package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "username")
    private Customer customer;

    @OneToOne
    private Message message;

//    @ManyToMany
//    @JoinTable(
//            name = "invoice_items",
//            joinColumns = @JoinColumn(name = "invoice_id"),
//            inverseJoinColumns = @JoinColumn(name = "items_id")
//    )
//    @JsonIgnoreProperties("invoices")
//    private List<Item> invoiceItems = new ArrayList<>();

    @OneToMany(
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonIgnoreProperties("invoice")
    private List<ItemsOnInvoice> itemsOnInvoices = new ArrayList<>();
}
