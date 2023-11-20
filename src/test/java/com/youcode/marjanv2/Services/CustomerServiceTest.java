package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Entity.Customer;
import com.youcode.marjanv2.Exceptions.CustomException;
import com.youcode.marjanv2.Repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1L, "John Doe", "john@example.com"),
                new Customer(2L, "Jane Doe", "jane@example.com")
        );
        when(customerRepository.findAll()).thenReturn(mockCustomers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(mockCustomers.size(), result.size());
        assertEquals(mockCustomers, result);
    }

    @Test
    public void testSaveCustomer() {
        Customer customerToSave = new Customer(1L, "John Doe", "john@example.com");

        customerService.saveCustomer(customerToSave);

        verify(customerRepository, times(1)).save(customerToSave);
    }

    @Test
    public void testDeleteCustomerById() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(new Customer()));

        customerService.deleteCustomerById(customerId);

        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
    public void testDeleteNonexistentCustomerById() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> customerService.deleteCustomerById(customerId));
    }

    @Test
    public void testGetCustomerById() {
        Long customerId = 1L;
        Customer mockCustomer = new Customer(customerId, "John Doe", "john@example.com");
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        Customer result = customerService.getCustomerById(customerId);

        assertNotNull(result);
        assertEquals(mockCustomer.getId(), result.getId());
        assertEquals(mockCustomer.getName(), result.getName());
        assertEquals(mockCustomer.getEmail(), result.getEmail());
    }

    @Test
    public void testGetNonexistentCustomerById() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomException.class, () -> customerService.getCustomerById(customerId));
    }
}
