package nl.graduateproject.localSkill.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(
            mappedBy ="item",
            cascade = CascadeType.ALL
//            ,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("item")
    private List<FileDB> fileDBs = new ArrayList<>();

//    @OneToMany(
//            mappedBy = "item",
//            cascade = CascadeType.ALL
//    )
//    @JsonIgnoreProperties("item")
//    private List<ItemsOnInvoice> itemsOnInvoices = new ArrayList<>();

//    public void addFile(FileDB fileDB) {
//        fileDBs.add(fileDB);
//        fileDB.setItem(this);
//    }
//
//    public void removeFile(FileDB fileDB) {
//        fileDBs.remove(fileDB);
//        fileDB.setItem(null);
//    }




}