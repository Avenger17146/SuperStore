package GUI;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.Store;
import Backend.StoreAdmin;
import Backend.SuperUser;
import Backend.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Store_Admin {
	
	private SuperUser mySU;
	private Stage mystage;
	
	private StoreAdmin myStore;

	@FXML
	ChoiceBox<String> Choice1,Choice2;
	@FXML
	public void own_data(MouseEvent e) {
		
		DSerial();
    	Store selectedS=myStore.getStore();
    	
    	if(selectedS!=null) {
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Category_GUI.fxml"));
    		Parent root = loader.load();
        
    		Category_GUI log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setStore(selectedS);
    
        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    	    	
    	}
	}
	
	@FXML
	public void Go(MouseEvent e) {
		
		int c1=Choice1.getSelectionModel().getSelectedIndex();
		int c2=Choice2.getSelectionModel().getSelectedIndex();
		
		if(c1<0)c1=0;
		if(c2<0)c2=0;
		
		if(c1==0) 
		{//Product
			if(c2==0) {
				//ADD
				try {	
		    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Product_Add.fxml"));
		    		Parent root = loader.load();
		        
		    		Product_Add log=loader.getController();
		    		Stage stage = new Stage();
		    		stage.setScene(new Scene(root,600,600));
				    stage.setTitle("SuperStore");
				    stage.show();
				    
				    log.setWare(mySU,myStore.getStore().getDb(),stage,null,"");
				    
		        }
		        catch (Exception f)
		        {
		            f.printStackTrace();
		        }
				
			}
			else{
				//Up and del				
				try {	
		    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Delete_Product.fxml"));
		    		Parent root = loader.load();
		        
		    		Delete_Product log=loader.getController();
		    		Stage stage = new Stage();
		    		stage.setScene(new Scene(root,600,600));
				    stage.setTitle("SuperStore");
				    stage.show();
				    
				    log.setWare(mySU,myStore.getStore().getDb(),stage);
				    
		        }
		        catch (Exception f)
		        {
		            f.printStackTrace();
		        }
				
			}
		}
		if(c1==1)
		{//Category
			if(c2==0)
			{//ADD
				
			}
			else {
				//Del/Up
				
			}
		}
		
	}
	
	@FXML
	public void log_out(MouseEvent e)
	{	
		mystage.close();
	}

	private ObjectInputStream inputStream ;
	private ArrayList<String> one;
	private String A;
	private String B;
	
	void ini() {  
		
    	List<String> Names = Arrays.asList(" Product ", " Category/Sub ");
		ObservableList<String> availableChoices = FXCollections.observableArrayList(Names); 
		Choice1.setItems(availableChoices);
		Choice1.setValue(" Product ");
		
		List<String> Nam = Arrays.asList("   ADD   ", " UPDATE/DELETE ");
		ObservableList<String> availableChoices1 = FXCollections.observableArrayList(Nam); 
		Choice2.setItems(availableChoices1);
		Choice2.setValue("   ADD   ");
    	
    }

	public void startit(StoreAdmin st,SuperUser s,String a,String b) {
		mySU=s;
		myStore=st;
		A=a;
		B=b;
		ini();		
	}
	public void setSTAGE(Stage stagi) 
	{
		mystage=stagi;
	}
	void DSerial() 
    {
	    try{
	        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SuperUser"+".dat"));
	        mySU = (Backend.SuperUser)inputStream.readObject();
			inputStream.close();
			myStore= mySU.getSAlist().authenticate(A, B);

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	    ini();
	    
    }
	
}
