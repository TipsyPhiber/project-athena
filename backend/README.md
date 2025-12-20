# 🏛️ Project Athena: Enterprise Resource Platform

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Java](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green) ![Angular](https://img.shields.io/badge/Angular-16-red) ![License](https://img.shields.io/badge/license-MIT-blue)

**Project Athena** is a comprehensive multi-tenant resource management system designed to modernize legacy infrastructure. It serves as a centralized "Command Center" for tracking enterprise assets (Servers, Databases, Licenses) using a decoupled microservices architecture.

---

## 🚀 Quick Start Guide

Follow these steps to get the application running in **Simulation Mode** on your local machine.

### 1. Clone the Repository
```bash
git clone https://github.com/TipsyPhiber/project-athena.git
cd project-athena
```

### 2. Start the Backend API (Java)
**Prerequisite:** You must have **Java 21 JDK** installed (not just the JRE).
* *Linux:* `sudo apt install openjdk-21-jdk-headless`
* *Mac:* `brew install openjdk@21`

Run the server:
```bash
cd backend
mvn spring-boot:run
```
* **Status:** API will be available at `http://localhost:8080`.
* **Note:** By default, this runs with an in-memory database for rapid testing.

### 3. Start the Frontend Dashboard (Angular)
Open a **new terminal window** to launch the user interface.
```bash
cd frontend
npm install
npm start
```
* **Status:** The UI will launch at `http://localhost:4200`.
* **Action:** Open your browser to view the dashboard.

---

## 🔌 Production Integration Guide

**Note:** The default configuration runs in "Dev/Simulation Mode" using mock data to demonstrate UI capabilities without requiring a local database server.

To deploy this application to a live **Production Environment** (e.g., AWS, Azure), apply the following configurations:

### Step 1: Connect a Real Database
Locate `backend/src/main/resources/application.properties` and update the datasource to point to your live PostgreSQL cluster:

```properties
# Production Database Connection
spring.datasource.url=jdbc:postgresql://<YOUR_DB_HOST>:5432/athena_db
spring.datasource.username=admin_user
spring.datasource.password=${DB_PASSWORD_ENV_VAR}

# Auto-update Schema
spring.jpa.hibernate.ddl-auto=update
```

### Step 2: Enable JPA Repositories
In `ResourceController.java`, uncomment the Repository injection to disable mock data and enable live SQL persistence:

```java
// @Autowired
// private ResourceRepository repository;

// Change getAllResources() to return repository.findAll();
```

---

## 🏗️ System Architecture

The platform separates concerns between a robust RESTful backend and a dynamic reactive frontend.

### 1. Backend: The Core Engine (Java & Spring Boot)
* **Technology:** Java 21, Spring Web, Spring Data JPA.
* **Role:** Handles business logic, data persistence, and tenant isolation.
* **Key Feature:** Implements **RESTful APIs** that exchange strict JSON payloads, ensuring standardized communication with client applications.

### 2. Frontend: The User Interface (Angular)
* **Technology:** Angular 16, TypeScript, Bootstrap.
* **Role:** Renders a Single Page Application (SPA) for dynamic user interaction.
* **Key Feature:** Uses **Reactive Forms** and component-based architecture to manage state without reloading the page.

### 3. CI/CD Automation (Azure DevOps)
* **Configuration:** Defined in `azure-pipelines.yml`.
* **Workflow:**
    1.  **Commit:** Pushes to `main` trigger the pipeline.
    2.  **Test:** Maven automatically runs JUnit tests (TDD validation).
    3.  **Build:** Compiles the Java JAR and optimizes Angular static assets.

---

## 🛠️ Technical Highlights

This project demonstrates the following engineering capabilities:

* **Multi-Tenant Architecture:** The data model (`Resource.java`) includes a `tenantId` field, allowing a single instance to securely serve multiple organizations.
* **Test-Driven Design (TDD):** Business logic is validated using **JUnit 5**. The CI/CD pipeline enforces quality gates by rejecting any commit that fails the test suite.
* **Modern UI/UX:** The dashboard features a "Dark Mode" Glassmorphism design with real-time status indicators (Active vs. Migrating).

---

## 📂 Repository Structure
* `/backend` - **Spring Boot Application**
    * `src/main/java/com/athena/controller`: REST API Endpoints.
    * `src/main/java/com/athena/model`: JPA Entities (Database Schema).
* `/frontend` - **Angular SPA**
    * `src/app/resource-list`: TypeScript components and HTML templates.
* `azure-pipelines.yml` - **CI/CD Configuration**

---

## 🛡️ License
Distributed under the MIT License. See `LICENSE` for more information.
