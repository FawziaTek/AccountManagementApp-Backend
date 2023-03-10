package com.example.accountmanagementappbackend.services;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountService interface
 **/

import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.dtos.AccountRequestDTO;
import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementappbackend.exceptions.CustomerNotFoundException;
import com.example.accountmanagementappbackend.exceptions.NoSuchElementException;

import java.util.List;

public interface AccountService {


    AccountDTO createAccount(AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException, NoSuchElementException;

    AccountResponseDTO getAccountById(Long accountId) throws AccountNotFoundException;

    List<AccountDTO> listOfAccounts();
}
