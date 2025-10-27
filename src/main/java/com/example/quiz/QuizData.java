package com.example.quiz;

import java.util.Arrays;
import java.util.List;

import com.example.quiz.model.Question;

public class QuizData {

    public static List<Question> getQuestions(String quizName) {
        switch (quizName) {
            case "General Knowledge":
            	return Arrays.asList(
            			new Question(1, "Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter", 'B'),
            		    new Question(1, "What is JDK?", "Java Development Kit", "Java Deploy Kit", "Java Debug Kit", "None", 'A')
            		);

            case "Maths Quiz":
                return Arrays.asList(
                		new Question(1, "What is 5 * 6?", "30", "25", "20", "35", 'A'),
            		    new Question(1, "What is 9 + 3?", "10", "11", "12", "13", 'C')
            		);

            default:
                return Arrays.asList(
                		new Question(0, "Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter", 'B')
         );
        }
    }
}
