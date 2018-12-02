package GUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.StoreList;
import Backend.SuperUser;
import Backend.Warehouse;
import Backend.WarehouseAdmin;
import Backend.WarehouseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Warehouse_Admin {
	
	private WarehouseAdmin myWare;
	private SuperUser mySU;
	private Stage mystage;
	
	@FXML
	ChoiceBox<String> Other;
	@FXML
	ChoiceBox<String> Choice1,Choice2;
	
	@FXML
	ListView<String> ORDER;
	
	@FXML
	public void own_data(MouseEvent e) {
		
		DSerial();
    	Warehouse selectedW=myWare.getWarehouse();
    	
    	if(selectedW!=null) {
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Category_GUI.fxml"));
    		Parent root = loader.load();
        
    		Category_GUI log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setWare(selectedW);
    
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
				    
				    log.setWare(mySU,myWare.getWarehouse().getDb(),stage,null);
				    
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
				    
				    log.setWare(mySU,myWare.getWarehouse().getDb(),stage);
				    
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
	public void other_data(MouseEvent e) {	
		
		int i=Other.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	Warehouse selectedW=Wlist.getWarehouses().get(i);
    	
    	if(selectedW!=null) {
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Category_GUI.fxml"));
    		Parent root = loader.load();
        
    		Category_GUI log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setWare(selectedW);
    
        }
        catch (Exception f)
        {
            f.printStackTrace();
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
    private WarehouseList Wlist;
    
    void ini() {
    	Wlist=mySU.getWlist();
    	one=new ArrayList<String>();
    	
    	inputStream=null;
    	
    	for(int i=0;i<Wlist.getWarehouses().size();i++) {
    		one.add(Wlist.getWarehouses().get(i).getName());
    	}
    	
    	if(one!=null && one.size()!=0)
    		{
	    	ObservableList<String> items1 =FXCollections.observableArrayList (one);    
	    	Other.setItems(items1);
	    	
	    	Other.setValue(one.get(0));
    		}
    	
    	List<String> Names = Arrays.asList(" Product ", " Category/Sub ");
		ObservableList<String> availableChoices = FXCollections.observableArrayList(Names); 
		Choice1.setItems(availableChoices);
		Choice1.setValue(" Product ");
		
		List<String> Nam = Arrays.asList("   ADD   ", " UPDATE/DELETE ");
		ObservableList<String> availableChoices1 = FXCollections.observableArrayList(Nam); 
		Choice2.setItems(availableChoices1);
		Choice2.setValue("   ADD   ");
    	
    }
	
	public void startit(WarehouseAdmin w, SuperUser s) 
	{
		
		mySU=s;
		myWare=w;
		
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

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	    ini();
	    
    }
	
}
