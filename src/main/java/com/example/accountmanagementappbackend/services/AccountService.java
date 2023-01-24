package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementbackend.dtos.AccountDTO;
import com.example.accountmanagementbackend.dtos.AccountRequestDTO;
import com.example.accountmanagementbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementbackend.exceptions.CustomerNotFoundException;
import com.example.accountmanagementbackend.exceptions.NoSuchElementException;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException , NoSuchElementException;

    AccountResponseDTO getAccountById(Long accountId) throws AccountNotFoundException;

    List<AccountDTO> listOfAccounts();
}
