package com.example.quiz.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class QuizSelection {

    @FXML
    private ComboBox<String> quizComboBox;
    @FXML
    private Button startBtn;

    private final Map<String, Integer> quizMap = new HashMap<>();
    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @FXML
    public void initialize() {
        quizMap.put("General Knowledge", 1);
        quizMap.put("Maths Quiz", 2);
        quizMap.put("Database Quiz", 3);
        quizComboBox.setItems(FXCollections.observableArrayList(quizMap.keySet()));
    }

    @FXML
    public void startQuiz() {
        String selectedQuiz = quizComboBox.getValue();
        if (selectedQuiz == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a quiz!").show();
            return;
        }

        int quizId = quizMap.get(selectedQuiz);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/quiz_window.fxml"));
            Parent root = loader.load();

            QuizWindow controller = loader.getController();
            controller.loadQuiz(quizId, selectedQuiz); // pass quizId & name

            Stage quizStage = new Stage();
            quizStage.setScene(new Scene(root));
            quizStage.setTitle("Quiz - " + selectedQuiz);
            quizStage.show();

            // Close current selection window
            Stage current = (Stage) startBtn.getScene().getWindow();
            current.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
