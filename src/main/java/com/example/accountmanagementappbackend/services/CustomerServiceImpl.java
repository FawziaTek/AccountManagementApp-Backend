package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementbackend.dtos.CustomerDTO;
import com.example.accountmanagementbackend.entites.Customer;
import com.example.accountmanagementbackend.mapper.ICustomerMapper;
import com.example.accountmanagementbackend.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ICustomerMapper iCustomerMapper;
    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public List<CustomerDTO> listOfCustomers()
    {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS=customers.stream()
                .map(customer -> iCustomerMapper.fromCustomerToCustomerDTO(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }

}
