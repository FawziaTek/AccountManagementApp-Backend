package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementbackend.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {

   List<CustomerDTO> listOfCustomers();
}
