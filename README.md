# Shop Giày API

REST API backend for a shoe e-commerce application built with Spring Boot.

## Features

- User authentication and registration with JWT
- Product management
- Category management
- Shopping cart functionality
- Order processing
- File uploads
- Admin dashboard
- API documentation with Swagger UI

## Technology Stack

- Java 17
- Spring Boot 3.2.3
- Spring Security with JWT authentication
- Spring Data JPA
- MySQL
- Gradle
- Swagger UI for API documentation

## Local Development

### Prerequisites

- JDK 17 or higher
- MySQL
- Gradle

### Running the application

1. Clone the repository
```
git clone https://github.com/your-username/shop_giay.git
cd shop_giay
```

2. Configure the database in `src/main/resources/application.yml`

3. Build and run the application
```
./gradlew bootRun
```

4. Access the API at http://localhost:8080
5. View API documentation at http://localhost:8080/swagger-ui.html

## Deployment Instructions

### Deploying to Render.com

1. Create a free account on [Render.com](https://render.com)

2. Create a MySQL database:
   - You can use Render's PostgreSQL service or an external MySQL provider like [Railway](https://railway.app)
   
3. Create a new Web Service:
   - Connect your GitHub repository
   - Select "Use render.yaml from repository"
   - Configure the environment variables:
     - `JDBC_DATABASE_URL`: Your MySQL database URL in the format `jdbc:mysql://hostname:port/database_name`
     - `JDBC_DATABASE_USERNAME`: Database username
     - `JDBC_DATABASE_PASSWORD`: Database password
     - `JWT_SECRET`: A secure random string for JWT token signing
   
4. Deploy the service

### Deploying to Railway

1. Create a free account on [Railway](https://railway.app)

2. Create a new project and add a MySQL database

3. Add a new service from GitHub:
   - Connect your GitHub repository
   - Add environment variables:
     - `SPRING_PROFILES_ACTIVE`: prod
     - `JDBC_DATABASE_URL`: Database connection string (provided by Railway)
     - `JDBC_DATABASE_USERNAME`: Database username (provided by Railway)
     - `JDBC_DATABASE_PASSWORD`: Database password (provided by Railway)
     - `JWT_SECRET`: A secure random string for JWT token signing
   
4. Deploy the service

## API Endpoints

- Auth API: `/api/auth/**`
- User API: `/api/users/**`
- Product API: `/api/products/**`
- Category API: `/api/categories/**`
- Cart API: `/api/cart/**`
- Order API: `/api/orders/**`
- File API: `/api/files/**`
- Admin API: `/api/admin/**`
- Health API: `/api/health/**`

For detailed API documentation, check the Swagger UI at `/swagger-ui.html` 