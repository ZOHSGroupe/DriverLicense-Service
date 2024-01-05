## Description

Assurance-Service is an Application Programming interface for add,update,delete and get Assurance of ZOHS company.

---
## Installation


---
## Running the app


---
## Dockerize the app

---

## DTOs (Data Transfer Objects) for Assurance

### 1. AssuranceCreateDTO

Represents the data required to create a new assurance.

- **Fields:**
    - `type: string` - Type of the assurance.
    - `dateCreate: Date` - Date when the assurance was created.
    - `status: string` - Status of the assurance.
    - `viheculeId: string` - ID of the associated vehicle.
    - `price: string` - Price of the assurance.

### 2. AssuranceDTO

Represents the data of an assurance.

- **Fields:**
    - `id: string` - Unique identifier of the assurance.
    - `type: string` - Type of the assurance.
    - `dateCreate: Date` - Date when the assurance was created.
    - `status: string` - Status of the assurance.
    - `viheculeId: string` - ID of the associated vehicle.
    - `price: string` - Price of the assurance.

### 3. AssuranceUpdateDTO

Represents the data used to update an existing assurance.

- **Fields:**
    - `type: string` - Updated type of the assurance.
    - `status: string` - Updated status of the assurance.
    - `price: string` - Updated price of the assurance.

---

## Available Endpoints

### 1. Get All Assurances

- **Endpoint:** `GET /assurance`
- **Description:** Retrieve a list of all assurances.
- **Response:**
    - `200`: Successful retrieval with a list of assurances.
    - `500`: Internal Server Error.

### 2. Get Assurance by ID

- **Endpoint:** `GET /assurance/{id}`
- **Description:** Get details of an assurance by ID.
- **Response:**
    - `200`: Successful retrieval with assurance details.
    - `404`: Assurance not found.
    - `500`: Internal Server Error.

### 3. Create Assurance

- **Endpoint:** `POST /assurance`
- **Description:** Create a new assurance.
- **Request Body:**
    - `AssuranceCreateDTO`: Data for creating a new assurance.
- **Response:**
    - `201`: Assurance created successfully.
    - `400`: Bad Request (invalid input).
    - `500`: Internal Server Error.

### 4. Update Assurance

- **Endpoint:** `PUT /assurance/{id}`
- **Description:** Update an existing assurance by ID.
- **Request Body:**
    - `AssuranceUpdateDTO`: Data for updating an assurance.
- **Response:**
    - `200`: Assurance updated successfully.
    - `404`: Assurance not found.
    - `500`: Internal Server Error.

### 5. Delete Assurance

- **Endpoint:** `DELETE /assurance/{id}`
- **Description:** Delete an assurance by ID.
- **Response:**
    - `200`: Assurance deleted successfully.
    - `404`: Assurance not found.
    - `500`: Internal Server Error.

### 6. Get Assurances by Vihecule ID

- **Endpoint:** `GET /assurance/vihecule/{viheculeId}`
- **Description:** Retrieve assurances associated with a specific vihecule ID.
- **Response:**
    - `200`: Successful retrieval with a list of assurances.
    - `500`: Internal Server Error.

### 7. Delete Assurances by Vihecule ID

- **Endpoint:** `DELETE /assurance/vihecule/{viheculeId}`
- **Description:** Delete assurances associated with a specific vihecule ID.
- **Response:**
    - `200`: Assurances deleted successfully.
    - `404`: Assurances not found.
    - `500`: Internal Server Error.

---





## Stay in touch
- Author - [Ouail Laamiri](https://www.linkedin.com/in/ouaillaamiri/)
- Test - [Postman]()
- Documentation - [Postman]()