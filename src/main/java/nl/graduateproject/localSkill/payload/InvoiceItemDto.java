package nl.graduateproject.localSkill.payload;

import lombok.Data;
import lombok.ToString;
import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.model.item.Item;

@Data
@ToString
public class InvoiceItemDto {

    private Long id;
    private int quantity;
    private double totalPrice;
    private Invoice invoice;
    private Item item;

    public InvoiceItemDto(int quantity, double totalPrice, Invoice invoice, Item item) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.invoice = invoice;
        this.item = item;
    }
}
