create database online_quiz;

use online_quiz;
show tables;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);
INSERT INTO users (username, password) VALUES ('root', 'root');
select * from users;

-- QUIZZES TABLE
CREATE TABLE quizzes (
  quiz_id INT AUTO_INCREMENT PRIMARY KEY,
  quiz_name VARCHAR(100) NOT NULL
);

INSERT INTO quizzes (quiz_name)
VALUES ('General Knowledge'), ('Maths Quiz');

select *from quizzes;

-- QUESTIONS TABLE
CREATE TABLE questions (
  question_id INT AUTO_INCREMENT PRIMARY KEY,
  quiz_id INT,
  question_text VARCHAR(255) NOT NULL,
  option_a VARCHAR(100) NOT NULL,
  option_b VARCHAR(100) NOT NULL,
  option_c VARCHAR(100) NOT NULL,
  option_d VARCHAR(100) NOT NULL,
  correct_option CHAR(1) NOT NULL,
  FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);

INSERT INTO questions (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)
VALUES
(1, 'Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Venus', 'Jupiter', 'B'),
(1, 'Who invented the computer?', 'Charles Babbage', 'Isaac Newton', 'Alan Turing', 'Bill Gates', 'A'),
(2, 'What is 5 * 6?', '30', '25', '20', '35', 'A'),
(2, 'What is 9 + 3?', '10', '11', '12', '13', 'C');

select *from questions;

-- RESULTS TABLE
CREATE TABLE results (
  result_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  quiz_id INT,
  score INT,
  date_taken DATETIME,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id)
);