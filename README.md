# CRM Project

This project is a Customer Relationship Management (CRM) application developed for private education course centers. The application enables users to manage customer information, with a focus on student tracking, tariff management, and viewing mock exam results.

## Technologies and Tools

- **Java 17:** The main programming language of the project.
- **Spring Boot:** A framework used to create Java projects quickly and easily.
- **Maven:** A project management tool used to manage project dependencies and simplify project configuration.
- **IntelliJ IDEA:** An integrated development environment (IDE) used to develop Java projects.
- **MySQL:** The database management system.
- **Postman:** A tool used for API testing and documentation.

## Project Structure

The project is developed following the principles of layered architecture. The main packages are:

- `com.CRM.crm.User`: Classes and operations related to users.
- `com.CRM.crm.Customer`: Classes and operations related to customers.
- `com.CRM.crm.Auth`: Authentication and authorization operations.
- `com.CRM.crm.Email`: Email sending operations.
- `com.CRM.crm.Error`: Error handling classes.
  
# Development Environment and Requirements
## Java 17
This project is developed using Java 17. If Java is not installed on your computer, you can download and install the official Oracle JDK or the open-source OpenJDK version from [here](https://www.oracle.com/java/technologies/javase-downloads.html) or [here](https://adoptopenjdk.net/).

## IntelliJ IDEA
The integrated development environment (IDE) used to develop and run the project is IntelliJ IDEA. If you don't have this IDE installed, you can download it from the [official website](https://www.jetbrains.com/idea/download/).

## MySQL
The database management system used in the project is MySQL. If MySQL is not installed on your computer, you can download it from the [MySQL Download Page](https://dev.mysql.com/downloads/) or use any other preferred database management tool. Additionally, using MySQL Workbench is recommended.

## Postman
Postman is the tool used for API testing and testing the application. You can download Postman from the [official website](https://www.postman.com/downloads/).

## Maven
Apache Maven is used to manage project dependencies and facilitate project configuration. If Maven is not installed on your computer, you can download it from the [Maven Download Page](https://maven.apache.org/download.cgi).

## GitHub
To access the project source code, clone the project, or contribute to the project, you need to have a GitHub account. If you don't have a GitHub account, you can [sign up on GitHub](https://github.com/).

After acquiring the above tools, you can successfully run the project and start development. If you have any questions or need assistance, please feel free to let us know.

## How to Run

1. Clone the GitHub repository of the project.
2. Open the project using IntelliJ IDEA or your preferred IDE.
3. Update the `application.properties` file to set your MySQL connection details.
4. Run the project.

## API Endpoints

- `POST /api/v1/users`: Create a new user.
- `PATCH /api/v1/users/{token}/active`: Activate the user's account.
- `GET /api/v1/users`: Retrieve users with pagination.
- `POST /api/v1/customersave`: Create a new customer.
- `GET /api/v1/customers`: Retrieve customers with pagination.
- `POST /api/v1/auth`: Authenticate the user.

## Project Details

### User Management

The application allows users to register, activate their accounts, and log in. Users have different roles (e.g., administrator and teacher) with different permissions.

### Customer Management

The customer management section allows entering customer information, selecting tariffs, and tracking mock exam results for students. Additionally, there are capabilities to edit and delete customer information.

### Authentication and Authorization

The project uses basic HTTP authentication and a custom token-based authorization system. Users gain access to specific API endpoints by obtaining a token.

## How to Contribute

If you want to contribute to the project, please fork and submit a pull request. During the development process, please read the [contribution guide](CONTRIBUTING.md).

## License

This project is licensed under the [MIT license](LICENSE).
