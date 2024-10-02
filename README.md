# AP_Assignment_2
Advanced Programming - Sem 3 Assignment 2 (ERP Portal)

README: Include a README file explaining how you have incorporated generic
programming, object classes, and exception handling into your solution.

Generic Programming
The GenericFeedback<T> class is an example of generic programming in Java. By using a generic type parameter <T>, this class allows feedback of any type (e.g., String, Integer) to be stored, providing flexibility and reusability across different contexts.

Object Classes
Implemented Object classes: Student, Professor, Admin, TeachingAssistant, Feedback, Course. 
All of them have fields, constructors, methods and encapsulation.
They define properties of the objects of that class.
They helped provide a clear structure for building this complex system.


Exception Handling
Created three custom exception handling classes (Handled using try-catch blocks) :
1. CourseDropDeadlineException: Checks whether a course is trying to be dropped after its drop deadline.
2. CourseFullException: Checks whether a student tries to register for a course that is already full.
3. InvalidLoginException: Checks for valid email and password for logins of Student, Professor, Admin, Teaching Assistant.
