package nl.graduateproject.localSkill.payload;

import lombok.Data;

@Data
public class ItemsOnInvoiceRequestDto {
    private Long id;
    private String name;
    private double price;
    private String description;
    private int number;
    private int amount;
    private int count;
}
