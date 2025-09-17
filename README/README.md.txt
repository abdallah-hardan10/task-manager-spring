 Task Manager - Spring Boot Web Application

  Description
This project is a Task Manager Web Application built with:
- Back-End: Java Spring Boot + Spring Security + JPA/Hibernate  
- Front-End: HTML, CSS, JavaScript  
- Database: MySQL   

The application allows users to register, log in, and manage their tasks (Add, Edit, Delete, Mark as Completed/Pending) with filtering options (All / Completed / Pending).  

---

 Getting Started

1. Clone the Repository

git clone <repository-link>


2. Open the Project :
Open the project using IntelliJ IDEA or any IDE that supports Spring Boot.

3. Database Setup:

Create a new schema in MySQL with name "Task".

4. Run the Project:
Run the project from your IDE

5. Access the Website:
http://localhost:8080/auth/login


📑 Features

✅ User Registration & Login
✅ Add / Edit / Delete Tasks
✅ Mark Tasks as Completed or Pending
✅ Filter Tasks (All / Completed / Pending)
✅ Responsive UI for desktop & mobile
🌙 Optional: Dark/Light Mode

🛠️ Requirements

To run this project, you need:

Java JDK 17+
Maven
MySQL (or H2 for quick testing)
IntelliJ IDEA / Eclipse



📂 Project Structure
src/
 ├─ main/
 │   ├─ java/com/example/taskmanager/
 │   │   ├─ controller/    → Controllers (Auth + Tasks)
 │   │   ├─ model/         → Entities (User, Task)
 │   │   ├─ repository/    → JPA Repositories
 │   │   ├─ service/       → Business Logic
 │   │   └─ TaskManagerApplication.java
 │   │
 │   └─ resources/
 │       ├─ static/        → CSS, JS, Images
 │       ├─ templates/     → HTML Pages (Thymeleaf)
 │       └─ application.properties
 │
 └─ test/                  → Unit Tests
















