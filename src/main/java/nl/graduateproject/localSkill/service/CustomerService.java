package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.Item.Item;
import nl.graduateproject.localSkill.model.user.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerService {

    public abstract Collection<Customer> getCustomersByLastName(String lastName);
    public  abstract Collection<Customer> getCustomersByAreaCode(String areaCode);
    public abstract long createCustomer(Customer customer);

    public abstract void updateCustomer(long id, Customer customer);
    public abstract void deleteCustomer(long id);
    public abstract Collection<Customer> getCustomers(String name, String lastName);
    public abstract Optional<Customer> getCustomerById(long id);
  public abstract boolean customerExistsById(long id);


}
