package com.example.quiz.ui;

import com.example.quiz.model.Question;
import com.example.quiz.service.QuizService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class QuizWindow {

    @FXML
    private Label quizTitleLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private VBox optionsBox;
    @FXML
    private Button nextBtn;
    @FXML
    private Button prevBtn;
    @FXML
    private Button submitBtn;

    @FXML
    private Label timerLabel;

    private Timeline questionTimer;
    private int timeLeft = 60;
    private Map<Integer, Integer> questionTimeLeft = new HashMap<>();
    
    private List<Question> questions;
    private int currentIndex = 0;
    //private int score = 0;
    private int quizId;
    private int userId; // set after login
    private long startTime;
    

    // ✅ Map to store user selected answers (key: question index, value: selected option)
   // private Map<Integer, String> userAnswers = new HashMap<>();
    private Map<Integer, Character> userAnswers = new HashMap<>(); 

    public void loadQuiz(int quizId, String quizName) {
        this.quizId = quizId;
        this.userId = 1; // example: replace with logged-in user ID
        quizTitleLabel.setText(quizName);

        questions = QuizService.loadQuestions(quizId); // load from DB
        startTime =System.currentTimeMillis();
        showQuestion();
    }

   
      private void showQuestion() {
            if (currentIndex >= questions.size()) {
            	handleSubmitQuiz();
            	return;
         }
        Question q = questions.get(currentIndex);
       // questionLabel.setText(q.getQuestion());
        questionLabel.setText((currentIndex + 1) + ". " + q.getQuestion());


        optionsBox.getChildren().clear();
        ToggleGroup group = new ToggleGroup();
      
         char optionLetter ='A';
        for (String option : q.getOptions()) {
            RadioButton rb = new RadioButton(option);
            rb.setToggleGroup(group);
            
            rb.setUserData(optionLetter); // store A/B/C/D
            optionsBox.getChildren().add(rb);
            optionLetter++;
        }
        
        // ✅ Restore previous selection if exists
        if (userAnswers.containsKey(currentIndex)) {
        	char saved = userAnswers.get(currentIndex);
       
            for (var node : optionsBox.getChildren()) {
                RadioButton rb = (RadioButton) node;
               
                if ((char) rb.getUserData() == saved) {
                    rb.setSelected(true);
                    break;
                }
            }
        }
        // ✅ Restore saved remaining time or reset to 60
        timeLeft = questionTimeLeft.getOrDefault(currentIndex, 60);
        timerLabel.setText("Time Left: " + timeLeft + "s");
        
        startQuestionTimer();
    }

	@FXML
    private void handleNextQuestion() {
        saveCurrentAnswer();
        stopTimerAndSave();
        if (currentIndex < questions.size() - 1) {
            currentIndex++;
            showQuestion();
        }
    }

    
	@FXML
    private void handlePreviousQuestion() {
		 saveCurrentAnswer();
		  stopTimerAndSave();
        if (currentIndex > 0) {
            currentIndex--;
            showQuestion();
        }
    }

	 
    @FXML
    private void handleSubmitQuiz() {
    	if (questionTimer != null) {      // ✅ Stop timer jab quiz submit ho
            questionTimer.stop();
        }
        saveCurrentAnswer();

        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            Character selected = userAnswers.get(i);
           // String selected = userAnswers.get(i);
            if (selected != null && selected/*.charAt(0)*/ == q.getCorrectOption()) {
                score++;
            }
        }
        long endTime = System.currentTimeMillis();
        long timeTakenSeconds = (endTime - startTime) / 1000;

        // ✅ Save result in DB
        QuizService.saveResult(userId, quizId, score);

        // ✅ Open ResultWindow
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/result_window.fxml"));
            Parent root = loader.load();

            ResultWindow controller = loader.getController();
            controller.setData(quizTitleLabel.getText(), score, questions.size(), timeTakenSeconds);

            Stage stage = new Stage();
            stage.setTitle("Quiz Result");
            stage.setScene(new Scene(root));
            stage.show();

          
         // close quiz window
            Stage current = (Stage) optionsBox.getScene().getWindow();
            current.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
 // ✅ Helper method to save current selection
    private void saveCurrentAnswer() {
        for (var node : optionsBox.getChildren()) {
            RadioButton rb = (RadioButton) node;
            if (rb.isSelected()) {
               //userAnswers.put(currentIndex, rb.getText());
              userAnswers.put(currentIndex, (char) rb.getUserData());
                break;
            }
        }
    }
    
    //Add helper method for timer control
    private void startQuestionTimer() {
        if (questionTimer != null) {
            questionTimer.stop();
        }

        questionTimer = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                timeLeft--;
                timerLabel.setText("Time Left: " + timeLeft + "s");
                if (timeLeft <= 0) {
                    questionTimer.stop();
                    // Auto next or submit
                    if (currentIndex < questions.size() - 1) {
                        handleNextQuestion();
                    } else {
                        handleSubmitQuiz();
                    }
                }
            })
        );
        questionTimer.setCycleCount(Timeline.INDEFINITE);
        questionTimer.play();
    } 
    
    private void stopTimerAndSave() {
        if (questionTimer != null) {
            questionTimer.stop();
        }
        questionTimeLeft.put(currentIndex, timeLeft);
    }

    }
  