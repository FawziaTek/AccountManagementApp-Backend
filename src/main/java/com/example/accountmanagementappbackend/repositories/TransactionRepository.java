package com.example.accountmanagementappbackend.repositories;

import com.example.accountmanagementappbackend.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
