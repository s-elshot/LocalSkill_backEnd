package nl.graduateproject.localSkill.service;

import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface CustomerService {



    public String createCustomer(Customer customer);
    public void updateCustomer(String username, Customer customer);
    public  void deleteCustomer(String username);
    public Collection<Customer> getAllCustomers();
    public Optional<Customer> getCustomerByUsername(String username);

//    Collection<Customer> findByGuildEquals(CustomerGuild customerGuild);

    //    public Optional<Customer> loadCustomerByEmail(String email);
    public boolean customerExistsById(String username);

    public abstract Set<Authority> getAuthorities(String username);
    public abstract void addAuthority(String username, String authority);
    public abstract void removeAuthority(String userName, String authority);

    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);
    public List<Customer> findAllByAreaCodeEquals (String areaCode);
    public Collection<Customer> findByCustomerGuildEquals(CustomerGuild customerGuild);



}
