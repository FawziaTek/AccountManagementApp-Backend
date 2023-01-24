package com.example.accountmanagementappbackend.mapper;

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
