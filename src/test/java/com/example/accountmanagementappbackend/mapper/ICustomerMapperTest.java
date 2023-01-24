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
        Customer customerBE = new Customer(1L, "ahmed", "louna", new ArrayList<>());

        CustomerDTO result = testee.fromCustomerToCustomerDTO(customerBE);

        assertEquals(customerBE.getCustomerId(), result.getCustomerId());
        assertEquals(customerBE.getName(), result.getName());
        assertEquals(customerBE.getSurname(), result.getSurname());
    }
}