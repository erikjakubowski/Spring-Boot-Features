package com.spring;

import com.spring.entity.Billing;
import com.spring.entity.Customer;
import com.spring.entity.Supplies;
import com.spring.repository.BillingRepository;
import com.spring.repository.CustomerRepository;
import com.spring.repository.SuppliesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *
 * Unlike @DataJpaTest, this time there are no database components that are provided for us,
 * but instead we get the WebMvc and MockMvc configurations, which bring all the necessary foundations for initializing
 * controllers, filters, interceptors, and so on.
 *
 * For that reason, we had to add AuthorRepository and PublisherRepository as mock beans into our test code,
 * because otherwise the test would fail to start because Spring Boot would be unable to satisfy the bean dependency
 * that the StartupRunner class has on those two repositories.
 * 
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebMvcCustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private BillingRepository billingRepository;

    @MockBean
    private SuppliesRepository suppliesRepository;


    @Test
    public void webApp() throws Exception{

        given(customerRepository.findByCustomerName("Web-Test-Name"))
                .willReturn(new Customer("Web-Test-Name",
                                            "234-54-1234",
                                            new Billing("Web App Street", " web app state"),
                                            new Supplies("WEB-CODE", "Webapp descript")));

        mockMvc.perform(get("/v1/customer/Web-Test-Name"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(content().string(containsString("234-54-1234")))
                .andExpect(jsonPath("$.customerName").value("Web-Test-Name"));

    }
}
