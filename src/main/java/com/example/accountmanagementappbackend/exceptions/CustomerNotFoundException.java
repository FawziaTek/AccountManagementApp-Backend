package com.example.accountmanagementappbackend.exceptions;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * CustomerNotFoundException class
 ***/
public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
