package GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Backend.SuperUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Super_User {
    private Stage mystage ;
	private SuperUser SUSU;
    
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
		    
		    DSerial();
		    log.setSU(SUSU);
		    log.setSTAGE(stage);
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
		    DSerial();

		    log.setSU(SUSU);
		    log.setSTAGE(stage);
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
		    DSerial();
		    log.setSU(SUSU,stage);
    
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
		    
		    DSerial();
		    log.setSU(SUSU,stage);
    
    
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
		    
		    DSerial();
		    log.setSU(SUSU,stage);
    
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Check_Data()
    {
    	dispy();
    }
   
    @FXML
    public void Log_Out_Super_User()
    {
    	mystage.close();
    }

	public void setSTAGE(Stage stagi) {
		mystage=stagi;
	}
	
	
	void DSerial() 
    {
	    try{
	        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SuperUser"+".dat"));
	        SUSU = (Backend.SuperUser)inputStream.readObject();
			inputStream.close();

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	    
    }
	
	public void dispy() {
		DSerial();
		try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Super_User_Display.fxml"));
    		Parent root = loader.load();
        
    		Super_User_Display log=loader.getController();
		    log.setlist(SUSU);

    		Stage stage = new Stage();
    		stage.setScene(new Scene(root,600,600));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setSTAGE(stage);

        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
	}
}
