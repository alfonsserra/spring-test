package com.systelab.spring.unit;

import com.systelab.spring.controller.CustomerController;
import com.systelab.spring.model.Customer;
import com.systelab.spring.service.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.Collections;

@RestClientTest({CustomerController.class})
@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testService() {

        Mockito.when(this.customerRepository.findAll()).thenReturn(Collections.singletonList(Customer.of("Mark", "Reinhold")));
        this.customerController.getAllCustomers().getBody().forEach((c)-> System.out.println(c.getFirstName()));
    }
}
