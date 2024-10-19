# Spring Boot Category and Product CRUD

This is a Spring Boot project for managing Categories and Products, implementing CRUD operations and pagination.

## Features
- Create, read, update, and delete categories and products.
- Server-side pagination for efficient data retrieval.
- One-to-Many relationship between Category and Product entities.

## Technologies Used
- Spring Boot
- JPA & Hibernate
- MySQL
- Maven
- RESTful APIs

## Setup

### Prerequisites
- Java 11+
- MySQL (or another relational database)
- Maven

### Steps to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/springboot-category-product-crud.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd springboot-category-product-crud
   ```

3. **Configure the database**:
   
   Update the `application.properties` or `application.yml` file with your MySQL details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Run the Spring Boot application**:
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the APIs**:
   
   The APIs will be available at:
   ```
   http://localhost:8080/api/
   ```

## API Endpoints

### Category APIs
- **POST** `/api/categories` - Create a new category.
- **GET** `/api/categories?page=0&size=5` - Retrieve all categories with pagination.
- **GET** `/api/categories/{id}` - Retrieve a category by ID.
- **PUT** `/api/categories/{id}` - Update a category by ID.
- **DELETE** `/api/categories/{id}` - Delete a category by ID.

### Product APIs
- **POST** `/api/products` - Create a new product.
- **GET** `/api/products?page=0&size=5` - Retrieve all products with pagination.
- **GET** `/api/products/{id}` - Retrieve a product by ID, including category details.
- **PUT** `/api/products/{id}` - Update a product by ID.
- **DELETE** `/api/products/{id}` - Delete a product by ID.

## Database Design

### Tables:
**Category**:
- `id`: Primary Key (BIGINT)
- `name`: Name of the category (VARCHAR)

**Product**:
- `id`: Primary Key (BIGINT)
- `name`: Name of the product (VARCHAR)
- `price`: Price of the product (DECIMAL)
- `category_id`: Foreign Key referencing `category.id`

### Entity Relationship:
- **One-to-Many**: One category can have multiple products.
- **Many-to-One**: Each product belongs to one category.


