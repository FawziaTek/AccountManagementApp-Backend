package com.example.accountmanagementappbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long customer_id;
    private String name;
    private String surname;
}
