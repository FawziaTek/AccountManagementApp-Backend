package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountDTO class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long accountId;
    private double balance;
    private Date creationDate;
    private CustomerDTO customerDTO;
    private List<TransactionDTO> transactionDTOS;
}
