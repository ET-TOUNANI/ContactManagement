# Contact Management API

## Description

This file contains the source code for a REST API that handles CRUD operations on a `Contact` entity. The API uses Spring Boot and Lombok libraries.

## Dependencies

The following dependencies are required to run the API:

- Spring Boot 2.4.4
- Lombok 1.18.20
- Jakarta Persistence API 2.2.3
- Java 8 or later

## Entities

The API has the following entity:

### Contact

Represents a contact with the following attributes:

- `id`: unique identifier for the contact
- `firstName`: first name of the contact
- `lastName`: last name of the contact
- `email`: email address of the contact
- `phone`: phone number of the contact
- `type`: type of contact (e.g. personal, business)
- `gender`: gender of the contact (e.g. male, female)

## Endpoints

The API has the following endpoints:

### 1. GET `/contacts`

Returns a list of all contacts in the repository.

### 2. GET `/contacts/{id}`

Returns the contact with the given `id`. Returns an empty `Contact` object if the contact is not found.

### 3. POST `/contact`

Creates a new contact in the repository with the given details.

### 4. PUT `/contacts/{id}`

Updates the contact with the given `id` with the provided details.

### 5. DELETE `/deleteContacts/{id}`

Deletes the contact with the given `id` from the repository.

### 6. GET `/`

Redirects to the root URL.

## Usage

To use the API, follow these steps:

1. Clone the repository to your local machine.
2. Run the application using your preferred Java IDE or by running the following command from the project directory:`

```
./mvnw spring-boot:run

```

3. Make HTTP requests to the endpoints listed above using a tool like Postman.

## Author

This file was written by Abderrahim Ettounani.
