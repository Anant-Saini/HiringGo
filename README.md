# HiringGo

HiringGo is a Spring Boot-based job search web application built as a learning project to practice backend development with Java, REST-style APIs, persistence, security, and AOP.

The project focuses on implementing core backend features in a simple and practical way without overstating scope or complexity.

## Tech Stack

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- PostgreSQL
- Lombok
- Maven

## Project Modules / Areas

### 1. JobPost Management
The project includes CRUD functionality for the `JobPost` entity. This was added as a core learning step to understand how entity, repository, service, and controller layers work together in a Spring Boot application.

### 2. Search Functionality
A job search feature was added to support searching job-related data. This helped in practicing request handling and backend filtering/query flow.

### 3. Data Loading
A data loading feature was added to populate or initialize application data. This was useful for working with sample data during development and testing.

### 4. Security Layer
Spring Security and an authentication layer were added in a later stage of the project. This helped in understanding how application security can be introduced into a backend project.

### 5. AOP Learning
The project also includes Aspect-Oriented Programming concepts through separate aspect classes for:
- Validation
- Performance monitoring
- Logging

This was added to learn how cross-cutting concerns can be handled cleanly outside the core business logic.

## Features Implemented

- Spring Boot project setup
- `JobPost` entity-based backend flow
- CRUD operations for job posts
- Job search feature
- Data loading feature
- Spring Security integration
- Authentication layer
- AOP-based validation aspect
- AOP-based performance aspect
- AOP-based logging aspect

## Dependencies Used

The Maven configuration currently includes:
- `spring-boot-starter-webmvc`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `postgresql`
- `lombok`
- `jackson-dataformat-xml`
- `spring-boot-starter-webmvc-test`

## How to Run

### Prerequisites
- Java 21
- PostgreSQL
- Maven  
  or Maven Wrapper included in the project

### Clone the repository

```bash
git clone https://github.com/Anant-Saini/HiringGo.git
cd HiringGo
```

### Run the application

On Linux/macOS:
```bash
./mvnw spring-boot:run
```

On Windows:
```bash
mvnw.cmd spring-boot:run
```

## Learning Focus

This project was built to improve practical understanding of:
- backend application structure in Spring Boot,
- CRUD API development,
- JPA-based persistence,
- security and authentication basics,
- and AOP for cross-cutting concerns.

It is a learning-oriented project, so the implementation is intentionally simple and focused on fundamentals.

## Author

Anant Saini
