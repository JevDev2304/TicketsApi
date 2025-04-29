package com.ticketsapi.ticketsapi.domain.service;

import com.ticketsapi.ticketsapi.domain.CustomerD;
import com.ticketsapi.ticketsapi.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerD> getAll(){
        return customerRepository.getAll();
    }
    public Optional<CustomerD> getCustomer(String id){
        return customerRepository.getCustomer(id);
    }
    public List<CustomerD> getByName(String name) {
        return customerRepository.getByName(name);
    }

    public CustomerD save(CustomerD customerD){
        return customerRepository.save(customerD);
    }

    public boolean delete(String id){
        return getCustomer(id).map(customer -> {
            customerRepository.delete(id);
        return true;}).orElse(false);
    }


}
