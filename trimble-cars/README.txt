Trimble Cars Assignment

Tech Stack:
- Java 21
- Spring Boot 3.5.0
- Gradle
- H2 In-Memory Database
- Postman for API testing

How to Run:
1. Open the project in Spring Tool Suite (STS) or IntelliJ
2. Run `TrimbleCarsApplication.java`
3. Access H2 Console:
   - URL: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:trimblecarsdb
   - User: sa
   - Password: (leave blank)
4. Use Postman to test endpoints (see included Postman collection)

Main Features:
- Register Users (Admin, Owner, Customer)
- Add Cars and Filter Cars by Status (IDLE, ON_LEASE, ON_SERVICE)
- Start and End Leases
- Lease limit: Max 2 cars per customer
- Input validation and clean error handling

Postman Collection: included in the zip file.
