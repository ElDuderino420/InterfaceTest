package com.company;

public class AlreadyExistsException extends Exception
{
    private String registrationNumber;

    public AlreadyExistsException(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString()
    {
        return "Error, registration exists: " + registrationNumber;
    }

}