# Project Stages

## 1. Initiation

* **Description:** At this stage, the project is defined at a general level. Initial resources, timelines, and overall goals are determined.
* **Key Activities:**
    * Defining the Vulpecula project concept as an educational movie diary application
    * Identifying stakeholders (users, developer, course instructors)
    * Formulating main goals: creating a Kotlin backend for managing movie viewing diary
    * Defining technology stack (Kotlin, Ktor, AWS, DynamoDB, Keycloak, TMDb API)

## 2. Planning

* **Description:** Detailed planning is conducted to define clear objectives, scope of work, timelines, and project architecture.
* **Key Activities:**
    * Creating a detailed project plan and breaking it into stages (course homework assignments)
    * Developing technical documentation (requirements, architecture, API)
    * Designing data structure for DynamoDB and defining entities
    * Planning integrations (Keycloak for authentication, TMDb for movie data)
    * Planning AWS infrastructure (Lambda, API Gateway, DynamoDB)
    * Risk assessment (external API unavailability, Keycloak integration complexity, AWS limits)
    * Defining acceptance criteria and test scenarios

## 3. Execution

* **Description:** The project plan is brought to life, the backend application is developed, and tasks are executed to achieve project goals.
* **Key Activities:**
    * Developing backend API in Kotlin using Ktor framework
    * Setting up AWS infrastructure (DynamoDB tables, Lambda functions, API Gateway)
    * Implementing CRUD operations for diary entries
    * Integrating with Keycloak for authentication and authorization
    * Integrating with TMDb API for searching and caching movie information in DynamoDB
    * Developing business logic (statistics, filtering, multiple viewings)
    * Writing unit and integration tests
    * Regular Git commits and documentation updates
    * Completing course homework assignments according to the curriculum

## 4. Monitoring and Control

* **Description:** Continuous measurement of development progress, functionality testing, and code quality management.
* **Key Activities:**
    * Monitoring code compliance with Kotlin code conventions
    * Testing API endpoints (unit tests, integration tests)
    * Checking performance (API response time < 500 ms)
    * Monitoring AWS resources (CloudWatch logs, Lambda metrics)
    * Security control (correct authentication operation, data protection)
    * Code review and refactoring
    * Managing changes in requirements (adding new features, adjusting existing ones)
    * Receiving feedback from course instructors

## 5. Closure

* **Description:** Completing all project activities, deploying the application, and preparing for defense.
* **Key Activities:**
    * Final testing of all functions
    * Deploying application to AWS production environment
    * Preparing complete project documentation (README, API docs, architecture, AWS setup)
    * Formal acceptance of results by course instructors
    * Project presentation and defense
    * Documenting lessons learned (challenges, solutions, best practices)
    * Project completion report