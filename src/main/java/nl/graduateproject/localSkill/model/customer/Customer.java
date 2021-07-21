package nl.graduateproject.localSkill.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.item.Item;
import nl.graduateproject.localSkill.model.Message;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
//        (uniqueConstraints = {
//        @UniqueConstraint(columnNames = "username"),
//        @UniqueConstraint(columnNames = "email")
//})
public class Customer {


    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
//    private long id;

    @Column
//    @NotBlank
    @Size(max = 20)
    private String username;

//    @Column
    private String firstName;

//    @Column
    private String lastName;

    @Column
//    @NotBlank
    @Size(max = 50)
//    @Email
    private String email;

//    @Column
//    @NotBlank
    private String areaCode;

//    @Column
    private String city;

    @Column
//    @NotBlank
    @Size(max = 120)
    private String password;


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
            ,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("customer")
    private List<Invoice>invoices = new ArrayList<>();


    @ManyToMany
    @JoinTable (name = "customer_role",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public Customer(@Size(max = 20) String username, @Size(max = 50) String email, @Size(max = 120) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}


