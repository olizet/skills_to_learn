# skills_to_learn
Skillt_to_learn is a Restful Spring application. Project is about managing tasks/skills which user want to get in a future.

## Getting started
1. First, you have to import project to your IDE.
2. Next, you have to set up server. I used local Tomcat.
3. Now, connection to mySQL database
You have to open file "/src/main/resources/META-INF/persistence.xml".
Then set up your name of database, user, password in:
```
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/skills_to_learn" />
<property name="javax.persistence.jdbc.user" value="user" />
<property name="javax.persistence.jdbc.password" value="password" />
```

After this operation, run the server and run http://localhost:8080/views/index.html. Then application should work.

## Functionality
Application allows user to store on dashboard skills/tasks wchich wants get done in a future. After completing task, user
can remove task from dashboard.

## Technologies used
- Java 8
- Spring (Framework, Data)
- JPA(Hibernate)
- mySQL
- Javascript
- jQuery(AJAX)
- Bootstrap

## Things to improve
- Edit option on front end is still needed to develop
- Removed options from dashboard should be stored

## Authors

* **Tymon Zietek** - *entire work*
