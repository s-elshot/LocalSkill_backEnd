package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.ItemsOnInvoice;

import java.util.Collection;
import java.util.Optional;

public interface ItemsOnInvoiceService {


    public Collection<ItemsOnInvoice> getItemsOnInvoices();

    public Optional<ItemsOnInvoice> getItemsOnInvoiceById(long id);

    public boolean ItemsOnInvoiceExistsById(long id);

    public long createItemsOnInvoice(ItemsOnInvoice itemsOnInvoice);

    public void deleteItemsOnInvoice(long id);

    public void updateItemsOnInvoice(long id, ItemsOnInvoice itemsOnInvoice);


}
