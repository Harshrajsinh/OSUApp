# OSUApp

Build System  : Gradle  
Web FrameWork : Spring Boot  

Json Format for Tutor Object:
```json
db.tutor.insert (
   {
      "name" : "Vella",
      "department" : "cs",
      "email" : "vellaa@oregonstate.edu",
      "studentAs" : "true", 
      "tutorAs" : "true",
      "course_seeking" : [ "CS540 DBMS" ],
      "course_offering" : ["CS519 Algorithm", "CS 515 Algoritm"]
   }
)
```

Json Format for the Course Object:
```json
db.course.insert(
   {
      "name" : "CS",
      "courseList" : ["CS515 Algorithms","CS517 Theory of Computation","CS519 Master Level Algorithms"]
   }
)
```

# Run Development server

### Backend

```

gradle  bootRun

```

### Frontend

```

ng serve or npm start

```
