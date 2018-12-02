package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Backend.StoreList;
import Backend.SuperUser;
import Backend.WarehouseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Link {
	@FXML
	ChoiceBox<String> Warehouse,Store;
	
	@FXML
    public void Link(MouseEvent e)
    {
		int w=Warehouse.getSelectionModel().getSelectedIndex();
		int s=Store.getSelectionModel().getSelectedIndex();
		
		Slist.getStores().get(s).setLinked(Wlist.getWarehouses().get(w));
		SERIALALL();
		myStage.close();
    }
	
	 private WarehouseList Wlist;
	 private StoreList Slist;
	 private ArrayList<String> one;
    private ArrayList<String> two;
	private ObjectInputStream inputStream ;
	private SuperUser mySU;
	private Stage myStage;

	@FXML
    void ini() {
    	
    	one=new ArrayList<String>();
        two=new ArrayList<String>();
    	
    	inputStream = null;
    	
    	for(int i=0;i<Wlist.getWarehouses().size();i++) {
    		one.add(Wlist.getWarehouses().get(i).getName());
    	}
    	
    	for(int i=0;i<Slist.getStores().size();i++) {
    		two.add(Slist.getStores().get(i).getName());
    	}
    	
    	
    	ObservableList<String> items1 =FXCollections.observableArrayList (one);    
    	Warehouse.setItems(items1);
    	
    	ObservableList<String> items2 =FXCollections.observableArrayList (two);
    	Store.setItems(items2);
    	}


	public void setSU(SuperUser sUSU,Stage s) {
		
		mySU=sUSU;
		Wlist = mySU.getWlist();
	   	Slist = mySU.getSlist();	
	   	ini();
	   	myStage=s;
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
