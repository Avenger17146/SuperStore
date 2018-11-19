package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class SuperUserLogin {
    @FXML
    private TextField ID;
    @FXML
    private PasswordField Password;
    @FXML
    private Label label;
    @FXML
    public void Login(MouseEvent e)
    {
        if (ID.getText().equals("admin")&&Password.getText().equals("admin"))
        {
            try
            {
                Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Super_User.fxml")), 600, 400));
            }
            catch (IOException f)
            {
                f.printStackTrace();
            }

        }
        else
            label.setText("Wrong ID or Password! Try again");
    }
//    @FXML
//    private void intialize()
//    {
//      omg ni
//    }
}
