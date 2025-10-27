/*package com.example.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;

public class QuizController {

    @FXML
    private ComboBox<String> quizComboBox;

    // Initialize combo box with quizzes
    @FXML
    public void initialize() {
        quizComboBox.getItems().addAll(
                "Java Basics",
                "OOP Concepts",
                "Data Structures",
                "Database Quiz"
        );
    }

    // Handle Start Quiz button
    @FXML
    private void handleStartQuiz() {
        String selectedQuiz = quizComboBox.getValue();

        if (selectedQuiz == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Quiz Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a quiz first!");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/quiz_window.fxml"));
            Parent root = loader.load();

            QuizWindowController controller = loader.getController();
            controller.loadQuiz(selectedQuiz);

            Stage stage = new Stage();
            stage.setTitle(selectedQuiz);
            stage.setScene(new Scene(root));
            stage.show();

            // Close selection window
            quizComboBox.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
package com.example.quiz;

import com.example.quiz.ui.QuizWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class QuizController {

    @FXML
    private ComboBox<String> quizComboBox;

    @FXML
    public void initialize() {
        quizComboBox.getItems().addAll(
                "General Knowledge",
                "Maths Quiz",
                "Database Quiz"
        );
    }

    @FXML
    private void handleStartQuiz() {
        String selectedQuiz = quizComboBox.getValue();
        if (selectedQuiz == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Quiz Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a quiz first!");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/quiz_window.fxml"));
            Parent root = loader.load();

            QuizWindow controller = loader.getController();

            // ---------------------- Option 1 ----------------------
            int quizId = 0;
            switch (selectedQuiz) {
                case "General Knowledge": quizId = 1; break;
                case "Maths Quiz": quizId = 2; break;
                case "Database Quiz": quizId = 3; break;
            }
            // -------------------------------------------------------

            // Pass both quizId and quizName
            controller.loadQuiz(quizId, selectedQuiz);

            Stage stage = new Stage();
            stage.setTitle(selectedQuiz);
            stage.setScene(new Scene(root));
            stage.show();

            quizComboBox.getScene().getWindow().hide();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }



