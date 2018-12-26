package com.systelab.spring;

import com.systelab.spring.model.Customer;
import com.systelab.spring.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Initialization...");
        this.customerRepository.save(Customer.of("Josh","Long"));
    }
}