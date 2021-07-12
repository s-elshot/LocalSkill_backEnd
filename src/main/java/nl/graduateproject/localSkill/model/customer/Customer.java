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
@Entity
@Table
public class Customer {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
//            (nullable = false, unique = true)
    private String email;

    @Column
//            (nullable = false)
    private String areaCode;

    @Column
    private String city;

    @Column
//            (nullable = false)
    private String password;


    @Column
//            (nullable = false)
    private boolean enabled;

    @Column
    private String apikey;

    @Enumerated(EnumType.STRING)
    private CustomerGuild customerGuild;

    @Enumerated(EnumType.STRING)
    private CustomerType userRole;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

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

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

}


