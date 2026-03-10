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
- Custom Queries with @Query and JPQL
- Method Name Queries (findByName, findByEmail, findByAgeGreaterThan)
- Search APIs
- Global Exception Handling
- DTO Pattern
- Swagger Documentation

## API Endpoints

### Books
- GET /books — Get all books (paginated)
- POST /books — Add new book
- PUT /books/{id} — Update book
- DELETE /books/{id} — Delete book
- GET /books/search?title={title} — Search by title
- GET /books/cheaper?price={price} — Filter by price

### Users
- GET /users — Get all users
- POST /users — Add new user
- PUT /users/{id} — Update user
- DELETE /users/{id} — Delete user
- GET /users/email/{email} — Find by email
- GET /users/name/{name} — Find by name
- GET /users/age/{age} — Find users older than age

### Orders
- POST /orders/user/{userId} — Add order for user
- GET /orders/user/{userId} — Get all orders of user
- DELETE /orders/{orderId} — Delete order

## Project Structure
```
src/main/java/com/example/bookapi/
├── controller/    — REST endpoints
├── service/       — Business logic
├── repository/    — DB queries
├── model/         — JPA entities
├── dto/           — Data Transfer Objects
├── exception/     — Custom exceptions
└── config/        — App configuration
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
- Day 9: OneToMany + ManyToOne Relationships
- Day 10: Custom Queries, @Query, JPQL
- Day 11: Search APIs, Method Name Queries

## Sample Request & Response

### Add a Book
```json
POST /books
{
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "price": 599.99
}
```

### Response
```json
{
  "id": 1,
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "price": 599.99
}
```

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

5. Swagger UI open karo
   http://localhost:8080/swagger-ui/index.html

## Author
- Dhawal Sharma
- MCA Graduate
- GitHub: github.com/DhawalDevX