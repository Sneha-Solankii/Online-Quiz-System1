/*package com.example.quiz.ui;

import java.io.IOException;

import com.example.quiz.service.QuizService;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

// ✅ update: Add these imports
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class LoginForm {
    private BorderPane root;
    private Button loginBtn;

    public LoginForm(){
        root = new BorderPane();
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        Label title = new Label("Login");
        title.setFont(Font.font(24));
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Button loginBtn = new Button("Login");
        Label msg = new Label();

        loginBtn.setOnAction(ev -> {
            String u = username.getText().trim();
            String p = password.getText().trim();
            if(u.isEmpty() || p.isEmpty()){
                msg.setText("Kuch fields khaali hain");
                return;
            }

            boolean ok = QuizService.validateUser(u,p);
            if(ok){
                try {
                    int userId = QuizService.getUserId(u);  // ✅ update (get logged-in user ID)

                    // ✅ update (load quiz selection screen instead of direct quiz)
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/quiz_selection.fxml"));
                    Parent rootNode = loader.load();

                    // ✅ update (if you want to send userId)
                    // QuizSelectionController controller = loader.getController();
                    // controller.setUserId(userId);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(rootNode));
                    stage.setTitle("Select Quiz");
                    stage.show();

                    // ✅ update (close current login window)
                    stage.setOnCloseRequest(e -> System.exit(0));

                    // ✅ update: clear old login area
                    root.setCenter(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                msg.setText("Login failed. Username/password check karo.");
            }
        });

        box.getChildren().addAll(title, username, password, loginBtn, msg);
        root.setCenter(box);
    }

    public BorderPane getRoot(){ return root; 
    }

@FXML
private void handleLogin() {
    // validate username/password here (dummy or DB)
	try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/login_form.fxml"));
	    Parent rootNode = loader.load();

	    Stage stage = new Stage();
	    stage.setScene(new Scene(rootNode));
	    stage.setTitle("Select Quiz");
	    stage.show();

	    // Close current login window
	    Stage current = (Stage) loginBtn.getScene().getWindow();
	    current.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
}
}*/

package com.example.quiz.ui;

import com.example.quiz.service.QuizService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginBtn;

    @FXML
    private void handleLogin() {
        String u = usernameField.getText().trim();
        String p = passwordField.getText().trim();

        if(u.isEmpty() || p.isEmpty()){
            System.out.println("Kuch fields khaali hain");
            return;
        }

        if(QuizService.validateUser(u,p)){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/quiz_selection.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Select Quiz");
                stage.show();

                // Close current window
                Stage current = (Stage) loginBtn.getScene().getWindow();
                current.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login failed. Username/password check karo.");
        }
    }
}



