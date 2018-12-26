package com.systelab.spring;

import com.systelab.spring.model.Customer;
import com.systelab.spring.service.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void findSorted() {
        this.repository.save(Customer.of("Venkat", "Subramaniam"));
        this.repository.save(Customer.of("Mark", "Reinhold"));

        List<Customer> customersOrderByName=this.repository.findSorted();

        Assertions.assertThat(customersOrderByName.size()).isEqualTo(2);
        Assertions.assertThat(customersOrderByName.get(0).getFirstName()).isEqualTo("Mark");
        Assertions.assertThat(customersOrderByName.get(1).getFirstName()).isEqualTo("Venkat");
    }
}
