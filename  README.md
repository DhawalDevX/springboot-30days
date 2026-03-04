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