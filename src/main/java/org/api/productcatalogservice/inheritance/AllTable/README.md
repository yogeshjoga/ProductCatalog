# How Inhertiance work here

```java
// Inheritance
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// This annotation creates tables for models, both PARENT and CHILD model classes
```

```mindmap
               User


   Ta        Mentor     Instructor

// User is the Parent
// Ta mentor and Instructor these all are child to User
// Above annotation create tables for each model
// total 4 table will creatd

```
