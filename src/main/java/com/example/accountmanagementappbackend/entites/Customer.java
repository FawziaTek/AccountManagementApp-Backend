package com.example.accountmanagementappbackend.entites;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * Customer class
 */
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @OneToMany(mappedBy = "customer" , fetch = FetchType.EAGER , cascade = CascadeType.ALL) // One customer with Many accounts
    private List<Account> accounts;

}
