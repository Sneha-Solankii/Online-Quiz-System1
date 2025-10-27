-- Create DB and tables for OnlineQuizSystem
CREATE DATABASE IF NOT EXISTS online_quiz;
USE online_quiz;

DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS quizzes;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(100)
);

CREATE TABLE quizzes (
  quiz_id INT AUTO_INCREMENT PRIMARY KEY,
  quiz_name VARCHAR(100),
  description TEXT
);

CREATE TABLE questions (
  question_id INT AUTO_INCREMENT PRIMARY KEY,
  quiz_id INT,
  question_text TEXT,
  option_a VARCHAR(255),
  option_b VARCHAR(255),
  option_c VARCHAR(255),
  option_d VARCHAR(255),
  correct_option CHAR(1),
  FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE
);

CREATE TABLE results (
  result_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  quiz_id INT,
  score INT,
  date_taken DATETIME,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);

-- Sample data
INSERT INTO users (username, password, email) VALUES
('student1','password','student1@example.com'),
('student2','password','student2@example.com');

INSERT INTO quizzes (quiz_name, description) VALUES
('General Knowledge','Short GK quiz');

INSERT INTO questions (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
(1,'Capital of India?','Mumbai','New Delhi','Chennai','Kolkata','B'),
(1,'2 + 2 = ?','3','4','5','6','B'),
(1,'Sun rises from?','West','North','East','South','C'),
(1,'Largest planet?','Earth','Mars','Jupiter','Venus','C');
