package nl.graduateproject.localSkill.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
// @NoArgsConstructor: This adds a no-arguments constructor to the class.
// @DATA = LOMBOK = Generates getters and setters
@Entity
@Table
public class ItemsOnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int amount;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}