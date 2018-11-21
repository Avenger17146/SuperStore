package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Super_User {
    @FXML
    public void Create_Warehouse(MouseEvent e)
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Create_Warehouse.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    	
    }
    @FXML
    public void Create_Store(MouseEvent e)
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Create_Store.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }

    }
    @FXML
    public void Link()
    {

    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Link.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    
    }
    @FXML
    public void Create_Warehouse_Admin()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Create_Warehouse_Admin.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Create_Store_Admin()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Create_Store_Admin.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Check_Store_Data()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Check_Store_data.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }

    }
    @FXML
    public void Check_Warehouse_Data()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Check_warehouse_data.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Log_Out_Super_User()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login_Type.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Login_Another()
    {
    	try
        {
            Main.Mstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login_Type.fxml")), 600, 400));
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
}
