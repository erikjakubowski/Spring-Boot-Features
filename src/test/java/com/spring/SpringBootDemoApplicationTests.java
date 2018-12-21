package com.spring;

import com.spring.entity.Customer;
import com.spring.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import javax.sql.DataSource;

//JUnit standard with Spring flavor
@RunWith(SpringRunner.class)
//Use a real, running service instance and will require a complete context initialization and application startup.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//replaces setLoadDataFixures method. Won't have to execute sql for each test
@Transactional
@Sql(scripts = "classpath:/test-data.sql")
public class SpringBootDemoApplicationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DataSource dataSource;

    @LocalServerPort
    private int port;

    private MockMvc mockMvc;

    private static boolean loadDataFixures = true;


    @Before
    public void setUpMock(){
        mockMvc = webAppContextSetup(context).build();
    }

//    uncomment annotations to use
//    @Before
//    public void setLoadDataFixures(){
//        if (loadDataFixures){
//            ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(context.getResource("classpath:/test-data.sql"));
//            DatabasePopulatorUtils.execute(databasePopulator, dataSource);
//            loadDataFixures =false;
//        }
//    }

    @Test
    public void contextLoad(){
        //Assert that we have the Repository connection established and that it contains one entry

        //assertEquals(1, customerRepository.count());

        //if we initialize loadDataFixures to true
        assertEquals(2, customerRepository.count());
    }

    @Test
    public void webAppCustomerNameInApi(){
        //use the instance of TestRestTemplate and make a RESTful call to the running instance on a randomly-selected port
        Customer customer =
                testRestTemplate.getForObject("/v1/customer/ErikDelJaku-Mr-Erik-Del-Jaku-Sr", Customer.class);
        assertNotNull(customer);
        assertEquals("334-22-3421", customer.getSsn());

    }

    @Test
    public void webappPublisherApi() throws Exception {
        //MockMvc provides us with a very extensive set of capabilities in order to execute assertions
        //on practically all the things that are related to a web request.
//        mockMvc.perform(get("/v1/customer")).
//                andExpect(status().isOk()).andExpect(content().
//                contentType(MediaType.parseMediaType
//                        ("application/json;charset=UTF-8"))).
//                andExpect(content().
//                        string(containsString("ErikDelJaku-Mr-Erik-Del-Jaku-Sr"))).
//                andExpect(jsonPath("$[0].customerName").value("ErikDelJaku-Mr-Erik-Del-Jaku-Sr"));


        //if we initialize loadDataFixures to true
        mockMvc.perform(get("/v1/customer")).
                andExpect(status().isOk()).andExpect(content().
                contentType(MediaType.parseMediaType
                        ("application/json;charset=UTF-8"))).
                andExpect(content().
                        string(containsString("TEST NAME"))).
                andExpect(jsonPath("$[1].customerName").value("TEST NAME"));
    }

}
