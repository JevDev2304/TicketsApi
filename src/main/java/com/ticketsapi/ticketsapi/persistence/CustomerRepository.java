package com.ticketsapi.ticketsapi.persistence;

import com.ticketsapi.ticketsapi.domain.CustomerD;
import com.ticketsapi.ticketsapi.domain.repository.CustomerDRepository;
import com.ticketsapi.ticketsapi.persistence.crud.CustomerCrudRepository;
import com.ticketsapi.ticketsapi.persistence.entity.Customer;
import com.ticketsapi.ticketsapi.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerDRepository {
    @Autowired
    private CustomerCrudRepository customerCrudRepository;
    @Autowired
    private CustomerMapper mapper;
    @Override
    public List<CustomerD> getAll(){
        List<Customer> customers = (List<Customer>)customerCrudRepository.findAll();
        return mapper.toCustomerDomainList(customers);
    }
    @Override
    public List<CustomerD> getByName(String name){
        List<Customer> customers =  customerCrudRepository.getByName(name);
        return mapper.toCustomerDomainList(customers);
    }
    @Override
    public Optional<CustomerD> getCustomer(String id){
        return customerCrudRepository.findById(id)
                .map(mapper::toCustomerDomain);
    }

    @Override
    public CustomerD save(CustomerD customerD) {
        Customer mapped_customer = mapper.toCustomer(customerD);
        Customer database_customer = customerCrudRepository.save(mapped_customer);
        return mapper.toCustomerDomain(database_customer);
    }
    @Override
    public void delete(String id){
        customerCrudRepository.deleteById(id);
    }

}
