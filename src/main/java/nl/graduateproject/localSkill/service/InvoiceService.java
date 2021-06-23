package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Invoice;
import nl.graduateproject.localSkill.payload.InvoiceRequestDto;

import java.util.Collection;
import java.util.Optional;

public interface InvoiceService {

    public long createInvoice(InvoiceRequestDto invoiceRequestDto);

    public void updateInvoice(long id, Invoice invoice);

    public void deleteInvoice(long id);

    public Collection<Invoice> getInvoices();

    public Optional<Invoice> getInvoiceById(long id);

    public boolean invoiceExistsById(long id);

}