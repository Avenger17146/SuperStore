package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Super_User {
	
	@FXML
	void initialize(){
		try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Super_User_Display.fxml"));
    		Parent root = loader.load();
        
    		Super_User_Display log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root,600,600));
		    stage.setTitle("SuperStore");
		    stage.show();

        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
	}
	
    @FXML
    public void Create_Warehouse(MouseEvent e)
    {
    	
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Create_Warehouse.fxml"));
    		Parent root = loader.load();
        
    		Create_Warehouse log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Create_Store.fxml"));
    		Parent root = loader.load();
        
    		Create_Store log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Link.fxml"));
    		Parent root = loader.load();
        
    		Link log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Create_Warehouse_Admin.fxml"));
    		Parent root = loader.load();
        
    		Create_Warehouse_Admin log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Create_Store_Admin.fxml"));
    		Parent root = loader.load();
        
    		Create_Store_Admin log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Check_Store_data.fxml"));
    		Parent root = loader.load();
        
    		Check_Store_data log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Check_warehouse_data.fxml"));
    		Parent root = loader.load();
        
    		Check_warehouse_data log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_type.fxml"));
    		Parent root = loader.load();
        
    		Login_type log=loader.getController();
    		Stage stage = Main.Mstage;
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
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
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Login_type.fxml"));
    		Parent root = loader.load();
        
    		Login_type log=loader.getController();
    		Stage stage = Main.Mstage;
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
    
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
}
