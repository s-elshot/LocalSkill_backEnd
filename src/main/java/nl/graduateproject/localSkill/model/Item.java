package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    // nullable of verplicht in constructor?
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(
            mappedBy ="item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("item")
    private List<Image> images  = new ArrayList<>();

    @ManyToMany(mappedBy ="invoiceItems" )
    private List<Invoice> invoices = new ArrayList<>();

}