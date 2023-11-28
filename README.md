# Excercise: Student management

## how to run

```sh
javac *.java -d target; java -cp target Main
```


## how to package into 1 executable jar

```sh
javac *.java -d target; jar cfe java-dsa-student-management.jar Main -C target .
```

to run it:

```sh
java -jar java-dsa-student-management.jar
```



## Double linked list operations

1. insert/add first/middle/last

2. remove first/middle/last

3. display (head -> tail)

4. sort 

5. check for empty


## Data structure

- Student model: 
  + id: string, max 10 chars, unique
  + fullname: string, max 40 chars
  + score: float
  
- Requirements:
  
  0. insert students to list

  1. Read student list from file
  
  2. print student list
  
  3. print students whose score > 5
  
  4. Output student whose Id = 'X'
  
  5. sort by score ascendant
  
  6. add new student after student id = 'X'
  
  7. remove first student
  
  8. remove last student
  
  9. remove student whose id = 'X'
  
  10. remove all


## Mockup

[id: 111, fullname: batman, score: 10] <-> [id: 212, fullname: superman, score: 8] <-> [id: 123, fullname: tom, score: 4] <-> [id: 123, fullname: jerry, score: 3]

- item/element structure:
  + student
  + next
  + prev

- list structure:
  + head: Student
  + tail: Student

- empty list:
  + head == null == tail
