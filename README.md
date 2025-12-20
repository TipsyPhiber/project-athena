# 🏛️ Project Athena
### Enterprise Resource Planning (ERP) Platform

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green) ![Angular](https://img.shields.io/badge/Angular-16-red)

**Project Athena** is a multi-tenant resource management system designed to modernize legacy infrastructure. It creates a centralized dashboard for tracking enterprise assets (Servers, Databases, Licenses) using a decoupled microservices architecture.

---

## 🏗️ System Architecture

The platform separates concerns between a robust RESTful backend and a dynamic reactive frontend.

### 1. Backend: The Core Engine (Java & Spring Boot)
* **Technology:** Java 17, Spring Web, Spring Data JPA.
* **Role:** Handles business logic, data persistence, and tenant isolation.
* **Key Feature:** Implements **RESTful APIs** that exchange strict JSON payloads, ensuring standardized communication with client applications.

### 2. Frontend: The User Interface (Angular)
* **Technology:** Angular 16, TypeScript, Bootstrap.
* **Role:** Renders a Single Page Application (SPA) for dynamic user interaction.
* **Key Feature:** Uses **Reactive Forms** and component-based architecture to manage state without reloading the page.

### 3. CI/CD & Automation (Azure DevOps)
* **Technology:** Azure Pipelines (`azure-pipelines.yml`).
* **Role:** Orchestrates the build lifecycle.
* **Workflow:**
    1.  **Commit:** Developer pushes code to `main`.
    2.  **Test:** Maven runs JUnit tests (TDD validation).
    3.  **Build:** Compiles the Java JAR and Angular static assets.

---

## 🛠️ Technical Highlights

### ✅ Multi-Tenant Architecture
The data model (`Resource.java`) includes a `tenantId` field, allowing a single instance of the application to securely serve multiple distinct organizations (Tenant-A, Tenant-B) while keeping their data isolated.

### ✅ Test-Driven Design (TDD)
Business logic is validated using **JUnit 5**. The pipeline automatically rejects any commit that fails the test suite, ensuring high reliability for the core API controllers.

### ✅ RESTful API Standards
The `ResourceController` follows strict HTTP conventions:
* `GET /api/v1/resources` - Retrieves standardized JSON lists.
* `POST /api/v1/resources` - Accepts strict DTO schemas for resource creation.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 17+
* Node.js & NPM (v18+)
* Maven

### 1. Run the Backend
```bash
cd backend
mvn spring-boot:run
