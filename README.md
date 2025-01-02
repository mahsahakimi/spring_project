## Spring Boot Customer API Documentation

This document outlines the API endpoints for a Spring Boot application managing customer data.

**Base URL:** `http://localhost:8080/api/v1/customers`

**API Endpoints:**

*   **GET /:** Retrieves all customers.
*   **GET /{email}:** Retrieves a customer by email.
*   **POST /:** Adds a new customer. (Request body required)
*   **PUT /{customer_id}:** Updates a customer. (Request body required)
*   **DELETE /{customer_id}:** Deletes a customer.

**Usage:**

1.  **Set Up Database:**
    *   Install and configure a PostgreSQL database server.
    *   Update the `application.properties` file (located in `src/main/resources`) with your database connection details (host, port, username, password, etc.).

2.  **Run the Application:**
    *   Ensure you have Maven installed.
    *   The provided path `src/main/java/edu/sharif/web/Main.java` is the main application class. You can directly run this class in your IDE to start the application.
