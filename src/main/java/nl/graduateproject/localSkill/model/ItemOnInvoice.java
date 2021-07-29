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

//    @Column
//    private Long itemId;

    @Column
    private int quantity;

    @Column
    private double totalPrice;

//    @Column
//    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Item item;

//    public ItemOnInvoice(Long invoiceId, Long item_id, int quantity, double totalPrice) {
//        this.itemId = item_id;
//        this.quantity = quantity;
//        this.totalPrice = totalPrice;
//        this.invoiceId = invoiceId;
//    }

}

