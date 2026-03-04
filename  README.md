# Book & User Management API

A REST API built with Spring Boot as part of my 30-day learning journey.

## Tech Stack
- Java + Spring Boot
- MySQL + JPA/Hibernate
- ModelMapper
- Swagger UI
- Bean Validation

## Features
- Book CRUD with Pagination & Sorting
- User Management API
- Order Management with Relationships
- OneToMany + ManyToOne JPA Relationships
- Global Exception Handling
- DTO Pattern
- Swagger Documentation

## API Endpoints

### Books
- GET /books
- POST /books
- PUT /books/{id}
- DELETE /books/{id}

### Users
- GET /users
- POST /users
- PUT /users/{id}
- DELETE /users/{id}

### Orders
- POST /orders/user/{userId}
- GET /orders/user/{userId}
- DELETE /orders/{orderId}

## Project Structure
```
src/main/java/com/example/bookapi/
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── exception/
└── config/
```

## What I Learned
- Day 1: Controller + Service
- Day 2: Proper Structure + DTO
- Day 3: Exception Handling
- Day 4: JPA Introduction
- Day 5: Repository Layer
- Day 6: Validation
- Day 7: Pagination & Sorting
- Day 8: User Management API
- Day 9: OneToMany + ManyToOne RelationshipsELETE /users/{id}
## How to Run

### Prerequisites
- Java 17+
- MySQL
- Maven

### Setup
1. Clone the repo
   git clone https://github.com/DhawalDevX/springboot-30days.git

2. MySQL mein database banao
   CREATE DATABASE bookdb;

3. application.properties update karo
   spring.datasource.username=your_username
   spring.datasource.password=your_password

4. Run karo
   mvn spring-boot:run

5. Swagger UI
   http://localhost:8080/swagger-ui/index.html
