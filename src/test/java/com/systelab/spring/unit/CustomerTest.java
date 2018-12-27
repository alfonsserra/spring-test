package com.systelab.spring.unit;

import com.systelab.spring.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void creation() {
        Customer customer = Customer.of("Venkat", "Subramaniam");

        Assertions.assertNull(customer.getId());
        Assertions.assertEquals(customer.getFirstName(), "Venkat");
        Assertions.assertEquals(customer.getLastName(), "Subramaniam");
    }

    @Test
    public void creationWithNullThrowsException() {
        Assertions.assertThrows(NullPointerException.class, () -> Customer.of(null, null));
        Assertions.assertThrows(NullPointerException.class, () -> Customer.of("Venkat", null));
        Assertions.assertThrows(NullPointerException.class, () -> Customer.of(null, "Subramaniam"));

    }
}
