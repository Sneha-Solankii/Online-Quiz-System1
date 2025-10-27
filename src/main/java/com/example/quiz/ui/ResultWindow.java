package com.example.quiz.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultWindow {

    @FXML
    private Label quizTitleLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label timeTakenLabel;
    private Stage stage;

    private String quizTitle;
    private int score;
    private int totalQuestions;
    private long timeTakenSeconds;

    public void setData(String quizTitle, int score, int totalQuestions, long timeTakenSeconds) {
      /*  this.quizTitle = quizTitle;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.timeTakenSeconds = timeTakenSeconds;
      */
        quizTitleLabel.setText("Quiz: " + quizTitle);
        scoreLabel.setText("Score: " + score + " / " + totalQuestions);
        timeTakenLabel.setText("Time Taken: " + timeTakenSeconds + " seconds");
    }
    
    /*public void showResult(int score) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/result_window.fxml"));
          //  loader.setController(this);
            stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            scoreLabel.setText("Your Score: " + score);
            stage.setTitle("Quiz Result");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
  /*  public void showResult(int score, int totalQuestions, String quizTitle, long timeTakenSeconds) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/result_window.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());

            // Get the controller instance from loader
            ResultWindow controller = loader.getController();
            controller.setData(quizTitle, score, totalQuestions, timeTakenSeconds);

            stage.setScene(scene);
            stage.setTitle("Quiz Result");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @FXML
    private void closeWindow() {
        Stage stage = (Stage) quizTitleLabel.getScene().getWindow();
        stage.close();
    }
}
