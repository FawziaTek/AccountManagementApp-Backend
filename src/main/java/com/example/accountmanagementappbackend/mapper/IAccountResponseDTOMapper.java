package com.example.accountmanagementappbackend.mapper;

import com.example.accountmanagementappbackend.dtos.AccountResponseDTO;
import com.example.accountmanagementappbackend.dtos.TransactionDTO;
import com.example.accountmanagementappbackend.entites.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IAccountResponseDTOMapper {

    @Autowired
    private ITransactionMapper iTransactionMapper;

    public AccountResponseDTO fromAccountToAccountResponseDTO(Account account) {
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();

        accountResponseDTO.setName(account.getCustomer().getName());
        accountResponseDTO.setSurname(account.getCustomer().getSurname());
        accountResponseDTO.setBalance(account.getBalance());

        List<TransactionDTO> transactionDTOS = account.getTransactions().stream()
                .map(transaction -> iTransactionMapper.fromTransactionToTransactionDTO(transaction))
                .collect(Collectors.toList());
        accountResponseDTO.setTransactionDTOS(transactionDTOS);

        return accountResponseDTO;
    }
}
