package GUI;

import Backend.StoreAdmin;
import Backend.StoreAdminList;
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
	    	
	    	if(CurUser==0  && a.equals("admin")&& b.equals("admin")) 
	    	{
	    		Super_User log=loader.getController();
	    		
	    		DoIt=true;
	    	}
	    	else if(CurUser==1) 
	    	{
	    		 try{
	    	            inputStream = new ObjectInputStream(new FileInputStream("WarehouseAdminList"+".dat"));
	    	            WAlist = (WarehouseAdminList) inputStream.readObject();
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
	    		DoIt=true;
	    		log.startit(WAlist.authenticate(a, b));
	    		}
	    	}
		    else if(CurUser==2  ) 
		    {
		    	
		    	try{
		            inputStream = new ObjectInputStream(new FileInputStream("StoreAdminList"+".dat"));
		            SAlist = (StoreAdminList) inputStream.readObject();
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
	    		DoIt=true;
	    		log.startit(SAlist.authenticate(a, b));}
			}
		    else if(CurUser==3)
		    {
	    		Customer_Login log=loader.getController();
	    		DoIt=true;
		    	
		    }
	        else
	            label.setText("Wrong ID or Password! Try again");
	    	
	    	if (DoIt==true) {
	    		
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
