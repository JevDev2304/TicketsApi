package com.ticketsapi.ticketsapi.persistence.crud;

import com.ticketsapi.ticketsapi.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer,String> {
}
