package GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.StoreList;
import Backend.WarehouseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

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
    
    @FXML
    void initialize() {
    	
    	one=new ArrayList<String>();
        two=new ArrayList<String>();
    	
    	inputStream=null;
    	//DSerial();
    	
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
    public void Browse()
    {

    }
    
    @FXML
    public void Back()
    {
    	
    }
    
    void DSerial() 
    {
	    try{
	        inputStream = new ObjectInputStream(new FileInputStream("WarehouseList"+".dat"));
	        Wlist = (Backend.WarehouseList)inputStream.readObject();
			inputStream.close();

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	
	    try{
	        inputStream = new ObjectInputStream(new FileInputStream("StoreList"+".dat"));
	        Slist = (Backend.StoreList)inputStream.readObject();
			inputStream.close();

	    }
	    catch (Exception et)
	    {
	        System.out.println( et.getMessage());
	
	    }
	    
    }
}
