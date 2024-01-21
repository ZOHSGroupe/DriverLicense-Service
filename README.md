## Description

DriverLicense-Service is an Application Programming interface for add,update,delete and get driver license of ZOHS company.

---
## Running the app
```bash
# build app
$ mvn clean install
# run the app
$ java -jar target/client-0.0.1-SNAPSHOT.jar
```
---
## Dockerize the app
```bash
# dockerize the app with mysql database
$ docker compose up
# stop the application
$ docker compose down
```
---

## DTOs (Data Transfer Objects) for Assurance

### 1. DriverLicenseCreateDTO

Represents the data required to create a new driver license.

- **Fields:**
    - `type: TypeDriverLicense` - Type of the driver license.
    - `status: Status` - Status of the driver license.
    - `clientId: string `- ID of the associated client.
    - `licenseNumber: string` - License number.
    - `issueDate: Date` - Date of issue.
    - `expirationDate: Date` - Expiration date.

### 2. DriverLicenseDTO

Represents the data of a driver license.

- **Fields:**
  - `id: string` - Unique identifier of the driver license.
  - `type: TypeDriverLicense` - Type of the driver license.
  - `dateCreation: Date` - Date when the driver license was created.
  - `status: Status` - Status of the driver license.
  - `clientId: string` - ID of the associated client.
  - `licenseNumber: string` - License number.
  - `issueDate: Date` - Date of issue.
  - `expirationDate: Date` - Expiration date.

### 3. DriverLicenseUpdateDTO

Represents the data used to update an existing driver license.

- **Fields:**
  - `status: Status` - Updated status of the driver license.
  - `type: TypeDriverLicense` - Updated type of the driver license.
  - `issueDate: Date` - Updated issue date.
  - `expirationDate: Date` - Updated expiration date.

---

## Available Endpoints

### 1. Save Driver License

- **Endpoint:** `POST /driver-license`
- **Description:** Save a new driver license.
- **Request Body:**
   - `DriverLicenseCreateDTO`: Data for creating a new driver license.
- **Response:**
  - `201`: Driver license created successfully.
  - `400`: Bad Request (invalid input).
  - `404`: Client not found.
  - `500`: Internal Server Error.

### 2. Get All Driver Licenses

- **Endpoint:** `GET /driver-license`
- **Description:** Retrieve a list of all driver licenses.
    - `200`: Successful retrieval with a list of driver licenses.
    - `500`: Internal Server Error.

### 3. Get Driver License by ID

- **Endpoint:** `ET /driver-license/{id}`
- **Description:** Get details of a driver license by ID.
- **Response:**
    - `200`: Successful retrieval with driver license details.
    - `404`: Driver license not found.
    - `500`: Internal Server Error.

### 4. Get Driver Licenses by Client ID

- **Endpoint:** `GET /driver-license/client/{clientId}`
- **Description:** Retrieve driver licenses associated with a specific client ID.
- **Response:**
    - `200`: Successful retrieval with a list of driver licenses.
    - `500`: Internal Server Error.

### 5. Get Valid Driver Licenses by Client ID

- **Endpoint:** `GET /driver-license/valid/client/{clientId}`
- **Description:** Retrieve valid driver licenses associated with a specific client ID.
- **Response:**
    - `200`: Successful retrieval with a list of valid driver licenses.
    - `400`: Bad Request.
    - `500`: Internal Server Error.

### 6. Get Invalid Driver Licenses by Client ID

- **Endpoint:** `GET /driver-license/invalid/client/{clientId}`
- **Description:** Retrieve invalid driver licenses associated with a specific client ID.
- **Response:**
    - `200`: Successful retrieval with a list of invalid driver licenses.
    - `400`: Bad Request.
    - `500`: Internal Server Error.

### 7. Update Driver License

- **Endpoint:** `PUT /driver-license/{id}`
- **Description:** Update an existing driver license by ID.
- - **Request Body:**
  - `DriverLicenseUpdateDTO`: Data for updating a driver license.
- **Response:**
    - `200`: Driver license updated successfully.
    - `404`: Driver license not found.
    - `400`: Bad Request.
    - `500`: Internal Server Error.

### 8. Delete Driver License by ID

- **Endpoint:** `DELETE /driver-license/{id}`
- **Description:** Delete a driver license by ID.
- **Response:**
  - `200`: Driver license deleted successfully.
  - `404`: Driver license not found.
  - `500`: Internal Server Error.

### 9. Delete Driver Licenses by Client ID

- **Endpoint:** `DELETE /driver-license/client/{clientId}`
- **Description:** Delete driver licenses associated with a specific client ID.
- **Response:**
  - `200`:  Driver licenses deleted successfully.
  - `404`: Driver licenses not found.
  - `500`: Internal Server Error.



---





## Stay in touch
- Author - [Ouail Laamiri](https://www.linkedin.com/in/ouaillaamiri/)
- Test - [Postman](https://www.postman.com/avionics-meteorologist-32935362/workspace/postman-api-fundamentals-student-expert/collection/29141176-df7efae0-ef03-4c98-b364-402a5f40c86d?action=share&creator=29141176)
- Documentation - [Postman]()


## License

Driver License Service is [GPL licensed](LICENSE).