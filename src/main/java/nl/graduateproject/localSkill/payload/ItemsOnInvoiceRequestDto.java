package nl.graduateproject.localSkill.payload;

import lombok.Data;

@Data
public class ItemsOnInvoiceRequestDto {
    private Long id;
    private int amount;
    private String name;
    private double price;
    private String description;
}
