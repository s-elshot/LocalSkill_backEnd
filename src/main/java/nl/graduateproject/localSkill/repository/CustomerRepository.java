package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public abstract Collection<Customer> findAllByAreaCode(String areaCode);


    public abstract Collection<Customer> findAllByLastName(String lastName);
    // handles or translates the sql/database requests
    // query - defines methods that can be used in the controller-class


}

