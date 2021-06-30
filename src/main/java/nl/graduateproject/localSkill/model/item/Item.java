package nl.graduateproject.localSkill.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.ItemsOnInvoice;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.fileDB.FileDB;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table
        (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private String description;

    @Column
    private int number;

    @Column
//            (nullable = false)
    private int count;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne
    @JoinColumn(name = "username")
    private Customer customer;

    @OneToMany(
            mappedBy ="item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("item")
    private List<FileDB> fileDBs = new ArrayList<>();

//    @ManyToMany(mappedBy ="invoiceItems" )
//    private List<Invoice> invoices = new ArrayList<>();
//
    @OneToMany(
            mappedBy = "item",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("item")
    private List<ItemsOnInvoice> itemsOnInvoices = new ArrayList<>();
}