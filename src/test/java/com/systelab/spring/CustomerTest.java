package com.systelab.spring;

import com.systelab.spring.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void creation() {
        Customer customer=Customer.of("Venkat", "Subramaniam");

        Assertions.assertThat(customer.getFirstName()).isEqualTo("Venkat");
        Assertions.assertThat(customer.getLastName()).isEqualTo("Subramaniam");
    }
}
