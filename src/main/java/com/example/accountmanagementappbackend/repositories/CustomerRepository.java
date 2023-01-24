package com.example.accountmanagementappbackend.repositories;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * CustomerRepository interface
 **/
import com.example.accountmanagementappbackend.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
