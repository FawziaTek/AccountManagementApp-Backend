package com.example.accountmanagementappbackend.services;


import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.dtos.AccountRequestDTO;
import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.entites.Account;
import com.example.accountmanagementappbackend.entites.Customer;
import com.example.accountmanagementappbackend.entites.Transaction;
import com.example.accountmanagementappbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementappbackend.exceptions.CustomerNotFoundException;
import com.example.accountmanagementappbackend.exceptions.InvalidInput;
import com.example.accountmanagementappbackend.exceptions.NoSuchElementException;
import com.example.accountmanagementappbackend.mapper.IAccountMapper;
import com.example.accountmanagementappbackend.mapper.IAccountResponseDTOMapper;
import com.example.accountmanagementappbackend.mapper.ICustomerMapper;
import com.example.accountmanagementappbackend.mapper.ITransactionMapper;
import com.example.accountmanagementappbackend.repositories.AccountRepository;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

@Slf4j //object log
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private IAccountMapper iAccountMapper;
    @Autowired
    private ITransactionMapper iTransactionMapper;
    @Autowired
    private IAccountResponseDTOMapper iAccountResponseDTOMapper;
    @Autowired
    private ICustomerMapper iCustomerMapper;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    //public AccountDTO createAccount(Long customerID, double initialCredit) throws CustomerNotFoundException {
    @Override

    public AccountDTO createAccount(AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException, NoSuchElementException {

        Customer customer = customerRepository.findById(accountRequestDTO.getCustomerId()).orElseThrow(() -> new NoSuchElementException("Customer"));
        if (Objects.isNull(customer))
            throw new CustomerNotFoundException("Customer not found.");

        if (accountRequestDTO.getInitialCredit() <= 0)
            throw new InvalidInput();

        Transaction transaction = new Transaction();
        Date currentDate = Date.valueOf(LocalDate.now());
        Account account = new Account(accountRequestDTO.getInitialCredit(), currentDate, customer);

        transaction.setAmount(accountRequestDTO.getInitialCredit());
        transaction.setTransactionDate(currentDate);
        transaction.setAccount(account);
        account.getTransactions().add(transaction);

        account = accountRepository.save(account);
        return mapAccount(transaction, customer, account);


    }

    private AccountDTO mapAccount(Transaction transaction, Customer customer, Account account) {
        AccountDTO accountDTO = iAccountMapper.fromAccountToAccountDTO(account);

        accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(customer));

        if (accountDTO.getTransactionDTOS() == null)
            accountDTO.setTransactionDTOS(new ArrayList<>());

        accountDTO.getTransactionDTOS().add(iTransactionMapper.fromTransactionToTransactionDTO(transaction));
        return accountDTO;
    }


    public AccountResponseDTO getAccountById(Long accountId) throws AccountNotFoundException, NoSuchElementException {

        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new AccountNotFoundException("Account id not found"));
        return iAccountResponseDTOMapper.fromAccountToAccountResponseDTO(account);
    }


    public List<AccountDTO> listOfAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                AccountDTO accountDTO = iAccountMapper.fromAccountToAccountDTO(account);
                accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(account.getCustomer()));
                accountDTOS.add(accountDTO);
            }
        }
        return accountDTOS;
    }

}
