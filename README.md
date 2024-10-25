# User Authentication and Email Verification System

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Modules and Packages](#modules-and-packages)
  - [1. Configuration](#1-configuration)
  - [2. Controllers](#2-controllers)
  - [3. Services](#3-services)
  - [4. Security](#4-security)
- [Installation](#installation)
- [Usage](#usage)

## Project Overview
This project is a user authentication and email verification system built using Spring Boot. It provides a robust solution for user registration, login, and email verification, employing JWT (JSON Web Token) for secure authentication. The system is designed to be scalable and easily extendable, making it suitable for various applications.

### Key Features
- User registration and login functionality
- Email verification with unique verification codes
- Secure password handling using BCrypt
- JWT-based authentication for stateless sessions
- CORS support for cross-origin requests

## Technologies Used
- **Java**: Programming language used for development.
- **Spring Boot**: Framework for building Java-based applications.
- **Spring Security**: Module for securing applications.
- **Hibernate**: ORM tool for database interaction.
- **JavaMailSender**: For sending email notifications.
- **JWT**: For secure token-based authentication.

## Modules and Packages

### 1. Configuration
This module handles the application configuration, including bean definitions and security settings.

- **ApplicationConfiguration**: Configures user-related beans, password encoding, and authentication management.
- **EmailConfiguration**: Configures the email sender using JavaMailSender for sending verification emails.

### 2. Controllers
The controllers handle incoming HTTP requests and provide appropriate responses.

- **AuthenticationController**: Manages user authentication processes, including signup, verification, and login.
- **UserController**: Handles user-related operations such as fetching the authenticated user's details and listing all users.

### 3. Services
Services contain the business logic for the application, interacting with repositories and other components.

- **AuthenticationService**: Manages user registration, login, verification, and resending verification codes.
- **EmailService**: Handles the sending of verification emails to users.
- **JwtService**: Manages JWT token creation, extraction, and validation.
- **UserService**: Provides methods for retrieving user data from the database.

### 4. Security
This module configures the security of the application.

- **JwtAuthenticationFilter**: Intercepts incoming requests to authenticate users based on JWT tokens.
- **SecurityConfiguration**: Configures HTTP security, session management, and CORS settings.

## Installation
To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/projectname.git
   cd projectname

2. **Set up environment variables: Create a secrets.properties file in the root directory and define the necessary configurations, such as email credentials and JWT secret key.**
3. **Build and run the project.**

## Usage
Once the application is running, you can interact with the following endpoints:

-POST /api/auth/signup: Register a new user.

![Screenshot 2024-10-26 003729](https://github.com/user-attachments/assets/cf6752c0-3b9c-4d93-a791-38a1a5b81400)

-POST /api/auth/verify: Verify the user's account using a verification code.

![verify](https://github.com/user-attachments/assets/f6cf640e-855a-474b-aecd-6a3054a335cc)

-POST /api/auth/login: Log in and receive a JWT token.

![Screenshot 2024-10-26 003127](https://github.com/user-attachments/assets/d5ddfffe-be1f-4396-b657-f92f2417f0c0)

-POST /api/auth/resend: Resend the verification code to the user's email.

![Screenshot 2024-10-26 003801](https://github.com/user-attachments/assets/cc17f1e9-8082-42c2-b23d-d33b42962965)


-GET /users/me: Retrieve details of the authenticated user.

![Screenshot 2024-10-26 003118](https://github.com/user-attachments/assets/b435ab2c-dcc1-4280-b8ec-3f7862b7c4b8)

-GET /users/: Get a list of all users.`
