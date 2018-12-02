package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import Backend.Category;
import Backend.Database;
import Backend.InvalidPathException;
import Backend.Product;
import Backend.SuperUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Delete_Product {
	
	@FXML
	private ListView<String> Product;
	private SuperUser mySU;
	private Database myDB;
	private Stage myStage;
	private int type;
	private ArrayList<String> two= new ArrayList<String>();
	private String path;

	
	@FXML
	public void Delete_Current()
	{
		type=1;
		letsgo();
	}
	
	@FXML
	public void Update_Current()
	{
		type=0;
		letsgo();
	}

	public void letsgo() {
		Product selPro=null;
    	try
        {
    		int i=Product.getSelectionModel().getSelectedIndex();
        	if(i<0)i=0;
        	selPro= myDB.getPro().get(i);
        }
    	catch(Exception e) 
    	{System.out.println(e.getMessage());}
    	
		if(type==0) {
			//Update
				try
		        {
		    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Update_Product.fxml"));
		    		Parent root = loader.load();
		        
		    		Update_Product log=loader.getController();
		    		Stage stage = new Stage();
		    		stage.setScene(new Scene(root,600,600));
				    stage.setTitle("SuperStore");
				    stage.show();
				    
				    log.setWare(mySU,myDB,stage,null,selPro,selPro.getPath());

		        }
		        catch (Exception f)
		        {
		            f.printStackTrace();
		        }
			
			
			myStage.close();
			
		}
		if(type==1) {
			//Delete
	    	
			try {
				for(int i=0;i<myDB.getPro().size();i++) {
					System.out.println(myDB.getPro().get(i).getName());
				}
				
				myDB.delete(selPro);
				
				for(int i=0;i<myDB.getPro().size();i++) {
					System.out.println(myDB.getPro().get(i).getName());
				}

			} catch (InvalidPathException e) {
				e.printStackTrace();
			}
		}
		
		SERIALALL();
		myStage.close();

	}
	
	
	private void setprelists() {
		
		if(myDB.getPro()!=null){
				for ( int j = 0; j<= myDB.getPro().size()-1;j++ )
		        {
		    		two.add(myDB.getPro().get(j).getName());
		    	}
		    }
		}
	
	private void setlists() {	
			
		setprelists();

		if(two!=null && two.size()!=0) {
	    	ObservableList<String> items2 =FXCollections.observableArrayList (two);
	    	Product.setItems(items2);
	    	}
		
	}
	
	
	public void setWare(SuperUser mySU, Database myDB, Stage stage) {
		this.mySU=mySU;
		this.myDB=myDB;
		this.myStage=stage;
		setlists();
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
}
