# Non-Functional Requirements

## 1. Performance

### 1.1. API Response Time
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure high speed of API request processing to minimize waiting time for mobile application users.
* **Parameters:** API response time not exceeding 500 ms for simple requests, not exceeding 1 second for complex requests with data aggregation.
* **Requirement Priority:** High.

### 1.2. Database Query Optimization
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure efficient database operations for fast retrieval of viewing and movie data.
* **Parameters:** Use of indexes for frequently used fields, SQL query optimization.
* **Requirement Priority:** High.

### 1.3. Data Caching
* **Requirement Source:** Developers.
* **Requirement Description:** Implement caching of frequently requested data to reduce database load.
* **Parameters:** Caching of static movie information, search results, user statistics.
* **Requirement Priority:** Medium.

## 2. Reliability

### 2.1. System Stability
* **Requirement Source:** Developers.
* **Requirement Description:** Guarantee stable backend operation without failures and unavailability.
* **Parameters:** API availability not less than 99% of the time.
* **Requirement Priority:** High.

### 2.2. Error Handling
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure proper error handling and return of clear HTTP statuses and error messages.
* **Parameters:** All errors are logged, API returns structured responses with error codes (400, 401, 404, 500, etc.).
* **Requirement Priority:** High.

### 2.3. Data Backup
* **Requirement Source:** System administrators.
* **Requirement Description:** Ensure regular database backups to prevent data loss.
* **Parameters:** Automatic backup at least once per day.
* **Requirement Priority:** Medium.

## 3. Security

### 3.1. User Data Protection
* **Requirement Source:** Developers, product owner.
* **Requirement Description:** Ensure confidentiality and security of user application data.
* **Parameters:** Use of HTTPS for all connections, protection against SQL injections, input data validation.
* **Requirement Priority:** High.

### 3.2. Authentication and Authorization
* **Requirement Source:** Developers.
* **Requirement Description:** Implement a secure user authentication and authorization system using Keycloak.
* **Parameters:** Integration with Keycloak for user and token management, token validation on each request, role-based access control (user, administrator).
* **Requirement Priority:** High.

### 3.3. API Protection
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure API protection against unauthorized access and attacks.
* **Parameters:** Rate limiting (request count limitation), protection against CSRF and XSS attacks, input data validation.
* **Requirement Priority:** High.

## 4. Scalability

### 4.1. Horizontal Scaling
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure the possibility of horizontal backend scaling to support user growth.
* **Parameters:** Architecture allows adding additional servers when load increases.
* **Requirement Priority:** Low (for educational project).

### 4.2. Large Data Volume Optimization
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure efficient system operation with growing number of database records.
* **Parameters:** Table indexing, query optimization for large data retrieval.
* **Requirement Priority:** Medium.

## 5. Compatibility and Integration

### 5.1. API Documentation
* **Requirement Source:** Developers.
* **Requirement Description:** Provide complete API documentation for mobile application development.
* **Parameters:** Documentation describing all endpoints, request parameters, response formats, and usage examples.
* **Requirement Priority:** High.

### 5.2. External Service Integration
* **Requirement Source:** Developers.
* **Requirement Description:** Ensure reliable integration with external APIs (TMDb) to retrieve movie information.
* **Parameters:** External service error handling, response caching, fallback mechanisms when API is unavailable.
* **Requirement Priority:** Medium.

## 6. Maintainability

### 6.1. Code Quality
* **Requirement Source:** Developers, course instructors.
* **Requirement Description:** Ensure high code quality to simplify project support and development.
* **Parameters:** Compliance with Kotlin code conventions, use of meaningful naming, commenting of complex logic.
* **Requirement Priority:** High.

### 6.2. Logging
* **Requirement Source:** Developers.
* **Requirement Description:** Implement a logging system for tracking application operation and problem diagnostics.
* **Parameters:** Logging of all important events, errors, API requests with different levels (INFO, WARN, ERROR).
* **Requirement Priority:** High.

### 6.3. Testability
* **Requirement Source:** Developers, course instructors.
* **Requirement Description:** Ensure code testability at different levels.
* **Parameters:** Unit test coverage of core business logic, integration tests for API endpoints.
* **Requirement Priority:** Medium.