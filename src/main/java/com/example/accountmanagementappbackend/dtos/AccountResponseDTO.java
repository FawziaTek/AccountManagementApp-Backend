package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountResponseDTO class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private double balance;
    private List<TransactionDTO> transactionDTOS;

}
