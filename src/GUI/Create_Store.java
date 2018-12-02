package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Backend.SuperUser;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Create_Store {
	@FXML
	private TextField Name_Store;
	
	private Stage myStage;
	public void setSTAGE(Stage s) {
		myStage=s;
	}
	
	private SuperUser mySU;
	
	@FXML
	public void Submit()
	{
		String name=Name_Store.getText();
    	mySU.CreateStore(name, Integer.toString(mySU.getSlist().getStores().size()));
    	
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
