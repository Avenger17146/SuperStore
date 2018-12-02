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
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_type.fxml"));
        Parent root = loader.load();
        
        Login_type login_type = loader.getController();
        Mstage.setTitle("Super Store");
        Mstage.setScene(new Scene(root, 600, 400));
        Mstage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
