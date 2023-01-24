package com.example.accountmanagementappbackend.controller;

import com.example.accountmanagementappbackend.dtos.CustomerDTO;
import com.example.accountmanagementappbackend.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * CustomerController class : in this class there is a Customer Api wich will return a list of customers
 */
@CrossOrigin(origins = "*")
@Api(description = "Consume the Account Management web service Customer API")
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @ApiOperation(value = "This method allows to show all customers", response = CustomerDTO.class)
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers()  {
        logger.info(" ==> getAllCustomers In");
        return ResponseEntity.ok(customerService.listOfCustomers());
    }
}
