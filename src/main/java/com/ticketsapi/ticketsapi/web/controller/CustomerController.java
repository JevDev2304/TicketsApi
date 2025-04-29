package com.ticketsapi.ticketsapi.web.controller;

import com.ticketsapi.ticketsapi.domain.CustomerD;
import com.ticketsapi.ticketsapi.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerD>> getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerD> getCustomer(@PathVariable("customerId") String id){
        return customerService.getCustomer(id).map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/name/{customerName}")
    public ResponseEntity<List<CustomerD>> getByName(@PathVariable("customerName") String name) {
        return new ResponseEntity<>(customerService.getByName(name), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<CustomerD> save(@RequestBody CustomerD customerD){
        return new ResponseEntity<>(customerService.save(customerD),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        if (customerService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
