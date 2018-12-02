package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Backend.Category;
import Backend.Database;
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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Product_Add {
	@FXML
	ChoiceBox<String> Select_Category;
	
	private Stage myStage;
	private Database myDB;
	private SuperUser mySU;
	private Category parentCat;
	
	@FXML
	public void Add_Product()
	{
		int i=Select_Category.getSelectionModel().getSelectedIndex();
		if(i<0)i=0;
		Category selCat;
		if(parentCat!=null)
			selCat= parentCat.getClist().get(i);
		else
			selCat=myDB.getCat().get(i);
    	

			try
	        {
	    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Update_Product.fxml"));
	    		Parent root = loader.load();
	        
	    		Update_Product log=loader.getController();
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(root,600,600));
			    stage.setTitle("SuperStore");
			    stage.show();
			    
			    log.setWare(mySU,myDB,stage,selCat,null);

	        }
	        catch (Exception f)
	        {
	            f.printStackTrace();
	        }
		
		
		myStage.close();
	}
	@FXML
	public void Browse()
	{	int i=Select_Category.getSelectionModel().getSelectedIndex();
		if(i<0)i=0;
		Category selCat;
		if(parentCat!=null)
			selCat= parentCat.getClist().get(i);
		else
			selCat=myDB.getCat().get(i);
    	
    	if(selCat!=null) {
    	try
        {
    		FXMLLoader loader= new FXMLLoader(getClass().getResource("Product_Add.fxml"));
    		Parent root = loader.load();
        
    		Product_Add log=loader.getController();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root,600,600));
		    stage.setTitle("SuperStore");
		    stage.show();
		    
		    log.setWare(mySU,myDB,stage,selCat);

        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    	}
		myStage.close();

	}
	
	public void setWare(SuperUser mU,Database mB, Stage stage, Category curC) {
		myStage=stage;
		mySU=mU;
		myDB=mB;
		parentCat=curC;
		
		setlists(0);
	}
	
	private ArrayList<String> one=new ArrayList<String>();
    
    private void setprelists() 
    {	if(parentCat==null) {
    	if(myDB.getCat()!=null){
    		
			for ( int j = 0; j<= myDB.getCat().size()-1;j++ )
	        {
	    		one.add(myDB.getCat().get(j).getName());
	    	}
		}
    }
		if(parentCat!=null){
		
				for ( int j = 0; j<= parentCat.getClist().size()-1;j++ )
		        {
		    		one.add(parentCat.getClist().get(j).getName());
		    	}
			
			}
	}
    
	private void setlists(int sort)
	{	

	    if(sort!=1)setprelists();
		if(sort==1) {
			Collections.sort(one);
		} 
		
		if(one!=null && one.size()!=0){
		ObservableList<String> items1 =FXCollections.observableArrayList (one);    
		Select_Category.setItems(items1);
		Select_Category.setValue(one.get(0));

		}
	}
	
}
