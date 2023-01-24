package com.example.accountmanagementappbackend.dtos;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountRequestDTO class
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString

public class AccountRequestDTO {

    private Long customerId;
    private double initialCredit;
}
