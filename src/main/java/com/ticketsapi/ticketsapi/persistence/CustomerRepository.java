package com.ticketsapi.ticketsapi.persistence;

import com.ticketsapi.ticketsapi.persistence.crud.CustomerCrudRepository;
import com.ticketsapi.ticketsapi.persistence.entity.Customer;

import java.util.List;

public class CustomerRepository {
    private CustomerCrudRepository customerCrudRepository;
    public List<Customer> getAll(){
        return (List<Customer>)customerCrudRepository.findAll();
    }
}
