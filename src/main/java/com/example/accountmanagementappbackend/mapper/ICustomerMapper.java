package com.example.accountmanagementappbackend.mapper;

import com.example.accountmanagementappbackend.dtos.CustomerDTO;
import com.example.accountmanagementappbackend.entites.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service

public class ICustomerMapper {

    public CustomerDTO fromCustomerToCustomerDTO(Customer customer)
    {
        CustomerDTO customerDTO=new CustomerDTO();
        //copy properties from bean to another
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }
}
