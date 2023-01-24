package com.example.accountmanagementappbackend.repositories;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountRepository interface
 **/
import com.example.accountmanagementappbackend.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
