package com.example.accountmanagementappbackend.entites;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "transaction_id",updatable = false,nullable = false)
    private Long transaction_id;
    @NonNull
    private double amount;
    @NonNull
    private Date transactionDate;
   // @NonNull
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL) // Many transactions for One account
    @JoinColumn(name="account_id",nullable = false)
    private Account account;

}