package nl.graduateproject.localSkill.service;


//import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;
import nl.graduateproject.localSkill.exceptions.UsernameNotFoundException;
import nl.graduateproject.localSkill.model.authority.Authority;
import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import nl.graduateproject.localSkill.repository.CustomerRepository;
import nl.graduateproject.localSkill.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class CustomerServiceImpl implements CustomerService {

    // create a has-a relationship with Customer-repository
    // implement the service-methods
    // specify all the methods that you can use in your application

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Collection<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerByUsername(String username) {
        if (!customerRepository.existsById(username)) throw new RecordNotFoundException();
        return customerRepository.findById(username);
    }



    @Override
    public String createCustomer(Customer customer) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        customer.setApikey(randomString);
//        customer.setAuthorities("ROLE_USER");
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getUsername();
    }

    @Override
    public void updateCustomer(String username, Customer newCustomer) {
        if (!customerRepository.existsById(username)) throw new RecordNotFoundException();
        Customer customer = customerRepository.findById(username).get();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setEmail(newCustomer.getEmail());
        customer.setAreaCode(newCustomer.getAreaCode());
        customer.setCity(newCustomer.getCity());
        customer.setPassword(newCustomer.getPassword());
        customer.setEnabled(newCustomer.isEnabled());
        customer.setApikey(newCustomer.getApikey());
        customer.setCustomerGuild(newCustomer.getCustomerGuild());
        customer.setUserRole(newCustomer.getUserRole());
        customer.setAuthorities(newCustomer.getAuthorities());
//        customer.setItems(newCustomer.getItems());
//        customer.setMessages(newCustomer.getMessages());
//        customer.setInvoices(newCustomer.getInvoices());
        customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(String username) {
        if (!customerRepository.existsById(username)) throw new RecordNotFoundException();
        customerRepository.deleteById(username);
    }

    @Override
    public List<Customer> findAllByAreaCodeEquals(String areaCode) {
        return (List<Customer>) customerRepository.findAllByAreaCode(areaCode);
    }



    @Override
    public Collection<Customer> findByUserRoleEquals (CustomerType userRole){
     return (List<Customer>) customerRepository.findByUserRoleEquals(userRole);
    }

    @Override
    public Collection<Customer> findByCustomerGuildEquals(CustomerGuild customerGuild) {
        return (List<Customer>) customerRepository.findByCustomerGuildEquals(customerGuild);
    }

    @Override
    public boolean customerExistsById(String username) {
        return customerRepository.existsById(username);
    }


    @Override
    public Set<Authority> getAuthorities(String username) {
        if (!customerRepository.existsById(username)) throw new UsernameNotFoundException(username);
        Customer customer = customerRepository.findById(username).get();
        return customer.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        if (!customerRepository.existsById(username)) throw new UsernameNotFoundException(username);
        Customer customer = customerRepository.findById(username).get();
        customer.addAuthority(new Authority(username, authority));
        customerRepository.save(customer);
    }

    @Override
    public void removeAuthority(String userName, String authority) {

    }



}
