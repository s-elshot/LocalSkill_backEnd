package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.ItemOnInvoice;

import java.util.Collection;
import java.util.Optional;

public interface ItemsOnInvoiceService {


    public Collection<ItemOnInvoice> getItemsOnInvoices();

    public Optional<ItemOnInvoice> getItemsOnInvoiceById(long id);

    public void addItemOnInvoice(ItemOnInvoice itemOnInvoice);

    public boolean ItemsOnInvoiceExistsById(long id);

    public long createItemsOnInvoice(ItemOnInvoice itemOnInvoice);

    public void deleteItemsOnInvoice(long id);

    public void updateItemsOnInvoice(long id, ItemOnInvoice itemOnInvoice);


}
