package nl.graduateproject.localSkill.repository;

import nl.graduateproject.localSkill.model.Customer;
import nl.graduateproject.localSkill.model.CustomerType;
import nl.graduateproject.localSkill.model.TestKlasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Collection<Customer> findAllByAreaCode(String areaCode);

    public Collection<Customer> findByUserRoleEquals(CustomerType userRole);

    public Collection<Customer> findByGuildEquals(String guild);

    // handles or translates the sql/database requests
    // query - defines methods that can be used in the controller-class


}

