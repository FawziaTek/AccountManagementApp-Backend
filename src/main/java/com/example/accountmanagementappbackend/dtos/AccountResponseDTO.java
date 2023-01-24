package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    //private Long account_id;
    private String name;
    private String surname;
    private double balance;
    private List<TransactionDTO> transactionDTOS;

}
