# AccountManagementApp-Backend

AccountManagement Application Backend
Spring Boot and Angular Application
This project provides to create account for existing customers.

Summary
The assessment consists of an API to be used for opening a new “current account” of already existing customers.

Requirements
• The API will expose an endpoint which accepts the user information (customerID, initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user whose ID is customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts.

The application has 2 apis

AccountAPI
CustomerAPI

* POST /v1/account - creates a new account for existing customer
* GET /v1/account/{accountId} - retrieves an account
* GET /v1/account - retrieves all accounts
* GET /v1/customer - retrieves all customers

Tech Stack
Java 8
Spring Boot
Spring Data JPA
Angular 8
Restful API
Swagger UI
H2 In memory database
JUnit 5
Angular for frontend
Prerequisites
Maven
Run & Build

AccountManagementApp-Backend
$ mvn clean install
$ mvn spring-boot:run

AccountManagement-Frontend
$ npm install
$ ng serve

Swagger UI will be run on this url($PORT: 8382)
http://localhost:${PORT}/swagger-ui.html
