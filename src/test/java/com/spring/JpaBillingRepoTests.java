package com.spring;

import com.spring.entity.Billing;
import com.spring.repository.BillingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaBillingRepoTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BillingRepository billingRepository;

    @Test
    public void testBillingEntity(){
        Long id = testEntityManager.persistAndGetId(createBilling(), Long.class);
        Billing billing = billingRepository.findById(id).get();

        assertThat(billing.getStreetName()).isEqualTo("entity street");
        assertThat(billing.getState()).isEqualToIgnoringCase("ENTITY STATE");
    }

    private Billing createBilling(){
        return new Billing("entity street", "entity state");
    }
}
