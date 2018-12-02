package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Backend.SuperUser;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class Create_Warehouse {

	private SuperUser mySU;
	
	private Stage myStage;
	public void setSTAGE(Stage s) {
		myStage=s;
	}
	
    
	@FXML
    private TextField Name;
    
    @FXML
	public void Submit()
	{
    	String name=Name.getText();
    	mySU.CreateWarehouse(name, Integer.toString(mySU.getWlist().getWarehouses().size()));
    	
    	SERIALALL();
    	myStage.close();
	}

	public void SERIALALL() {
		try 
    	{
	    	ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream("SuperUser"+".dat"));
			mySU.SerialiseList();
            oStream.writeObject(mySU);
            System.out.println("File saved");   
    		oStream.close();
			
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}		
	}

	public void setSU(SuperUser sUSU) {
		mySU=sUSU;		
	}
}
