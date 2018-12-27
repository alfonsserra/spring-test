package com.systelab.spring;

import com.systelab.spring.model.Customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CustomerJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping() {
        Customer customer = this.tem.persistFlushFind(Customer.of("Venkat", "Subramaniam"));
        Assertions.assertNotNull(customer.getId());
        Assertions.assertEquals(customer.getFirstName(),"Venkat");
        Assertions.assertEquals(customer.getLastName(),"Subramaniam");
    }
}
