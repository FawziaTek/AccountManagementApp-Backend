package com.example.accountmanagementappbackend.services;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * CustomerServiceImpl class : we will implement the CustomerService interface
 * <p>
 * in this class we created 1 service
 **/

import com.example.accountmanagementappbackend.dtos.CustomerDTO;
import com.example.accountmanagementappbackend.entites.Customer;
import com.example.accountmanagementappbackend.mapper.ICustomerMapper;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
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

    /***
     * listOfCustomers Service : in this service we will return all customers
     *
     * Inpout:
     * Output:List<CustomerDTO>
     *
     *
     * **/
    public List<CustomerDTO> listOfCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customer -> iCustomerMapper.fromCustomerToCustomerDTO(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }

}
