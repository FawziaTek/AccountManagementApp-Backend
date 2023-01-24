package com.example.accountmanagementappbackend.mapper;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * ITransactionMapper class : in this class we will convert Object Transaction to TransactionDTO
 **/

import com.example.accountmanagementappbackend.dtos.TransactionDTO;
import com.example.accountmanagementappbackend.entites.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service

public class ITransactionMapper {

    public TransactionDTO fromTransactionToTransactionDTO(Transaction transaction)
    {
        TransactionDTO transactionDTO=new TransactionDTO();
        //copy properties from bean to another
        BeanUtils.copyProperties(transaction,transactionDTO);
        return transactionDTO;
    }
}
