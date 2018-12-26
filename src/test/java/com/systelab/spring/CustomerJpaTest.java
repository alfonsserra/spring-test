package com.systelab.spring;

import com.systelab.spring.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping() {
        Customer customer=this.tem.persistFlushFind(Customer.of("Venkat", "Subramaniam"));

        Assertions.assertThat(customer.getId()).isGreaterThan(0);
        Assertions.assertThat(customer.getFirstName()).isEqualTo("Venkat");
        Assertions.assertThat(customer.getLastName()).isEqualTo("Subramaniam");
    }
}
