package com.inqoo.TavelOfficeWeb.repository;

import com.inqoo.TavelOfficeWeb.model.Customer;
import com.inqoo.TavelOfficeWeb.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo {

    private static final List<Customer> customers = new ArrayList<>(); // dane
    @Autowired
    private TripRepo tripRepo;

    public static Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    } // logikę biznesową

    public static List<Customer> findAll() {
        return customers;
    }

    public static List<Customer> findAllByAddress(String address) {
        return customers.stream().filter(e -> address.equals(e.getAddress())).toList();
    }

    @PostConstruct
    public void createCustomer() {
        Customer cus1 = new Customer();
        cus1.setId(1);
        cus1.setFirstnameLastname("Jan Kowalski");
        cus1.setAddress("Opole, ul. Niemodlińska 21");
        cus1.setTrip(new Trip(LocalDate.of(2022, 12, 12), LocalDate.of(2022, 12, 17), "London", 3500.0));    //////////////////////dopisać wycieczkiiii!!!!!

        Customer cus2 = new Customer();
        cus1.setId(2);
        cus2.setFirstnameLastname("Jan Nowak");
        cus2.setAddress("Opole, ul. Niemodlińska 22");

        Customer cus3 = new Customer();
        cus1.setId(3);
        cus3.setFirstnameLastname("Jan Dąbrowski");
        cus3.setAddress("Opole, ul. Niemodlińska 23");

        Customer cus4 = new Customer();
        cus1.setId(4);
        cus4.setFirstnameLastname("Jan Kowalski");
        cus4.setAddress("Opole, ul. Niemodlińska 21");

        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);
        customers.add(cus4);
    }
}
