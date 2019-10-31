package database.dao;

import database.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    public static final String SELECT_FROM_CUSTOMER_WHERE_EMAIL_S = "SELECT * FROM customer WHERE email = \'%s\'";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getCustomers() {
        return jdbcTemplate.query("SELECT * from customer",
                BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public Customer getCustomerWithEmail(String email) {
        return jdbcTemplate.queryForObject(String.format(SELECT_FROM_CUSTOMER_WHERE_EMAIL_S, email),
                BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public void removeCustomer(String name) {

    }
}
