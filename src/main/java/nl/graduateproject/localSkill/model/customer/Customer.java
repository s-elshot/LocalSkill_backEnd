package nl.graduateproject.localSkill.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.Invoice;

import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.Message;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table
//        (uniqueConstraints = {
//        @UniqueConstraint(columnNames = "userName"),
//        @UniqueConstraint(columnNames = "email")
//})
public class Customer {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
//    @NotBlank
    @Size(max = 20)
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
//    @NotBlank
    @Size(max = 50)
//    @Email
//            (nullable = false, unique = true)
    private String email;

    @Column
//            (nullable = false)
    private String areaCode;

    @Column
    private String city;

    @Column
//    @NotBlank
    @Size(max = 120)
    private String password;


    @Column
//            (nullable = false)
    private boolean enabled;


    @Enumerated(EnumType.STRING)
    private CustomerGuild customerGuild;

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
            cascade = CascadeType.ALL
//            ,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Message>messages = new ArrayList<>();

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
//            ,
//            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Invoice>invoices = new ArrayList<>();


}


