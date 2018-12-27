package com.systelab.spring;

import com.systelab.spring.model.Customer;
import com.systelab.spring.service.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void findSorted() {
        this.repository.save(Customer.of("Venkat", "Subramaniam"));
        this.repository.save(Customer.of("Mark", "Reinhold"));

        List<Customer> customersOrderByName=this.repository.findSorted();

        Assertions.assertTrue(customersOrderByName.size()==2);
        Assertions.assertTrue(customersOrderByName.get(0).getFirstName().equals("Mark"));
        Assertions.assertTrue(customersOrderByName.get(1).getFirstName().equals("Venkat"));
    }
}
