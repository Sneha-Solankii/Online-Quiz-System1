## OnlineQuizSystem (JavaFX + MySQL)
A complete timed quiz application built with JavaFX and MySQL.

## Objective
- Build a quiz system with:
- Timed questions (60s per question)
- Randomized question loading
- Score calculation & storage
- Result display with total score and time taken

## Prerequisites
- Java 17+ installed
- Maven installed
- MySQL server running

## Setup
1. Import the project into your IDE as a Maven project or run from terminal.

2. Update DB credentials in `src/main/java/com/example/quiz/db/DBConnection.java`:
   - DB_URL, DB_USER, DB_PASS

3. create database and sample
-  Open MySQL command prompt:
    mysql -u root -p 
-  Inside MySQL, create the database:
    CREATE DATABASE online_quiz;
    USE online_quiz;
-  source C:/Users/sneha/Downloads/OnlineQuizSystem/src/main/resources/  quiz_db.sql;
-  Verify tables:
   SHOW TABLES;
    This creates:
    users
    quizzes
    questions
    results
   ```
4. Build:
   ```
   mvn clean package
   ```
5. Run:
   ```
   mvn javafx:run
   ```
   Or run the generated jar with required JavaFX modules on module path (IDE runs easier).

## Notes
- This is a minimal educational example. You may extend it (password hashing, better UI, more features).
- If JavaFX runtime errors occur, run from your IDE or follow OpenJFX run instructions for your platform.

