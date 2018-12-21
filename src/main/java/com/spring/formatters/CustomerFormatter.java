package com.spring.formatters;


import com.spring.entity.Customer;
import com.spring.repository.CustomerRepository;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Let's suppose that for our application, we would like to have a formatter that would take,
 * the Name of a Customer in a String form and convert it to a Customer entity object.
 * This way, we can define the controller request methods with a Customer argument when the request URL signature
 * Only contains a Name or a database ID.
 */
public class CustomerFormatter  implements Formatter<Customer> {

    private CustomerRepository customerRepository;

    public CustomerFormatter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer parse(String text, Locale locale) {
        Customer customer = customerRepository.findByCustomerName(text);
        return customer != null ? customer : customerRepository.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(Customer object, Locale locale) {
        return object.getCustomerName();
    }
}
