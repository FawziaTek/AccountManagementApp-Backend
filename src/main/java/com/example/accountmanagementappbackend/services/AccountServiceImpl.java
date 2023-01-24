package com.example.accountmanagementappbackend.services;

/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountServiceImp class : we will implement the accountService interface
 * <p>
 * in this class we created 3 services
 **/

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
@Slf4j
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

    /***
     * createAccount Service : in this service we will create a new account for already existing customer
     *
     * Inpout: AccountRequestDTO
     * Output:AccountDTO
     *
     *
     * **/

    @Override
    public AccountDTO createAccount(AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException, NoSuchElementException {

        //check if the customerId entered  exist
        Customer customer = customerRepository.findById(accountRequestDTO.getCustomerId()).orElseThrow(() -> new NoSuchElementException("Customer"));
        if (Objects.isNull(customer))
            throw new CustomerNotFoundException("Customer not found.");

        //check if the initialCreadit is < = 0
        if (accountRequestDTO.getInitialCredit() <= 0)
            throw new InvalidInput();

        Transaction transaction = new Transaction();
        Date currentDate = Date.valueOf(LocalDate.now()); // return currentDate

        //create a new account
        Account account = new Account(accountRequestDTO.getInitialCredit(), currentDate, customer);
        //create a new transection
        transaction.setAmount(accountRequestDTO.getInitialCredit());
        transaction.setTransactionDate(currentDate);
        transaction.setAccount(account);
        account.getTransactions().add(transaction);
        //save the new account
        account = accountRepository.save(account);
        return mapAccount(transaction, customer, account);


    }

    //this method will map the account details to AccountDTO
    private AccountDTO mapAccount(Transaction transaction, Customer customer, Account account) {
        AccountDTO accountDTO = iAccountMapper.fromAccountToAccountDTO(account);

        accountDTO.setCustomerDTO(iCustomerMapper.fromCustomerToCustomerDTO(customer));

        if (accountDTO.getTransactionDTOS() == null)
            accountDTO.setTransactionDTOS(new ArrayList<>());

        accountDTO.getTransactionDTOS().add(iTransactionMapper.fromTransactionToTransactionDTO(transaction));
        return accountDTO;
    }

    /***
     * getAccountById Service : in this service we will fetch an already existing account and we will return account details
     *
     * Inpout: accountId
     * Output:AccountResponseDTO
     *
     *
     * **/
    public AccountResponseDTO getAccountById(Long accountId) throws AccountNotFoundException, NoSuchElementException {
        //check if the accountId entered  exist
        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new AccountNotFoundException("Account id not found"));
        return iAccountResponseDTOMapper.fromAccountToAccountResponseDTO(account);
    }


    /***
     * listOfAccounts Service : in this service we will return all accounts
     *
     * Inpout:
     * Output:List<AccountDTO>
     *
     *
     * **/
    public List<AccountDTO> listOfAccounts() {

        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();

        //check if accounts null or empty
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
