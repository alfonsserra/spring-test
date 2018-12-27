package com.systelab.spring.unit;

import com.systelab.spring.model.Customer;
import com.systelab.spring.service.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

        List<Customer> customersOrderByName = this.repository.findSorted();

        Assertions.assertEquals(customersOrderByName.size(), 2);
        Assertions.assertEquals(customersOrderByName.get(0).getFirstName(), "Mark");
        Assertions.assertEquals(customersOrderByName.get(1).getFirstName(), "Venkat");
    }
}
