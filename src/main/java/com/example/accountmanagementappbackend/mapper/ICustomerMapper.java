package com.example.accountmanagementappbackend.mapper;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * ICustomerMapper class : in this class we will convert Object Customer to CustomerDTO
 **/
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
