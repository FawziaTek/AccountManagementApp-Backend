package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long transaction_id;
    private double amount;
    private Date transactionDate;
}
