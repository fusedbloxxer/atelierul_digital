package database.dao;

import database.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
    List<Customer> getCustomers();

    Customer getCustomerWithEmail(String email);

    void removeCustomer(String name);
}
