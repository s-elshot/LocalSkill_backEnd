package nl.graduateproject.localSkill.payload;

import lombok.Data;
import nl.graduateproject.localSkill.model.customer.Customer;

import java.util.ArrayList;
import java.util.List;

@Data
public class InvoiceRequestDto {

    private String description;
    private String customerName;
    private List<ItemsOnInvoiceRequestDto> itemsOnInvoices = new ArrayList<>();

}
