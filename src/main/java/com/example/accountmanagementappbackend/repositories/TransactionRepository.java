package com.example.accountmanagementappbackend.repositories;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * TransactionRepository interface
 **/
import com.example.accountmanagementappbackend.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
