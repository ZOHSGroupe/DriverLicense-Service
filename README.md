## Description

Driver-Licence-Service is an Application Programming Interface (API) to add,delete,updateand get vihecule .
## Installation :
```bash
# install requirements
$ pip install -r requirements.txt 
```
## Running the app : 
```bash
# Run application
$ gunicorn -c gunicorn_config.py main:app
```
## Build Docker image : 
```bash
# build a docker image
$ docker build -t vihecule-service .
```
## Running the app in the Docker : 
```bash
# Run docker image
$ docker run -p 5000:5000 vihecule-service
```


## Available Endpoints

### 1. Get All Driver Licenses

- **Endpoint:** `/driver-licence`
- **Method:** GET
- **Description:** Retrieve a list of all driver licenses.
- **Response:**
  - `200`: Successful retrieval with a list of driver licenses.
  - `500`: Internal Server Error.

### 2. Get Driver License by ID

- **Endpoint:** `/driver-licence/{id}`
- **Method:** GET
- **Description:** Retrieve a specific driver license by ID.
- **Response:**
  - `200`: Successful retrieval with the driver license.
  - `404`: Driver license not found (if the specified ID does not exist).
  - `500`: Internal Server Error.

### 3. Create Driver License

- **Endpoint:** `/driver-licence`
- **Method:** POST
- **Description:** Create a new driver license.
- **Request Body:**
  - `id`: String - ID of the driver license.
  - `dateCreation`: String (ISO format) - Date of creation.
  - `expirationDate`: String (ISO format) - Expiration date.
  - `issueDate`: String (ISO format) - Issue date.
  - `licenseNumber`: String - License number.
  - `status`: String - Status of the driver license.
  - `type`: String - Type of the driver license.
  - `client_id`: String - ID of the associated client.
- **Response:**
  - `201`: Driver license created successfully.
  - `404`: Client not found (if the specified client_id does not exist).
  - `500`: Internal Server Error.

### 4. Delete Driver License

- **Endpoint:** `/driver-licence/{id}`
- **Method:** DELETE
- **Description:** Delete a specific driver license by ID.
- **Response:**
  - `204`: Driver license deleted successfully.
  - `404`: Driver license not found (if the specified ID does not exist).
  - `500`: Internal Server Error.

### 5. Show Driver License Details

- **Endpoint:** `/driver-licence/show/{id}`
- **Method:** GET
- **Description:** Retrieve details of a specific driver license by ID.
- **Response:**
  - `200`: Successful retrieval with the driver license details.
  - `404`: Driver license not found (if the specified ID does not exist).
  - `500`: Internal Server Error.






## Stay in touch :
- Author - [Ouail Laamiri](https://www.linkedin.com/in/ouaillaamiri/)
- Test - [Postman]()
- Documentation - [Postman]()

## License

Vihecule-Service is [GPL licensed](LICENSE).


