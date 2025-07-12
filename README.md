# 📚 Library Book Catalog API

A simple Java Spring Boot RESTful API to manage a library's book catalog.

This system allows:
- Adding a new book
- Retrieving the list of all books
- Getting details of a book by its ID
- Deleting a book
- Updating availability of the book

---

## 🚀 Tech Stack

- Java 21+
- Spring Boot
- Spring Data JPA
- MySQL database

---

## 📦 Features

Each book has:
- `id` (Integer)
- `title` (String)
- `author` (String)
- `isbn` (String)
- `available` (Boolean)

---

## ⚙️ How to run the project

1️⃣ **Clone the repository:**
```bash
git clone https://github.com/megha0705/book-library
cd book-library
```

2️⃣ **Configure database**:

To use Database (using MySql in this case) , update src/main/resources/application.properties:

properties
```
spring.datasource.url=jdbc:mysql://host_name:port_number/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
3️⃣ **Build and run the app**:

bash
```
./mvnw spring-boot:run
```
🧪 Sample Requests & Expected Responses

✅ Add a new book

POST /book/add

Request Body:

json
```
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565"
}
```
Response:

json
```
{
  books added successfully
}
```
✅ Retrieve all books

GET /book/getAll

Response:

json
```
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "9780743273565",
    "available": true
  }
]
```
✅ Get book by ID

GET /book/get/1

Response:

json
```
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565",
  "available": true
}
```
✅ Delete a book

DELETE /book/1

Response:

json
```
{
Book deleted successfully
}
```
✅ Update availability

PUT /books/update/1

Request (form-data):
```
Key         |	Value
availability |	true
```

Response:

json
```
{
Book availability updated successfully
}
```


## ✅  Input Validation
 
Title, Author, and ISBN cannot be blank
