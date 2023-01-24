package com.example.accountmanagementappbackend.services;

import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.entites.Account;
import com.example.accountmanagementappbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementappbackend.mapper.IAccountMapper;
import com.example.accountmanagementappbackend.mapper.IAccountResponseDTOMapper;
import com.example.accountmanagementappbackend.mapper.ICustomerMapper;
import com.example.accountmanagementappbackend.mapper.ITransactionMapper;
import com.example.accountmanagementappbackend.repositories.AccountRepository;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @InjectMocks
    private AccountServiceImpl testeAccount;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private IAccountResponseDTOMapper iAccountResponseDTOMapper;
    @Mock
    private IAccountMapper iAccountMapper;
    @Mock
    private ITransactionMapper iTransactionMapper;
    @Mock
    private ICustomerMapper iCustomerMapper;


    @Test
    void createAccount() {
     /*   when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
        when(accountRepository.save(any())).thenReturn(new Account());
        final AccountRequestDTO accountRequestDTO = new AccountRequestDTO(1L, 20);

        final AccountDTO result = testeAccount.createAccount(accountRequestDTO);

        assertEquals();*/

    }

    @Test()
    void getAccountByIdNotFound() {
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> testeAccount.getAccountById(1L));
    }

    @Test()
    void getAccountById() {
        final Account account = new Account();
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        when(iAccountResponseDTOMapper.fromAccountToAccountResponseDTO(account)).thenReturn(new AccountResponseDTO());
        try {
            testeAccount.getAccountById(1L);
        } catch (AccountNotFoundException e) {
            // should not come here
        }
        verify(accountRepository.findById(1L));
        verify(iAccountResponseDTOMapper.fromAccountToAccountResponseDTO(account));
    }

    @Test
    void listOfAccounts() {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account());
        accounts.add(new Account());
        when(accountRepository.findAll()).thenReturn(accounts);
        when(iAccountMapper.fromAccountToAccountDTO(any())).thenReturn(new AccountDTO());
        //when
        List<AccountDTO> result = testeAccount.listOfAccounts();
        //then
        assertNotNull(result);
        assertEquals(accounts.size(), result.size());
    }
}