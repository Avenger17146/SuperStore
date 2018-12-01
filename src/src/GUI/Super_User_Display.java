package GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.Store;
import Backend.StoreList;
import Backend.Warehouse;
import Backend.WarehouseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Super_User_Display {
    
	 ObjectInputStream inputStream ;
	
	@FXML
    private ListView<String> Warehouselist;
    @FXML
    private ListView<String> Storelist;
    
    private WarehouseList Wlist;
    private StoreList Slist;
    
    ArrayList<String> one;
    ArrayList<String> two;
    
    Stage mystage ;
    
    @FXML
    void initialize() {
    	
    	one=new ArrayList<String>();
        two=new ArrayList<String>();
    	
    	inputStream=null;
    	DSerial();
    	
    	for(int i=0;i<Wlist.getWarehouses().size();i++) {
    		one.add(Wlist.getWarehouses().get(i).getName());
    	}
    	
    	for(int i=0;i<Slist.getStores().size();i++) {
    		two.add(Slist.getStores().get(i).getName());
    	}
    	
    	
    	ObservableList<String> items1 =FXCollections.observableArrayList (one);    
    	Warehouselist.setItems(items1);
    	
    	ObservableList<String> items2 =FXCollections.observableArrayList (two);
    	Storelist.setItems(items2);
    	}
    
    @FXML
    public void BrowseW(MouseEvent e)
    {
    	int i=Warehouselist.getSelectionModel().getSelectedIndex();
    	
    		Warehouse selectedW=Wlist.getWarehouses().get(i);
    
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
        catch (IOException f)
        {
            f.printStackTrace();
        }
    	    	
    	
    }
    	
	@FXML
    public void BrowseS(MouseEvent e)
    {
    	
    	int j=Storelist.getSelectionModel().getSelectedIndex();
    	Store selectedS=Slist.getStores().get(j);	
    	
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
        catch (IOException f)
        {
            f.printStackTrace();
        }
    	    	
    }	

    public void setSTAGE(Stage stage) {
    	mystage = stage;
    }
    
    @FXML
    public void Back(MouseEvent e)
    {
    	mystage.close();
    }
    
    void DSerial() 
    {
	    try{
	        inputStream = new ObjectInputStream(new FileInputStream("Warehouses"+".dat"));
	        Wlist = (Backend.WarehouseList)inputStream.readObject();
			inputStream.close();

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	
	    try{
	        inputStream = new ObjectInputStream(new FileInputStream("Stores"+".dat"));
	        Slist = (Backend.StoreList)inputStream.readObject();
			inputStream.close();

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	    
    }
}
