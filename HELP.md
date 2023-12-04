# Student Management 📚
A BackEnd web using Spring boot,Jpa,PostgreSQL.

## Student
| HTTP Method | URL Path                                                       | Description         |
|-------------|----------------------------------------------------------------|---------------------|
| GET         | /api/v1/Student/                                               | Get All Student     |
| GET         | /api/v1/Student/{id}                                           | Get Student with id |
| POST        | /api/v1/Student/insert                                         | Create an Student   |
| DELETE      | /api/v1/Student/delete/{id}                                    | Delete Student      |
| PUT         | /api/v1/Student/put/{id}                                       | Update Student      |
| Register    | /api/v1/Student/register/student/{idStudent}/course/{idCourse} | Register course     |


## Course
| HTTP Method | URL Path                                                       | Description         |
|-------------|----------------------------------------------------------------|---------------------|
| GET         | /api/v1/Course/                                                | Get All Course      |
| GET         | /api/v1/Course/{id}                                            | Get Course with id  |
| POST        | /api/v1/Course/insert                                          | Create an Course    |
| DELETE      | /api/v1/Course/delete/{id}                                     | Delete Course       |
| PUT         | /api/v1/Course/put/{id}                                        | Update Course       |

