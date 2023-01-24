package com.example.accountmanagementappbackend.dtos;

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
   // @NonNull
    private double initialCredit;
}
