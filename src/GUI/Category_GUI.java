package GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Backend.Category;
import Backend.Database;
import Backend.Product;
import Backend.Store;
import Backend.Warehouse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Category_GUI {

	private Store myStore=null;
	private Warehouse myWarehouse=null;
	private Database myDB;
	
	private ArrayList<String> one= new ArrayList<String>();
	private ArrayList<String> two= new ArrayList<String>();
	
	
	@FXML
	private ChoiceBox<String> Categories;
	
	@FXML
	private ListView<String> Products;

	@FXML
    public void Sort_Items()
    {
		setlists(1);
    }
    @FXML
    public void Browse()
    {
    	Category selCat= null;
    	try 
    	{
    		
    	int i=Categories.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	selCat= myDB.getCat().get(i);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	if(selCat!=null) {
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Browse_Product.fxml"));
    		Parent root = loader.load();
        
    		Browse_Product log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root,600,600));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    if(selCat!=null)
		    log.setCat(selCat,null,stage);

        }
        catch (Exception f)
        {
            f.printStackTrace();
        }}
    }
    @FXML
    public void View_Product()
    {
    	Product selPro=null;
    	try
        {
    		int i=Products.getSelectionModel().getSelectedIndex();
        	if(i<0)i=0;
        	selPro= myDB.getPro().get(i);
        }catch(Exception e) 
    	{System.out.println(e.getMessage());}
    	
    	if(selPro!=null)
        try {	
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Product_Display.fxml"));
    		Parent root = loader.load();
        
    		Product_Display log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root,600,600));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setSTAGE(stage);
		    
		    if(selPro!=null)
		    log.setPro(selPro);

        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    	
    }
	public void setStore(Store selectedS) {
		myStore=selectedS;
		myDB=myStore.getDb();
		setlists(0);
	}
	private void setprelists() {
		if(myDB!=null) {
		
			if(myDB.getCat()!=null){
		
				for ( int j = 0; j<= myDB.getCat().size()-1;j++ )
		        {
		    		one.add(myDB.getCat().get(j).getName());
		    	}
			}
			
			
		    if(myDB.getPro()!=null)	{
				for ( int j = 0; j<= myDB.getPro().size()-1;j++ )
		        {
		    		two.add(myDB.getPro().get(j).getName());
		    	}
		    }
		}
	}	
	private void setlists(int sort) {	
		
		if(sort!=1)setprelists();
		if(sort==1) {
			Collections.sort(one);
			Collections.sort(two);	
		} 
		
		if(one!=null && one.size()!=0){
    	ObservableList<String> items1 =FXCollections.observableArrayList (one);    
    	Categories.setItems(items1);
		Categories.setValue(one.get(0));

		}
		
		if(two!=null && two.size()!=0) {
    	ObservableList<String> items2 =FXCollections.observableArrayList (two);
    	Products.setItems(items2);
    	
		}
	}
	public void setWare(Warehouse selectedW) {
		myWarehouse=selectedW;
		myDB=myWarehouse.getDb();
		setlists(0);
	}

}
