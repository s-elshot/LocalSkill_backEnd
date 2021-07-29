package nl.graduateproject.localSkill.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.graduateproject.localSkill.model.ItemOnInvoice;
import nl.graduateproject.localSkill.model.Message;
import nl.graduateproject.localSkill.model.customer.Customer;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class InvoiceRequestDto {

//    private long id;
    private String description;
    private Double totalPrice;
    private Customer customer;
    private Message message;
    private List<ItemsOnInvoiceRequestDto> itemsOnInvoice = new ArrayList<>();
}
