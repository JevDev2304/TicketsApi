package com.ticketsapi.ticketsapi.persistence.mapper;


import com.ticketsapi.ticketsapi.domain.PurchaseD;
import com.ticketsapi.ticketsapi.persistence.entity.Customer;
import com.ticketsapi.ticketsapi.persistence.entity.Purchase;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source="purchaseId", target="purchaseIdD"),
            @Mapping(source="customerId", target="customerIdD"),
            @Mapping(source="date", target="dateD"),
            @Mapping(source="paymentMethod", target="paymentMethodD"),
            @Mapping(source="lastFourDigits", target="lastFourDigitsD"),
            @Mapping(source="paymentValue", target="paymentValueD"),
            @Mapping(source="nameInBill", target="nameInBillD"),
            @Mapping(source="customer", target="customerD"),

    })
    PurchaseD toPurchaseDomain(Purchase purchase);
    List<PurchaseD> toPurchaseDomainList(List<Purchase> products);
    @InheritInverseConfiguration
    Purchase toPurchase(PurchaseD purchaseD);

}











