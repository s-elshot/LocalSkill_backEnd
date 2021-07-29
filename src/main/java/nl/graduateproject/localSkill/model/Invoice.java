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

    // NEWLY ADDED FIELD!!!!!!!!
//    @Column
//    private Long customerId;

    @ManyToOne
    //Added JSONIGNORE
    @JsonIgnoreProperties("invoice")
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Message message;

    @OneToMany(
            mappedBy = "invoice",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties("invoice")
    private List<ItemOnInvoice> itemsOnInvoice = new ArrayList<>();

//    public Invoice(PlaceInvoiceDto orderDto, Long customerId){
//        this.customerId = customerId;
//        this.totalPrice = orderDto.getTotalPrice();
//    }


}
