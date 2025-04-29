package com.ticketsapi.ticketsapi.domain.repository;

import com.ticketsapi.ticketsapi.domain.CustomerD;

import java.util.List;
import java.util.Optional;

public interface CustomerDRepository {
    List<CustomerD> getAll();
    List<CustomerD> getByName(String nameD);
    Optional<CustomerD> getCustomer(String idD);
    public CustomerD save(CustomerD customerD);
    public void delete(String idD);

}
