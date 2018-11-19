package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage Mstage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Mstage =primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("SuperUser_Login.fxml"));
        Mstage.setTitle("Hello World");
        Mstage.setScene(new Scene(root, 600, 400));
        Mstage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
