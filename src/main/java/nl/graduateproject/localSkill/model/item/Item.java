package nl.graduateproject.localSkill.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.fileDB.FileDB;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
@Data
// @DATA = LOMBOK = Generates getters and setters
@Table
        (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable of verplicht in constructor?
    @Column
    private String name;

    // nullable of verplicht in constructor?
    @Column
    private double price;

    @Column
    private String description;

    @Column
    private int number;

    @Column
//            (nullable = false)
    private int count;

    // nullable of verplicht in constructor?
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    // compositional relationship ((child)can't exist without parent)
    // aggregational relationship ((child)can exist without parent)

    // compositional relationship ((child:item)can't exist without parent(customer))
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//     compositional relationship ((child: fileDB)can't exist without parent(item))
    @OneToMany(
            mappedBy ="item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("item")
    private List<FileDB> fileDBs = new ArrayList<>();

    // aggregational relationship ((child: invoice)can exist without parent(item))
    @ManyToMany(mappedBy ="invoiceItems" )
    private List<Invoice> invoices = new ArrayList<>();
}