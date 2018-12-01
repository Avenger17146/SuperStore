package GUI;

import Backend.StoreAdmin;
import Backend.StoreAdminList;
import Backend.WarehouseAdmin;
import Backend.WarehouseAdminList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
    @FXML
    private TextField ID;
    @FXML
    private PasswordField Password;
    @FXML
    private Label label;
    @FXML

    private WarehouseAdminList WAlist;
    private StoreAdminList SAlist;
    private StoreAdmin storeAdmin;
    private WarehouseAdmin warehouseAdmin;
    private int CurUser;
    @FXML
    private void initialize() throws IOException
    {
        ObjectInputStream inputStream = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("WarehouseAdminList"+".dat"));
            WAlist = (WarehouseAdminList) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }

        try{
            inputStream = new ObjectInputStream(new FileInputStream("StoreAdminList"+".dat"));
            SAlist = (StoreAdminList) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }
    }
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
