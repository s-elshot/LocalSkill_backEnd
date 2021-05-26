package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // nullable of verplicht in constructor?
    @Column
    private String firstName;

    // nullable of verplicht in constructor?
    @Column
    private String lastName;

    @Column
//            (nullable = false, unique = true)
    private String emailAdress;

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
    @Enumerated(EnumType.STRING)
    private CustomerType userRole;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Item> items = new ArrayList<>();


    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Message>messages = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Invoice>invoices = new ArrayList<>();

}


