package GUI;

import Backend.Customer;
import Backend.StoreAdmin;
import Backend.StoreAdminList;
import Backend.SuperUser;
import Backend.WarehouseAdmin;
import Backend.WarehouseAdminList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
    @FXML
    private TextField ID;
    @FXML
    private PasswordField Password;
    @FXML
    private Label label;
    @FXML

    private SuperUser mySU;
    private WarehouseAdminList WAlist;
    private StoreAdminList SAlist;
    private StoreAdmin storeAdmin;
    private WarehouseAdmin warehouseAdmin;
    private int CurUser;
    
    private boolean DoIt;
    
    ObjectInputStream inputStream ;

    @FXML
    private void initialize() throws IOException
    {
        DoIt=false;  
        inputStream = null;
       
    }
    @FXML
    public void Login(MouseEvent e)
    {	
    	String[] array= {"Super_User.fxml","Warehouse_Admin.fxml","Store_Admin.fxml","Customer_Login.fxml"};    	
    	
    	String a=ID.getText();
    	String b=Password.getText();
    	
    	try 
		{
			FXMLLoader loader= new FXMLLoader(getClass().getResource(array[CurUser]));
	        Parent root = loader.load();
	    	
	    	if(CurUser==0)
	    	{
	    		if(a.equals("admin")&& b.equals("admin")) 
	    		{
	    		Super_User log=loader.getController();
	    	    log.dispy();

	    		Stage stage = new Stage();
	    	    stage.setScene(new Scene(root));
	    	    stage.setTitle("SuperStore");
	    	    stage.show();
	    	    
	    	    log.setSTAGE(stage);
	    		}
	    		else
		            label.setText("Wrong ID or Password! Try again");
	    	}
	    	
	    	else if(CurUser==1) 
	    	{
	    		 try{
	    	            inputStream = new ObjectInputStream(new FileInputStream("SuperUser"+".dat"));
	    	            mySU = (SuperUser) inputStream.readObject();
	    	            WAlist = mySU.getWAlist();
	    	        }
	    	        catch (Exception et)
	    	        {
	    	            System.out.println( et.getMessage());
			            label.setText("Doesn't Exist");

	    	        }
	    	        finally {
	    	            inputStream.close();
	    	        }
	    		if(WAlist.authenticate(a, b)!=null)
	    		{
	    		Warehouse_Admin log=loader.getController();
	    		
	    		Stage stage = new Stage();
	    	    stage.setScene(new Scene(root));
	    	    stage.setTitle("SuperStore");
	    	    stage.show();
	    	    
	    		log.startit(WAlist.authenticate(a, b),mySU);
	    		log.setSTAGE(stage);
	    		}
	    		else
		            label.setText("Wrong ID or Password! Try again");
	    	}
		    else if(CurUser==2  ) 
		    {
		    	
		    	try{
		    		 inputStream = new ObjectInputStream(new FileInputStream("SuperUser"+".dat"));
	    	         mySU = (SuperUser) inputStream.readObject();
	    	         SAlist = mySU.getSAlist();
		        }
		        catch (Exception ea)
		        {
		            label.setText("Doesn't Exist");
		        	System.out.println(ea.getMessage());
		        }
		        finally {
		            inputStream.close();
		        }
		    	if(SAlist.authenticate(a, b)!=null) {
	    		Store_Admin log=loader.getController();
	    		
	    		Stage stage = new Stage();
	    	    stage.setScene(new Scene(root));
	    	    stage.setTitle("SuperStore");
	    	    stage.show();
	    	    
	    		log.startit(SAlist.authenticate(a, b),mySU);
	    		log.setSTAGE(stage);
		    	}
		    	else
		            label.setText("Wrong ID or Password! Try again");
			}

		    else if(CurUser==3)
		    {
	    		Customer_Login log=loader.getController();
	    		log.set(new Backend.Customer());
	    		Stage stage = new Stage();
	    	    stage.setScene(new Scene(root));
	    	    stage.setTitle("SuperStore");
	    	    stage.show();
		    	
		    }
	    	
		}
	    catch (Exception ex) {
	    	System.err.println(ex);
	    }
	    		  
	}
    
    
    public void startit(int n) {
    	CurUser=n;
	
}
}
