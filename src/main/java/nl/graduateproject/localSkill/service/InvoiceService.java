package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Invoice;

import java.util.Collection;
import java.util.Optional;

public interface InvoiceService {

    public abstract long createInvoice(Invoice invoice);

    public abstract void updateInvoice(long id, Invoice invoice);

    public abstract void deleteInvoice(long id);

    public abstract Collection<Invoice> getInvoices();

    public abstract Optional<Invoice> getInvoiceById(long id);

    public abstract boolean invoiceExistsById(long id);

}