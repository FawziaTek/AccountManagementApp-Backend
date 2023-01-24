package com.example.accountmanagementappbackend.controller;


import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.dtos.AccountRequestDTO;
import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.exceptions.AccountNotFoundException;
import com.example.accountmanagementappbackend.exceptions.CustomerNotFoundException;
import com.example.accountmanagementappbackend.exceptions.InvalidInput;
import com.example.accountmanagementappbackend.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")

@Api(description = "Consume the Account Management web service Account API ")
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController(AccountService accountService) {
        this.accountService=accountService;
    }


    @ApiOperation(value = "This method allows to opening a new current account for already existing customers.", response = AccountResponseDTO.class)
    @PostMapping
    //public AccountResponseDTO createAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException {
    public AccountDTO createAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO) throws CustomerNotFoundException, InvalidInput {
        logger.info("==> createAccount  In");
        if((accountRequestDTO.getCustomer_Id() == null ) || (accountRequestDTO.getCustomer_Id().toString().isEmpty()) ){
            throw new InvalidInput("CustomerId");
        }
        if((accountRequestDTO.getInitialCredit() == 0 )){
            throw new InvalidInput("Initial Credit");
        }
        //return accountService.createAccount(customerID, initialCredit);
       return accountService.createAccount(accountRequestDTO);
    }


    @ApiOperation(value = "This method allows to show customer informations of specific account.", response = AccountResponseDTO.class)
    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccountById(@Valid @PathVariable Long accountId) throws AccountNotFoundException,InvalidInput{
        logger.info("==> getAccountById  In");

        if((accountId == null ) || (accountId.toString().isEmpty())  ){
            throw new InvalidInput("AccountId");
        }

        return accountService.getAccountById(accountId);
    }

    @ApiOperation(value = "This method allows to show all accounts", response = AccountDTO.class)
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts()  {
        logger.info("==> getAllAccounts  In");
        return ResponseEntity.ok(accountService.listOfAccounts());
    }
}
