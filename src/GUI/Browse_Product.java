package GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import Backend.Category;
import Backend.Customer;
import Backend.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Browse_Product {
	
	private Category myCat; 
	
	private ArrayList<String> one;
	private ArrayList<String> two;
	    
	@FXML
	private ChoiceBox<String> Select_Category;
	
	@FXML
	private ChoiceBox<String> Product;

	private int mytype;

	private Customer myCus;

	private Stage myStage;
    
    @FXML
    public void Browse()
    {
    	Category selCat= null;
    	try 
    	{
    		
    	int i= Select_Category.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	selCat= myCat.getcList().get(i);
    	}
    	catch(Exception e) {
    		System.out.println("Nothing");
    	}
    	
    	if (selCat!=null)
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
		    log.setCat(selCat,myCus,stage);

        }
        catch (Exception f)
        {
            f.printStackTrace();
        }
    }
    @FXML
    public void Select_Product()
    {    	
    	Product selPro=null;
    	try
        {
    		int i=Product.getSelectionModel().getSelectedIndex();
        	if(i<0)i=0;
        	selPro= myCat.getpList().get(i);
        }catch(Exception e) 
    	{System.out.println("Nothing");}
    	
    	
    	
    	if(selPro!=null) {
    		
    		if(myCus==null) 
    		{

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
    		else {
    			myCus.addProduct(selPro, 1);
    			myStage.close();
    			
    		}
    	}
    	
    }
    
    @FXML
    public void sort() {
    	setlists(1);
    }
    
	public void setCat(Category selCat,Customer cc,Stage stage) {
		myCat = selCat;
		one=new ArrayList<String>();
		two=new ArrayList<String>();
		setlists(0);
		myCus=cc;
		myStage=stage;
	}
	
	private void setprelists() {	
		
		if(myCat.getClist()!=null) {
		for ( int j = 0; j<= myCat.getClist().size()-1;j++ )
        {
    		one.add(myCat.getClist().get(j).getName());
    	}
		}
		
		if(myCat.getPlist()!=null) {
		for ( int j = 0; j<= myCat.getPlist().size()-1;j++ )
        {
    		two.add(myCat.getPlist().get(j).getName());
    	}
		}
	}
	
	private void setlists(int sort) {	
		
		
		if(sort!=1)setprelists();

		if(sort==1) {
			Collections.sort(one);
			Collections.sort(two);	
		} 
		if(one!=null && one.size()!=0)
    	{ObservableList<String> items1 =FXCollections.observableArrayList (one);    
    	Select_Category.setItems(items1);
		Select_Category.setValue(one.get(0));
    	}
		if(two!=null && two.size()!=0) {
    	ObservableList<String> items2 =FXCollections.observableArrayList (two);
    	Product.setItems(items2);
    	Product.setValue(two.get(0)); //Sundar banane ki ninja technique
		}
	}
	
	
}
