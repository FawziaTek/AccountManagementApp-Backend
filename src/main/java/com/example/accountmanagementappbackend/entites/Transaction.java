package com.example.accountmanagementappbackend.entites;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * Transaction class
 */

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
    //@Column(name = "transactionId",updatable = false,nullable = false)
    private Long transactionId;
    @NonNull
    private double amount;
    @NonNull
    private Date transactionDate;
   // @NonNull
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL) // Many transactions for One account
    @JoinColumn(name="accountId",nullable = false)
    private Account account;

}
