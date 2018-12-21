package com.spring;

import com.spring.repository.CustomerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.reset;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//We don't want full application web server to be initialized for this test, since we will only be
//interacting with the repository object, without making calls to controllers or using any part of the WebMvc stack
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MockCustomerRepositoryTests {

    //Instructs Spring that this dependency is not a real instance, but a mock object currently backed by the Mockito framework
    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void setUpCustomerRepoMockData(){
        given(customerRepository.count()).willReturn(5L);
    }

    @Test
    public void customerExists(){
        assertThat(customerRepository.count()).isEqualTo(5L);
    }

    @After
    public void resetCustomerRepo(){
        reset(customerRepository);
    }
}
