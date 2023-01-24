package com.example.accountmanagementappbackend.repositories;

import com.example.accountmanagementappbackend.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
