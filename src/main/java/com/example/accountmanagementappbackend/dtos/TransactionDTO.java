package com.example.accountmanagementappbackend.dtos;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * TransactionDTO class
 */
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

    private Long transactionId;
    private double amount;
    private Date transactionDate;
}
