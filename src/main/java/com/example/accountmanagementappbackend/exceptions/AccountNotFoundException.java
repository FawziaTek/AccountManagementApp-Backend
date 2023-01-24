package com.example.accountmanagementappbackend.exceptions;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * AccountNotFoundException class
 ***/
public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String message)
    {
        super(message);
    }
}
