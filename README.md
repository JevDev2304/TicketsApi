# 🎟️ MyTicket - Backend API

**MyTicket** is a backend system developed with **Java Spring Boot**, using **JPA** for data persistence and **MySQL** as the relational database.

The system allows users to view and purchase tickets for different events. Event and ticket data are managed internally, and all user interactions are handled via RESTful endpoints documented in Swagger.

---

## ✅ Main Features

- **User Management:** Create and retrieve users (without profile images).
- **Event Browsing:** View recent events, search by name, filter by category, and view event details.
- **Ticket Handling:**
  - Tickets are generated in bulk from the database using a stored procedure.
  - Users can purchase available tickets.
  - Ticket details include type, event, and category.
  - See available ticket types per event.
- **Email Notifications:**
  - When a ticket is purchased, an email is sent to the user with ticket details.
  - A **QR code**, generated via an **external API**, is included in the email.
  - Email is sent using **JavaMailSender** configured with **Gmail SMTP**.

---

## 🔧 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- JavaMailSender (Gmail)
- External QR Code API
- Swagger for API documentation

---

## 📌 Notes

- Events and tickets are **not** created via the frontend.
- All available API endpoints and request formats are documented in the **Swagger UI**.
