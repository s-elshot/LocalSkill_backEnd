package nl.graduateproject.localSkill.service;



import nl.graduateproject.localSkill.exceptions.RecordNotFoundException;

import nl.graduateproject.localSkill.model.customer.Customer;
import nl.graduateproject.localSkill.model.customer.CustomerGuild;
import nl.graduateproject.localSkill.model.customer.CustomerType;
import nl.graduateproject.localSkill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }



    @Override
    public long createCustomer(Customer customer) {
        // TESTEN
//        if (Boolean.FALSE.equals(customerRepository.existsByUsername(signUpRequest.getUsername()))) {
            // hernoemen naar customerAuthority
//            Authority newAuthority = new Authority();
//            newAuthority.setUsername(customer.getUsername());
//            newAuthority.setAuthority(CustomerType.CUSTOMER.toString());
//            customer.getAuthorities().add(newAuthority);

            Customer newCustomer = customerRepository.save(customer);
            return newCustomer.getId();
    }



    @Override
    public void updateCustomer(long id, Customer customer) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();;
        Customer existingCustomer = customerRepository.findById(id).get();
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAreaCode(customer.getAreaCode());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setCustomerGuild(customer.getCustomerGuild());
        existingCustomer.setUserRole(customer.getUserRole());

//        customer.setItems(newCustomer.getItems());
//        customer.setMessages(newCustomer.getMessages());
//        customer.setInvoices(newCustomer.getInvoices());
        customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }


//    @Override
//    public void deleteCustomer(long id) {
//        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
//        customerRepository.deleteById(id);
//    }

    @Override
    public List<Customer> findAllByAreaCodeEquals(String areaCode) {
        return (List<Customer>) customerRepository.findAllByAreaCode(areaCode);
    }

    @Override
    public Collection<Customer> findByGuildEquals(String guild) {
        return null;
    }


    @Override
    public Collection<Customer> findByUserRoleEquals (CustomerType userRole){
     return (List<Customer>) customerRepository.findByUserRoleEquals(userRole);
    }


    @Override
    public boolean customerExistsById(long id) {
        return customerRepository.existsById(id);
    }



//    @Override
//    public Set<Authority> getAuthorities(String username) {
//        if (!customerRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        Customer customer = customerRepository.findById(username).get();
//        return customer.getAuthorities();
//    }

//    @Override
//    public void addAuthority(String username, String authority) {
//        if (!customerRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        Customer customer = customerRepository.findById(username).get();
//        customer.addAuthority(new Authority(username, authority));
//        customerRepository.save(customer);
//    }

//    @Override
//    public void removeAuthority(String userName, String authority) {
//
//    }



}
