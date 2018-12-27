package com.systelab.spring;

import com.systelab.spring.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void creation() {
        Customer customer=Customer.of("Venkat", "Subramaniam");

        Assertions.assertTrue(customer.getFirstName().equals("Venkat"));
        Assertions.assertTrue(customer.getLastName().equals("Subramaniam"));
    }
}
