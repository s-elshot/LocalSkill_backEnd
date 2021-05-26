package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.TestKlasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public abstract Collection<Customer> findAllByAreaCode(String areaCode);
    public abstract Optional<Customer>findCustomerById(long id);
    public abstract Collection<Customer> findAllByLastName(String lastName);
    // handles or translates the sql/database requests
    // query - defines methods that can be used in the controller-class




}

