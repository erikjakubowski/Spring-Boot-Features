package com.spring;


import com.spring.entity.Customer;
import com.spring.repository.CustomerRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = SpringBootDemoApplication.class,
        loader = SpringBootContextLoader.class)
public class RepositoryStepdefs {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private DataSource ds;
    @Autowired
    private CustomerRepository customerRepository;


    private Customer customer;

    @Given("^([^\\\"]*) fixture is loaded$")
    public void data_fixture_is_loaded(String fixtureName)
            throws Throwable {
        ResourceDatabasePopulator populator
                = new ResourceDatabasePopulator
                (context.getResource("classpath:/" + fixtureName + ".sql"));
        DatabasePopulatorUtils.execute(populator, ds);
    }

    @Given("^(\\d+) customers available$")
    public void customers_availabl(int customerCount)
            throws Throwable {
        assertEquals(customerCount, customerRepository.count());
    }

    @When("^searching for customer by name ([^\"]*)$")
    public void searching_for_customer_by_name(String name)
            throws Throwable {
        customer = customerRepository.findByCustomerName(name);
        assertNotNull(customer);
        assertEquals(name, customer.getCustomerName());
    }

    @Then("^customer ssn will be ([\\d-]+)$")
    public void book_title_will_be(String ssn) throws Throwable {
        assertNotNull(customer);
        assertEquals(ssn, customer.getSsn());
    }

}
