# Project Athena 🏛️
### Enterprise Resource Planning (ERP) Platform

**Project Athena** is a multi-tenant resource management system designed to migrate legacy Ruby-on-Rails logic into a modern, scalable **Java** architecture. It features a responsive **Angular** frontend and utilizes **Azure DevOps** for continuous integration.

### 🛠 Tech Stack
* **Backend:** Java (Spring Boot), RESTful APIs
* **Frontend:** Angular, TypeScript, HTML5, JavaScript
* **Infrastructure:** Azure Cloud Services, Docker
* **Data:** JSON Data Interchange, SQL Database
* **CI/CD:** Azure Pipelines

### 📂 Architecture
* `backend/`: Contains the **Java Spring Boot** microservices handling business logic.
* `frontend/`: The **Angular** single-page application (SPA) serving the user interface.
* `config/`: JSON configuration files for database schema definitions.

### 🚀 Usage
To run the full stack locally:
```bash
# Start Backend
cd backend
mvn spring-boot:run

# Start Frontend
cd frontend
npm start
```
