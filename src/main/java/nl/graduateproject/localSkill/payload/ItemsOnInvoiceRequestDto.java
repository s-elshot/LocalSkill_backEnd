package nl.graduateproject.localSkill.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.item.ItemType;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsOnInvoiceRequestDto {


//    private Long id;
//    private int quantity;
//    private double totalPrice;
//    private Invoice invoice;
//    private Item item;

    private Long id;
    private String name;
    private double price;
    private String description;
    private int number;
    private int count;
    private ItemType itemType;



//    private Long id;
//    private String name;
//    private double price;
//    private String description;
//    private int number;
//    private int count;
//    private ItemType itemType;
}
