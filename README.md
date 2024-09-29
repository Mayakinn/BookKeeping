# BookKeeping
Spring boot REST API made for storing information about books. 

### Before running the code
It's is important to have a database up and running. In this project I used a MySQL server with a database uploaded with the MySQL Workbench. There's an SQL dump, that I have left next to the README file. After setting everything up, you need to change these properties in the application.properties file - spring.datasource.username=(YOUR USERNAME), spring.datasource.password=(YOUR PASSWORD).

### Dependencies I've used
Lombok,
Spring Web,
Thymeleaf,
JDBC API,
Spring Data JPA,
H2 Database,
MySQL Driver,
CycloneDX SBOM support.

### After running the code
Paste this into your web browser - http://localhost:8080/books.

### How to use
When in the .../books page, there is a table of different books with information about them. Above the table there are text boxes to type in the criteria to filter all the books. After typing in the criteria, press the "Filter" button. On the side of the table there's also a Update Rating Column, where in each line you can change the ratings of books. Just type the rating in the text box or press the arrow buttons (Numbers only between 1 to 5). When you are satisfied with the rating, press "Update Rating", it will change the books rating in the table and also in the database.
