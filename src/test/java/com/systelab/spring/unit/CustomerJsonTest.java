package com.systelab.spring.unit;


import com.systelab.spring.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@JsonTest
@ExtendWith(SpringExtension.class)
public class CustomerJsonTest {

    @Autowired
    private JacksonTester<Customer> json;

    @Test
    public void serializeToJson() throws Exception {
        Customer customer=Customer.of("Ray","Tsang");
        Assertions.assertEquals(this.json.write(customer).getJson(),"{\"id\":null,\"firstName\":\"Ray\",\"lastName\":\"Tsang\",\"email\":null}");
    }

    @Test
    public void deserializeJson() throws Exception {
        String content="{\"id\":null,\"firstName\":\"Ray\",\"lastName\":\"Tsang\",\"email\":null}";
        Assertions.assertEquals(this.json.parseObject(content).getFirstName(),"Ray");
        Assertions.assertEquals(this.json.parseObject(content).getLastName(),"Tsang");
    }
}
