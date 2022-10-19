This is a simple to-do list project done for a technical test to showcase knowledge using Spring, PostgreSQL and React.

Tools used/required:

- Some IDE application
- Postman application to test routes implemented
- SQL Shell (psql) to test, create and manage database created

The following routes were implemented and tested:

api/person POST -> inserts person into database with parameters
api/person/id GET -> retrieves person with requested ID
api/person/id DELETE -> removes person with requested ID

api/todo GET -> retrieves list of todos in database
api/todo POST -> inserts todo in database
api/todo/id DELETE -> deletes todo with requested ID

To run:

1. Main class (ListApplication.java) needs to run first.
2. Once main class is running then the routes can be tested