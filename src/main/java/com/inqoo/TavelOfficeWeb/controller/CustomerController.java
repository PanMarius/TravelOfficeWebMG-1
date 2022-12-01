package com.inqoo.TavelOfficeWeb.controller;

import com.inqoo.TavelOfficeWeb.model.Customer;
import com.inqoo.TavelOfficeWeb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping(path = "/search", produces = "application/json")
    public ResponseEntity<List<Customer>> customers(@RequestParam(name = "customerName", required = false) String customerName,
                                                    @RequestParam(name = "customerAddress", required = false) String customerAddress,
                                                    @RequestParam(name = "withTrip", required = false) Boolean withTrip) {
        return ResponseEntity.ok(customerService.getAllCustomers(customerName, customerAddress, withTrip));
    }

    @GetMapping(path = "/customers/{customerId}", produces = "application/json")
    public ResponseEntity<Customer> customerById(@PathVariable("customerId") Integer id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}