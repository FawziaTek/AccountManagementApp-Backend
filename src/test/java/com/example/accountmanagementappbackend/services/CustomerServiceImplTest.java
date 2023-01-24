package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementappbackend.dtos.CustomerDTO;
import com.example.accountmanagementappbackend.entites.Customer;
import com.example.accountmanagementappbackend.mapper.ICustomerMapper;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl testee;

    @Mock
    private ICustomerMapper iCustomerMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void listOfCustomers() {
        //Give
        List<Customer> customerBEs = new ArrayList<>();
        customerBEs.add(new Customer());
        customerBEs.add(new Customer());
        when(customerRepository.findAll()).thenReturn(customerBEs);
        when(iCustomerMapper.fromCustomerToCustomerDTO(any())).thenReturn(new CustomerDTO());
        //when
        List<CustomerDTO> result = testee.listOfCustomers();
        //then
        assertNotNull(result);
        assertEquals(customerBEs.size(), result.size());
    }
}