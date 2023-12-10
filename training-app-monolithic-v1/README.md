## Monolithic Training Application

This is a sample application used for training reasons. The domain model consists of 4 basic entities: Users,
Customers Contracts and AuditLog and the target is to represent a monolithic application design with a tightly coupled model over
a relational database.

### Software Stack

1. Java 17
2. Gradle 8.5
3. Spring Boot 3.2.x
4. Spring Security 
5. JPA - Hibernate (ORM)
6. Flyway (Database Bootstrapping)
7. Postgres (Database)
8. Docker (application packaging)
9. Docker Compose

### Summary

This project has 4 main entities:
1. Customer - A sample customer entity with basic fields and a link to contracts
2. Contract - A sample contract entity with basic fields
3. AuditLog - for logging at db any change of the application state
4. User - for accessing the system. The security mechanism us built on top of this

The main purpose of this project is the following:

1. ORM model and how this is working against the database interactions (find, save etc)
2. CRUD API design for all the entities
3. How transactions are configured
4. The correct way of converting DTOs, to prevent exposing the domain model to the API
5. How Spring Security is configured with basic authentication
6. How APIs are secured with permissions
7. How passwords are secured using encryption
8. How docker is used in order to package a Spring Boot app
9. How docker-compose configuration is used, so that services depending on others can be bootstrapped
