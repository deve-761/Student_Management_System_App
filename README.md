# StudentbasemanagmentSystem
In this application, we can manage student data, and course data. Admin can add students, courses, and can manage these entities, students can get the courses they are assigned in and can drop from a particular course.


[Kousik Manik](https://github.com/Kousik1234)

## ER Diagram



## Functionalities
- Layered architecture
- Admin can register/login
- Register Courses,Students
- Get Courses,Students
- Student will be verified before ascession API
- Can update Profile details



## Backend Work
- Admin Authentication of signUp and Login using Spring security
- Proper Exception Handling, and Input Validation
- Data Stored in the database(mySQL)

## Tech stack
- Java Core
- Spring Data JPA
- Spring Security
- Spring Boot
- Hibernate
- MySQL
## Installation and Run

- Before running the API server, we should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database config.
- server.port=8898
- spring.datasource.url=jdbc:mysql://localhost:3306/platfromcm
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.datasource.username=root
- spring.datasource.password=root
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true
- spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

## Backend

## Admin Controller

POST : /admin/register

{
    "userId": 1,
    "name": "Kousik Manik",
    "mobileNumber": "8945060713",
    "password": "Kou123@",
    "role": "ADMIN"
}


## Course Controller

POST : /courses/

**Response**
{
  -"courseId": 2,
  "courseName": "Java Backend Development",
  "description": "The course is designed for every person from beginner",
  "courseType": "Live",
  "duration": "8 Months",
  "topics": "Java Core, Hibernate, JDBC, Spring, SpringBoot"
}
{
  "courseId": 4,
  
  "courseName": "Full Stack Web Development",
  
  "description": "The course is designed for every person from beginner",
  "courseType": "Live",
  "duration": "8 Months",
  "topics": "JavaScript, HTML, CSS, NodeJS, React,Mongo DB"
}


GET => getStudentsFromCorseHandler : /courses/

{
  "courseId": 4,
  "courseName": "Full Stack Web Development",
  "description": "The course is designed for every person from beginner",
  "courseType": "Live",
  "duration": "8 Months",
  "topics": "JavaScript, HTML, CSS, NodeJS, React,Mongo DB",
  "studentList": [
    {
      "studentId": 5,
      "name": "Kartick Mondal",
      "fatherName": "Sushanta Mondal",
      "email": "kartickmondal7797@gmail.com",
      "mobileNumber": "7797247525",
      "dob": "1998-12-20",
      "gender": "MALE"
    },
    {
      "studentId": 7,
      "name": "Sudip Manik",
      "fatherName": "Mahadev Manik",
      "email": "sudip786@gmail.com",
      "mobileNumber": "8946768934",
      "dob": "2001-02-03",
      "gender": "MALE"
    } 
  ]
}


 ## Student Controller
 
 Get : /students/courses
 
 **Response
{
  "name": "Kartick Mondal",
  "courses": [
    {
      "courseId": 2,
      "courseName": "Java Backend Development",
      "description": "The course is designed for every person from beginner",
      "courseType": "Live",
      "duration": "8 Months",
      "topics": "Java Core, Hibernate, JDBC, Spring, SpringBoot"
    },
    {
      "courseId": 4,
      "courseName": "Full Stack Web Development",
      "description": "The course is designed for every person from beginner",
      "courseType": "Live",
      "duration": "8 Months",
      "topics": "JavaScript, HTML, CSS, NodeJS, React,Mongo DB"
    }
  ],
  "studentId": 5
}
