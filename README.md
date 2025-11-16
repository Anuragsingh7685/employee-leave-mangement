# Employee Leave Management System – Spring Boot

A simple and practical backend application built with **Java** and **Spring Boot** to manage employee leave requests. This project helps employees apply for leave easily and allows managers/admins to review and take action on requests.

## 🚀 Features
- Apply for leave
- View leave history
- Manager/Admin approval & rejection
- Leave statuses: PENDING, APPROVED, REJECTED
- MySQL + JPA/Hibernate
- Clean Controller → Service → Repository architecture

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Maven
- Lombok

## 📁 Project Structure
src/
 └── main/
     ├── java/com/example/employeeleavemanagement/
     ├── resources/application.properties

## ⚙️ How to Run
mvn clean install  
mvn spring-boot:run  
Server: http://localhost:8080

## 🔗 API Endpoints
- POST /api/leaves/apply/{employeeId}
- GET /api/leaves/employee/{employeeId}
- GET /api/leaves/all
- PUT /api/leaves/{leaveId}/status?status=APPROVED
