package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class Login {
    @FXML
    private TextField ID;
    @FXML
    private PasswordField Password;
    @FXML
    private Label label;
    @FXML
    
    private int CurUser;
    public void Login(MouseEvent e)
    {	
    	String[] array= {"Super_User.fxml","Warehouse_Admin.fxml","Store_Admin.fxml","Customer_Login"};    	
    	
        if (ID.getText().equals("admin")&&Password.getText().equals("admin"))
        {
        	
        }
        else
            label.setText("Wrong ID or Password! Try again");
    }
    
    public void startit(int n) {
    	
    	CurUser=n;
	
}
}
