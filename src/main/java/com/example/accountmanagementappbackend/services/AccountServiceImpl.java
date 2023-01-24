package com.example.accountmanagementappbackend.services;


import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.dtos.AccountRequestDTO;
import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.dtos.TransactionDTO;
import com.example.accountmanagementappbackend.entites.Account;
import com.example.accountmanagementappbackend.entites.Customer;
import com.example.accountmanagementappbackend.entites.Transaction;
import com.example.accountmanagementappbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementappbackend.exceptions.CustomerNotFoundException;
import com.example.accountmanagementappbackend.exceptions.InvalidInput;
import com.example.accountmanagementappbackend.exceptions.NoSuchElementException;
import com.example.accountmanagementappbackend.mapper.IAccountMapper;
import com.example.accountmanagementappbackend.mapper.ICustomerMapper;
import com.example.accountmanagementappbackend.mapper.ITransactionMapper;
import com.example.accountmanagementappbackend.repositories.AccountRepository;
import com.example.accountmanagementappbackend.repositories.CustomerRepository;
import com.example.accountmanagementappbackend.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

@Slf4j //object log
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private IAccountMapper iAccountMapper;
    @Autowired
    private ITransactionMapper iTransactionMapper;
    @Autowired
    private ICustomerMapper iCustomerMapper;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    //public AccountDTO createAccount(Long customerID, double initialCredit) throws CustomerNotFoundException {
    @Override

    public AccountDTO createAccount(AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException , NoSuchElementException {
            AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        Transaction transaction = new Transaction();
        Date currentDate = Date.valueOf(LocalDate.now());

        Customer customer = customerRepository.findById(accountRequestDTO.getCustomer_Id()).orElseThrow(()->  new NoSuchElementException("Customer"));
        if(customer == null )
            throw  new CustomerNotFoundException("Customer not found ") ;


        Account account = new Account(accountRequestDTO.getInitialCredit(), currentDate,customer);
        account= accountRepository.save(account);
        logger.info("{}",account);

        if(accountRequestDTO.getInitialCredit() > 0 )
        {
          //  Transaction transaction = new Transaction(accountRequestDTO.getInitialCredit(),currentDate,account);
            transaction.setAmount(accountRequestDTO.getInitialCredit());
            transaction.setTransactionDate(currentDate);
            transaction.setAccount(account);

            transaction= transactionRepository.save(transaction);
           // logger.info("{}",transaction);

            transaction.setAccount(null);
            if(account.getTransactions() == null)
                account.setTransactions(new ArrayList<>());
            account.getTransactions().add(transaction);
            logger.info("{}",transaction);
        }else {
                throw new InvalidInput("initial credit");
        }

        AccountDTO accountDTO= iAccountMapper.fromAccountToAccountDTO(account);

        accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(customer));
       if(accountDTO.getTransactionDTOS() == null)
            accountDTO.setTransactionDTOS(new ArrayList<>());

        accountDTO.getTransactionDTOS().add(iTransactionMapper.fromTransactionToTransactionDTO(transaction));

       return accountDTO;


    }



    public AccountResponseDTO getAccountById(Long accountId) throws AccountNotFoundException, NoSuchElementException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(()->  new NoSuchElementException("Account"));
                // .orElseThrow(()->  new   AccountNotFoundException("Account id not found"));


        AccountDTO accountDTO= iAccountMapper.fromAccountToAccountDTO(account);
        List<TransactionDTO> transactionDTOList= new ArrayList<>();
        if(account.getTransactions() != null && !account.getTransactions().isEmpty()){
            for(Transaction t :account.getTransactions())
                transactionDTOList.add(iTransactionMapper.fromTransactionToTransactionDTO(t));
        }else{
            throw new NoSuchElementException("Transaction");
        }
        accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(account.getCustomer()));
        accountDTO.setTransactionDTOS(transactionDTOList);

        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
       // accountResponseDTO.setAccount_id(accountId);
        accountResponseDTO.setName(accountDTO.getCustomerDTO().getName());
        accountResponseDTO.setSurname(accountDTO.getCustomerDTO().getSurname());
        accountResponseDTO.setBalance(accountDTO.getBalance());
        accountResponseDTO.setTransactionDTOS(transactionDTOList);

        return accountResponseDTO;
    }


    public List<AccountDTO> listOfAccounts()
    {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS= new ArrayList<>();
        if(accounts != null && !accounts.isEmpty()){
            for(Account account: accounts){
                AccountDTO accountDTO= iAccountMapper.fromAccountToAccountDTO(account);
                accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(account.getCustomer()));
                accountDTOS.add(accountDTO);
            }
        }
        return accountDTOS;
    }

}
