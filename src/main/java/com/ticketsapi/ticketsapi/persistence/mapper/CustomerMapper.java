package com.ticketsapi.ticketsapi.persistence.mapper;

import com.ticketsapi.ticketsapi.domain.CustomerD;
import com.ticketsapi.ticketsapi.persistence.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id", target = "idD"),
            @Mapping(source = "name", target = "nameD"),
            @Mapping(source = "lastName", target = "lastNameD"),
            @Mapping(source = "cellPhone", target = "cellPhoneD"),
            @Mapping(source = "address", target = "addressD"),
            @Mapping(source = "mail", target = "mailD"),
            @Mapping(source = "password", target = "passwordD"),
            @Mapping(source = "profilePicture", target = "profilePictureD")
    })
    CustomerD toCustomerDomain(Customer customer);

    List<CustomerD> toCustomerDomainList(List<Customer> customers);

    @InheritInverseConfiguration
    @Mapping(target = "purchases", ignore = true)  // Ignorar la propiedad purchases
    Customer toCustomer(CustomerD customerD);
}
