/*package com.example.quiz.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        LoginForm login = new LoginForm();
        Scene scene = new Scene(login.getRoot(), 600, 400);
        stage.setTitle("Online Quiz System - Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}*/
package com.example.quiz.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
 
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quiz/ui/login_form.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Online Quiz System - Login");
        stage.show();
    }


    public static void main(String[] args){
        launch();
    }
}

