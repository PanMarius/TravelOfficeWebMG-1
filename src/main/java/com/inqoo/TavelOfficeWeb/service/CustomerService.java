package com.inqoo.TavelOfficeWeb.service;

import com.inqoo.TavelOfficeWeb.model.Customer;
import com.inqoo.TavelOfficeWeb.model.exception.NoFirstLastNameExceptionFound;
import com.inqoo.TavelOfficeWeb.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer) {
        return CustomerRepo.save(customer);
    }

    public List<Customer> getAllCustomers(String customerName, String customerAddress, Boolean withTrip) throws NoFirstLastNameExceptionFound {
        List<Customer> result = CustomerRepo.findAll();
        if (!Objects.isNull(customerName)) {
            result = result.stream()
                    // results filtered by customer name
                    .filter(c -> c.getFirstnameLastname().contains(customerName))
                    .collect(Collectors.toList());
            if (result.isEmpty())
                throw new NoFirstLastNameExceptionFound("Brak wyników wyszukiwania dla podanego kryterium" + customerName);
            if (!Objects.isNull(customerAddress)) {
                result = result.stream()
                        // results filtered by customer address
                        .filter(c -> c.getAddress().contains(customerAddress))
                        .collect(Collectors.toList());
                if (!Objects.isNull(withTrip) && withTrip)
                    result = result.stream()
                            // results filtered by trip - ony the customers who have trips assigned
                            .filter(c -> !Objects.isNull(c.getTrip())) //////////dokończyć filtrowanie !!!!
                            .collect(Collectors.toList());
            }
        }
        return result;
    }

    public Customer getCustomerById(Integer customerId) {
        List<Customer> result = CustomerRepo.findAll();
        if (!Objects.isNull(customerId))
            return result.stream()
                    .filter(c -> c.getId().equals(customerId))
                    .findFirst().orElse(null);
        return null;
    }

    public List<Customer> getAllCustomersByAddress(String customerAddress) {
        List<Customer> result = CustomerRepo.findAll();
        if (!Objects.isNull(customerAddress))
            result = result.stream()
                    .filter(c -> c.getAddress().contains(customerAddress))
                    .collect(Collectors.toList());
        return result;
    }
}