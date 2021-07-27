package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String description;

    //  NEWLY ADDED FIELD!!!!
    @Column
    private Double totalPrice;

    @ManyToOne
    //Added JSONIGNORE
    @JsonIgnoreProperties("invoice")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "invoice_id")
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
            fetch = FetchType.LAZY
//            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("invoice")
    private List<ItemsOnInvoice> itemsOnInvoices = new ArrayList<>();
}
