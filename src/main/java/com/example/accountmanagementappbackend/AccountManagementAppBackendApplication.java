package com.example.accountmanagementappbackend;

import com.example.accountmanagementappbackend.entites.Customer;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountManagementAppBackendApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AccountManagementAppBackendApplication.class);
    private final CustomerRepository  customerRepository;

    public AccountManagementAppBackendApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementAppBackendApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        customerRepository.deleteAll();
        customerRepository.save(new Customer("John", "White"));
        customerRepository.save(new Customer("Alex", "Renard"));
        customerRepository.save(new Customer("Maria", "Bono"));
        customerRepository.save(new Customer("Louna", "Massy"));
        customerRepository.save(new Customer("Lila", "Mouma"));


        // fetch all customers
        logger.info("Show All Customers :");
        customerRepository.findAll().forEach((customer ->
                logger.info("{}", customer)));


    }}

