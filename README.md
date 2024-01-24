# Expense Tracker API

## Overview

RESTful web service built with Spring Boot, using SQL for the database and provides endpoints for creating, updating, and retrieving expense records.

## Table of Contents

1. [Database Structure](#database-structure)
2. [Endpoints](#endpoints)

<hr>

## Database Structure
The primary structure involves two main tables: 

<ol>
    <li><strong>users</strong></li>
    <li><strong>expense_base</strong></li>
</ol>

1. #### users Table
The users table serves as the repository for user information. Whenever a new user is created, their details, are stored in this table.

#### Table Structure
```
`users` (
  `user_id` varchar(255) NOT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
)
```

2. #### expense_base Table

The expense_base table acts as a foundational template for individual user expense tables. When a new user is added to the system, a corresponding table is dynamically created with the user's username as the table name.

#### Table Structure

```
`expense_base` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `isCredited` tinyint(1) NOT NULL,
  `category` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `transaction_date` datetime NOT NULL,
  PRIMARY KEY (`transaction_id`)
)
```

<hr>


## Endpoints
1. Creating a new user

   ```GET /user/new```

### Request Body
```
{
    "password": "[password]",
    "username": "[username]",
    "emailId": "[email id]"
}
```

### Success Response
```
{
    "status": "success",
    "message": "User created successfully",
    "data": {
        "userId": "[userid]", //generated
        "username": "[username]",
        "password": "[password]",
        "emailId": "[email id]"
    }
}

```

### Failure Response
```
{
    "status": "failure",
    "message": "User already exists",
    "data": {
        "userId": null,
        "username": "[username]",
        "password": "[password]",
        "emailId": "[email id]"
    }
}

```
2. Authentication of a user
   
   ```GET /user/auth?username={username}&password={password}```

### Success Response
```
{
    "status": "successful",
    "message": "Authenticated Successfully",
    "data": {
        "userId": "[userid]", //generated
        "username": "[username]",
        "password": "[password]",
        "emailId": "[email id]"
    }
}

```

### Failure Response
```
{
    "status": "failure",
    "message": "Authenticated Unsuccessfully",
    "data": null
}
```

3. Add a expense
   
   ```POST /expense/add/{username} ```

### Request Body

```
{
    "amount": "[amount]",
    "isCredit": [true/false],
    "category": "[category]",
    "description": "[description]",
    "dateTime": "[dateTime]"
}
```

### Response
```
{
    "status": "success",
    "message": "Expense Added Successfully",
    "data": {
        "id": null,
        "dateTime": "[dateTime]",
        "amount": "[amount]",
        "description": "[description]",
        "category": "[category]",
        "credit": [true/false]
    }
}
```

4. Get all expenses

   ```GET /expense/get/all/{username}```


### Response
```
[
    {
        "id": 1,
        "dateTime": "[DateTime 1]",
        "amount": "[Amount 1]",
        "description": "[Description 1]",
        "category": "[Category 1]",
        "credit": false
    },
    {
        "id": 2,
        "dateTime": "[DateTime 2]",
        "amount": "[Amount 2]",
        "description": "[Description 2]",
        "category": "[Category 2]",
        "credit": false
    },
    {
        "id": 3,
        "dateTime": "[DateTime 3]",
        "amount": "[Amount 3]",
        "description": "[Description 3]",
        "category": "[Category 3]",
        "credit": false
    }
]

```
5. Update a expense

   ```PUT /expense/update/{username}/{id}```

### Request Body
```
{
   "dateTime": "[updated date time]",
    "amount": [updated amount],
    "description": "[updated description]",
    "category": "[updated category]",
    "isCredit": [updated boolean]
}
```

### Response

```
{
    "status": "success",
    "message": "Expense Updated Successfully",
    "data": {
        "id": 3,
        "dateTime": "[updated date time]",
        "amount": [updated amount],
        "description": "[updated description]",
        "category": "[updated category]",
        "credit": [updated boolean]
    }
}
```

6. Delete a expense

   ```/expense/delete/{username}/{id} ```

### Response
```
{
    "status": "success",
    "message": "Expense Deleted Successfully",
    "data": null
}
```

