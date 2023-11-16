package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Entity.Customer;
import com.youcode.marjanv2.Repositories.CustomerRepository;
import com.youcode.marjanv2.Exceptions.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        log.info("getAllCustomers was called");
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
        ResponseEntity.status(HttpStatus.OK).body("Customer created successfully");
    }

    public void deleteCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(id);
            ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
        } else {
            throw new CustomException("Customer with ID " + id + " not found");
        }
    }

    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            throw new CustomException("Customer with ID " + customerId + " not found");
        }
    }
}
