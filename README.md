# Java-Hibernate-OGM-Mongodb
Java sample with Hibernate OGM and Mondodb

Java sample with Hibernate OGM and Mongodb.

This is a maven application that can demonstrate how we can use Hibernate OGM to store data into Mongodb as a document based nosql.

As a sample, we implement the many to many and one to many relationship in the domain model.

Domain model consist of Student, Project, Course. Each student has a list of courses, and each project belongs to a student. Each student also has list of course that can have many students.
