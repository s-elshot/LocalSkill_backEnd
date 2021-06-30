package nl.graduateproject.localSkill.payload;

import lombok.Data;
import nl.graduateproject.localSkill.model.Message;
import nl.graduateproject.localSkill.model.customer.Customer;

import java.util.ArrayList;
import java.util.List;

@Data
public class InvoiceRequestDto {

    private String description;
    private Customer customer;
    private Message message;
    private List<ItemsOnInvoiceRequestDto> itemsOnInvoices = new ArrayList<>();

}
