package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * CustomerDTO class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long customerId;
    private String name;
    private String surname;
}
