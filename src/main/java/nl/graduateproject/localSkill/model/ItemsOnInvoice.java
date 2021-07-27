package nl.graduateproject.localSkill.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table
public class
ItemsOnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int amount;

    @ManyToOne
    @JsonIgnoreProperties("itemsOnInvoice")
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}

