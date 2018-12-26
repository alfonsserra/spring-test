package com.systelab.spring.service;

import com.systelab.spring.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    @Query("select c from Customer c order by  c.firstName")
    List<Customer> findSorted();


}
