package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.util.StringUtils;
import database.dao.CustomerDao;
import database.dao.CustomerDaoImpl;
import database.model.Customer;
import database.repository.CustomerRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseSteps {
    public static final String SELECT_FROM_CUSTOMER = "Select * from customer";

    @Autowired
    private DataSource dataSource;

    @Given("I select something from the database using Java JDBC")
    public void iSelectSomethingFromTheDatabaseUsingJavaJDBC() {
        List<Customer> customers = getCustomersUsingJavaJdbc();
        Assert.assertEquals(1, customers.size());
        System.out.println(customers);
    }

    private List<Customer> getCustomersUsingJavaJdbc() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setEmail(resultSet.getString("EMAIL"));
                customer.setName(resultSet.getString("NAME"));
                customer.setStatus(resultSet.getInt("STATUS"));
                customer.setId(resultSet.getInt("ID"));
                customers.add(customer);
            }

            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Query has failed miserably." + SELECT_FROM_CUSTOMER, e);
        }
    }

    @Autowired
    private CustomerDao customerDao;

    @And("I select from database using Spring JDBC Template")
    public void iSelectFromDatabaseUsingSpringJDBCTemplate() {
        List<Customer> customers = customerDao.getCustomers();
        Assert.assertEquals(1, customers.size());
        System.out.println(customers);
    }

    @When("I select an user with email {string} using Spring JDBC Template")
    public void iSelectAnUserWithEmailUsingSpringJDBCTemplate(String email) {
        Customer customerWithEmail = customerDao.getCustomerWithEmail(email);
        Assert.assertEquals("Jannet", customerWithEmail.getName());
        System.out.println(customerWithEmail);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @And("I select an user via Spring Data JPA")
    public void iSelectAnUserViaSpringDataJPA() {
        Iterable<Customer> customers = customerRepository.findAll();
        Assert.assertEquals(1, ((Collection) customers).size());
        Assert.assertEquals(1, customerRepository.count());
    }

    @When("I select an user with email {string} using Spring Data JPA")
    public void iSelectAnUserWithEmailUsingSpringDataJPA(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email);
        Assert.assertEquals("Jannet", customer.getName());
    }

    @And("I add a new user with")
    public void iAddANewUserWith(DataTable dataTable) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> maps = dataTable.asMaps();

//        maps.forEach(map1 -> {
//            Customer customer = objectMapper.convertValue(map1, Customer.class);
//            customerRepository.save(customer);
//        });

        maps.stream()
                .map(map -> objectMapper.convertValue(map, Customer.class))
                .forEach(e -> {
                    e.setEmail(e.getName() + new Random().nextInt(100));
                    customerRepository.save(e);
                });
    }

    @Then("I check that there are {int} customers in the database")
    public void iCheckThatThereAreCustomersInTheDatabase(int expectedNumberOfCustomers) {
        Assert.assertEquals(expectedNumberOfCustomers, customerRepository.count());
    }
}
