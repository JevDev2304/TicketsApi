package com.ticketsapi.ticketsapi.persistence.crud;

import com.ticketsapi.ticketsapi.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<Customer,String> {
    @Query(value ="SELECT * FROM clientes WHERE nombre = ? ORDER BY nombre ASC", nativeQuery = true)
    List<Customer> getByName(String name);
}
