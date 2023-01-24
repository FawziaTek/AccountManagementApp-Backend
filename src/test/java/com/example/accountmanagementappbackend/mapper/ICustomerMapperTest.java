package com.example.accountmanagementappbackend.mapper;

import com.example.accountmanagementappbackend.dtos.CustomerDTO;
import com.example.accountmanagementappbackend.entites.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ICustomerMapperTest {

    @InjectMocks
    private ICustomerMapper testee;

    @Test
    void fromCustomerToCustomerDTO() {
        Customer customer = new Customer(1L, "ahmed", "louna", new ArrayList<>());

        CustomerDTO result = testee.fromCustomerToCustomerDTO(customer);

        assertEquals(customer.getCustomerId(), result.getCustomerId());
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getSurname(), result.getSurname());
    }
}