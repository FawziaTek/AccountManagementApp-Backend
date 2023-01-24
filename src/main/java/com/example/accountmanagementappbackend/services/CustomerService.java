package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementappbackend.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {

   List<CustomerDTO> listOfCustomers();
}
