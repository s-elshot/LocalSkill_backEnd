package nl.graduateproject.localSkill.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.item.Item;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table
public class
ItemOnInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    @Column
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Item item;

    public ItemOnInvoice(int quantity, double totalPrice, Invoice invoice, Item item) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.invoice = invoice;
        this.item = item;
    }

}

