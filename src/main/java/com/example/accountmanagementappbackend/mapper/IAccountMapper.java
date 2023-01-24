package com.example.accountmanagementappbackend.mapper;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * IAccountMapper class : in this class we will convert Object Account to AccountDTO
 **/
import com.example.accountmanagementappbackend.dtos.AccountDTO;
import com.example.accountmanagementappbackend.entites.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class IAccountMapper {
    public AccountDTO fromAccountToAccountDTO(Account account)
    {
        AccountDTO accountDTO=new AccountDTO();
        //copy properties from bean to another
        BeanUtils.copyProperties(account,accountDTO);
        return accountDTO;
    }
}
