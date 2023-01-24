package com.example.accountmanagementappbackend.entites;
/**
 * @author Fawzia Tekaya in 18/01/23
 *
 */
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId",updatable = false,nullable = false)
    private Long accountId;
   @NonNull
    private double balance;
   @NonNull
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name="customerId",nullable = false)// Many account for One customer
   @NonNull
    private Customer customer;
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER , cascade = CascadeType.ALL) // One account with Many transactions
    private List<Transaction> transactions;


}
