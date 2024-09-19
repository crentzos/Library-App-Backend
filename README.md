# React Library App - Back-End

The **React Library App - Back-End** is a Spring Boot service that powers the full-stack **Library System**. It handles book management, user authentication, loan processing, review handling, and payment 
integration. The app was developed using **MySQL** in the development environment and uses **PostgreSQL** in the production environment hosted on Render.

This project connects to the **React** front-end application and integrates with external services like **Okta** for authentication and **Stripe** for payment processing.

## Key Features

- **Book Management**:
  - Admins can add, update, and delete books in the library.
  - Users can browse and search for books by category or keyword.
  
- **Loan and Return Processing**:
  - Users can borrow books and return them directly within the app.
  
- **Review System**:
  - Users can leave reviews and ratings for each book.
  - Admins have moderation capabilities for reviews.
  
- **User Profile Management**:
  - Users can view their loan history and review history.
  
- **Authentication and Authorization**:
  - Secured with **Okta**, providing both user and admin roles.
  
- **Payment Processing**:
  - Integrates with **Stripe** to handle payment processing for late fees.

## Tech Stack

- **Spring Boot**: Backend framework.
- **MySQL**: Development database.
- **PostgreSQL**: Production database.
- **Hibernate/JPA**: ORM for database management.
- **Okta**: Authentication and authorization.
- **Stripe**: Payment processing.
- **Render**: Used for deployment.

To set up and run the back-end service locally, follow these steps: 

1. Clone the Repository: 
git clone https://github.com/crentzos/Library-App-Backend.git 
cd Library-App-Backend

2. Set Up MySQL Database: Ensure you have MySQL installed locally. Use the MySQL scripts located in the Scripts folder to set up the database schema. Scripts handle all the necessary queries including database
creation.
