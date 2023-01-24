package com.example.accountmanagementappbackend.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
