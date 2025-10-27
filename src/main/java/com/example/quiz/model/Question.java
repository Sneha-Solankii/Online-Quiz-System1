/*package com.example.quiz.model;

public class Question {
    private int id;
    private int quizId;
    private String text;
    private String a,b,c,d;
    private char correct;

    public Question(int id, int quizId, String text, String a, String b, String c, String d, char correct){
        this.id=id; this.quizId=quizId; this.text=text; this.a=a; this.b=b; this.c=c; this.d=d; this.correct=correct;
    }

    public int getId(){ return id; }
    public int getQuizId(){ return quizId; }
    public String getText(){ return text; }
    public String getA(){ return a; }
    public String getB(){ return b; }
    public String getC(){ return c; }
    public String getD(){ return d; }
    public char getCorrect(){ return correct; }

	
}*/

/*package com.example.quiz.model;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private String answer;

    public Question(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
    public String getAnswer() { return answer; }
}*/
package com.example.quiz.model;

import java.util.Arrays;
import java.util.List;

public class Question {
  
    private int quizId;
    private String question;
    private List<String> options;
    private char correctOption;

    public Question(int quizId, String question, String optionA, String optionB,
            String optionC, String optionD, char correctOption) {
			
    	    this.quizId = quizId;
			this.question = question;
			this.options = Arrays.asList(optionA, optionB, optionC, optionD);
			this.correctOption = correctOption;
		}


    // Getters
   
    public int getQuizId() { return quizId; }
    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
    public char getCorrectOption() { return correctOption; }

	

}


