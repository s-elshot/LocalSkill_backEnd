package nl.graduateproject.localSkill.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.Message;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
@Entity
@Table
//        (uniqueConstraints = {
//        @UniqueConstraint(columnNames = "userName"),
//        @UniqueConstraint(columnNames = "email")
//})

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // nullable of verplicht in constructor?
    @Column
    private String firstName;

    // nullable of verplicht in constructor?


//    @Column(unique = true)
    private String userName;

    @Column
    private String lastName;

    @Id
    @Column
//            (nullable = false, unique = true)
    private String email;

    // nullable of verplicht in constructor?
    @Column
//            (nullable = false)
    private String areaCode;

    @Column
    private String city;

    // nullable of verplicht in constructor?
    @Column
//            (nullable = false)
    private String password;


    @Column
//            (nullable = false)
    private boolean enabled;

    @Column
    private String guild;


    // nullable of verplicht in constructor?
    // CHECK USAGE IN REACT!!!!!!!!!!!
    @Enumerated(EnumType.STRING)
    private CustomerGuild customerGuild;

    // nullable of verplicht in constructor?
    @Enumerated(EnumType.STRING)
    private CustomerType userRole;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();




    // compositional relationship ((child:item)can't exist without parent(Customer))
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Item> items = new ArrayList<>();

    // aggregational relationship ((child)can exist without parent)
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
//            ,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Message>messages = new ArrayList<>();

    // compositional relationship ((child:invoice)can't exist without parent(Customer))
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
//            ,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Invoice>invoices = new ArrayList<>();

}


