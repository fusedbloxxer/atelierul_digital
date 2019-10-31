package database.repository;

import database.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Spring webflux mysql reactive - r2dbc client
    // OK
    @Query(value = "select * from customer where email = ?1", nativeQuery = true)
    Customer findCustomerByEmail(String email);
}
