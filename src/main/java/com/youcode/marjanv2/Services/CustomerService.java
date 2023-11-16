package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Customer;
import com.youcode.marjanv2.Repositories.CustomerRepository;
import com.youcode.marjanv2.Services.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
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
