```


# How Inhertiance work here

```java
// Inheritance
@Inheritance(strategy = InheritanceType.JOINED)
// This annotation creates tables for models, Its created like Inherited all attributes to child classes and create tables for each entity
// inhertiance this annotoation used in all child classes for how to join tables
@PrimaryKeyJoinColumn(name = "user_id")
```

```mindmap
               User


   Ta        Mentor     Instructor

// User is the Parent
// Ta mentor and Instructor these all are child to User
// Above annotation create tables, All attributes inherited to child modle tables
// each child table contains user class attributs and child class itself attributs 
// finally created all tables, each model have one table total 4 table will created
```

```

```
