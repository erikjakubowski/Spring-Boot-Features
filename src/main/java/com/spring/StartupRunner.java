package com.spring;


import com.spring.entity.Billing;
import com.spring.entity.Customer;
import com.spring.entity.Supplies;
import com.spring.repository.BillingRepository;
import com.spring.repository.CustomerRepository;
import com.spring.repository.SuppliesRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Command-line runners are a useful functionality to execute the various types of code that only have to be run once, after startup.
 *
 */

@Order(Ordered.LOWEST_PRECEDENCE - 15)
public class StartupRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    BillingRepository billingRepository;

    @Autowired
    SuppliesRepository suppliesRepository;

    @Override
    public void run(String... args) {
//
//        Billing billing = new Billing("fistt street", "MN");
//        billing = billingRepository.save(billing);
//
//        Supplies supplies = new Supplies("P-SDF","Product for sales");
//        supplies = suppliesRepository.save(supplies);
//
//        Customer customer = new Customer("ErikDelJaku-Mr-Erik-Del-Jaku-Sr", "334-22-3421", billing, supplies);
//
//        customerRepo.save(customer);

//
//        logger.info("Startup Runner is run....ning \n and the customer count " + customerRepo.count());
    }

//    @Scheduled(initialDelay = 100, fixedRate = 1000)
//    public void run() {
//        logger.info("Number of customers: " + customerRepo.count());
//    }
}