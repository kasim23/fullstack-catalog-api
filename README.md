# Evolution of an E-Commerce Backend
A deep-dive transition from **Manual JDBC** to **Spring Boot Microservices**.

## 🚀 The Mission
This project documents my journey of building a production-grade retail system.
I started by manually implementing the **Data Access Layer** to master the
mechanics of SQL connectivity before migrating to the Spring Ecosystem.

## 🛠 Tech Stack
- **Language:** Java 17
- **Database:** PostgreSQL
- **Connectivity:** JDBC (Initial Phase) -> Spring Data JPA (Planned)
- **Architecture:** Layered Pattern (Model-Repository-Service)

## 🏗 Current Progress: Manual JDBC Layer
- [x] Schema & Identity Management (PostgreSQL Schemas)
- [x] POJO Mapping (Data Integrity & Constructors)
- [x] Repository Pattern (CRUD operations with PreparedStatements)
- [ ] Service Layer Integration (In Progress)

## 💡 Key Learnings
- Managing the **Result Set cursor** and mapping relational data to Java Objects.
- Preventing **SQL Injection** via Parameterized Queries.
- Designing **Many-to-Many** relationships with Join Tables (`order_items`).