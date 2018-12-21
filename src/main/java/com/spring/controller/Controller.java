package com.spring.controller;

import com.spring.editors.NameEditor;
import com.spring.entity.Billing;
import com.spring.entity.Customer;
import com.spring.model.Name;
import com.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class Controller {


    @Autowired
    private CustomerRepository customerRepo;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Iterable<Customer> getAllCustomers() {

        return customerRepo.findAll();
    }


    @GetMapping("/customer/{name}")
    public Customer getName(@PathVariable String name){
        return customerRepo.findByCustomerName(name);
    }



    /**
     * This annotation is scanned and all the detected methods should have a signature of accepting WebDataBinder as an argument.
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Name.class, new NameEditor());
    }



    //more dynamic using the complete object for path retrieval instead of string
    @GetMapping("/customer/editor/{name}")
    public Customer getEditCustomer(@PathVariable Name name){
        return customerRepo.findByCustomerName(name.toString());
    }


    //get billing based on Customer Entity
    @GetMapping("/{name}/billing")
    public Billing getBilling(@PathVariable("name") Customer customer) {
        return customer.getBilling();
    }

    /*
    Session id
     */
    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }


}
