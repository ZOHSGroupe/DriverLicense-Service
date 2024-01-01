# Project Name

Short description or introduction of your project.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Development](#development)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Before you begin, ensure you have met the following requirements:

- [Docker](https://www.docker.com/) installed on your machine.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/ZOHSGroupe/DriverLicense-Service.git
    cd DriverLicense-Service
    ```

2. Create a `.env` file:

   Create a file named `.env` in the root directory and add the following configuration:

    ```env
    PORT=5000
    DB_USER=root
    DB_PASSWORD=root
    DB_PORT=3306
    DB_NAME=assurance
    DB_HOST=localhost
    ```

   Set the appropriate values for your development environment.

3. Build and run the Docker containers:

    ```bash
    docker-compose up
    ```

   This will start the MariaDB container and the application container.

4. Access the application:

   Once the containers are up and running, you can access the application at [http://localhost:5000](http://localhost:5000).

5. Shut down the containers:

   When you are done, you can stop the containers using:

    ```bash
    docker-compose down
    ```



### Prerequisites

Before you start, make sure you have the following tools and dependencies installed:

- [Docker](https://www.docker.com/): Used for containerization and running the application in isolated environments.
- [Git](https://git-scm.com/): Version control system for managing and tracking changes in the project.

Make sure to have these tools installed and configured on your local machine before proceeding with the installation.


## Installation

Follow these steps to install and configure the project:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/your-repo.git
   cd your-repo

## Usage

Here are examples and instructions on how to use the project:

1. **API Endpoints:**
   - Use the following API endpoints to interact with the application:
      - `GET /api/driver-licenses`: Get a list of all driver licenses.
      - `GET /api/driver-licenses/{id}`: Get details of a specific driver license by ID.
      - `POST /api/driver-licenses`: Add a new driver license.
      - `DELETE /api/driver-licenses/{id}`: Delete a driver license by ID.

2. **Adding a Driver License:**
   - To add a new driver license, send a POST request to `/api/driver-licenses/add` with the necessary data in the request body.

   Example using cURL:
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"field1": "value1", "field2": "value2"}' http://localhost:5000/api/driver-licenses/add

## Configuration

Explain any configuration options or settings.

## Development

Guidelines for developers who want to contribute to the project.

## Deployment

Instructions on how to deploy your project.

## Contributing

Explain how others can contribute to your project.

## License

This project is licensed under the [License Name](LICENSE.md) - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

Mention any third-party libraries, resources, or inspirations.

