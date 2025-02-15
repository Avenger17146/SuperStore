package GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.Store;
import Backend.StoreList;
import Backend.SuperUser;
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
    
	private ObjectInputStream inputStream ;
	
	@FXML
    private ListView<String> Warehouselist;
    @FXML
    private ListView<String> Storelist;
    
    private WarehouseList Wlist;
    private StoreList Slist;
    
    private ArrayList<String> one;
    private ArrayList<String> two;
    
    private Stage mystage ;
    
    @FXML
    void ini() {
    	
    	one=new ArrayList<String>();
        two=new ArrayList<String>();
    	
    	inputStream=null;
    	
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
    public void BrowseS(MouseEvent e)
    {

    	int j=Storelist.getSelectionModel().getSelectedIndex();
    	if(j<0)j=0;

    	Store selectedS=Slist.getStores().get(j);	
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

    public void setSTAGE(Stage stage) {
    	mystage = stage;
    }
    
    @FXML
    public void Back(MouseEvent e)
    {
    	mystage.close();
    }
    

    public void setlist(SuperUser sUSU) {
    	 Wlist = sUSU.getWlist();
    	 Slist = sUSU.getSlist();
    	 ini();
	}
}