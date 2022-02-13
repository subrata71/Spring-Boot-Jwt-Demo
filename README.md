## Core Technologies Used

Spring Boot 2.6.3

Spring Security with JWT

H2 Database

## APIs

### Signup User for Authentication

/users/signup

This API is developed for signing up an authentication user. The API is made public for keeping things simple. In the live environment, this API should be restricted.

### Get JWT Token

/login

This API provides the generated JWT token in response to the HTTP request provided that the HTTP request is authenticated through basic authentication.

## /employee-filtered?position={nameOfThePosition}

This API will return the list of employees under the given position. Any request to this API is granted if and only if the provided JWT token is valid.

### Example

![List_of_employees.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/66250fcb-fce4-4f4d-978a-2530e93c1610/List_of_employees.png)

# Table

This is the table where employee information is stored. The table structure is kept minimum in order to not deviate from the main purpose.

![ERD_WEB2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2e2706ca-5d1d-4dcb-91c7-465bca19f6e9/ERD_WEB2.png)

# Unit Tests

Two unit test cases have been written. One is intended for a failure case and the other one is for a success case.

Failure Case (`getAllEmployees_accessForbidden`)

Success Case (`getAllEmployees_success`)

# Logging and Monitoring

For better logging and monitoring every HTTP request is intercepted and assigned a unique request ID (UUID). In every successive log of the aforementioned request that unique request ID is printed. So debugging an issue and finding the relevant logs of a request is a matter of a minute.

## Example

This is a sample log when a request is made to the /employee-filtered API. The bold characters inside the braces [] is a unique request ID.

13/02/2022 20:18:23.828 [**397367b1-bece-40e3-8d90-19d41842d4d7**] [http-nio-8077-exec-3] DEBUG c.a.w.controller.EmployeeController - Request received to serve filtered employees by position: Senior Manager

# Deployment

> The application packaging is configured to JAR but it can be changed to WAR through a small change mentioning in the pom.xml file.
>
