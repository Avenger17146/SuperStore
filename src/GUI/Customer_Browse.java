package GUI;

import Backend.Category;
import Backend.Customer;
import Backend.Product;
import Backend.Store;
import Backend.Warehouse;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Customer_Browse {
    private Customer customer;
    private Stage stage;
    private Store store;
    @FXML
    void ini()
    {
        ArrayList<String> a = new ArrayList<String>();
        for ( int i = 0; i<= store.getDb().getCat().size()-1;i++)
        {
            a.add(store.getDb().getCat().get(i).getName());
        }
        Categories.setItems(FXCollections.observableList(a));
        Categories.setValue(a.get(0));
        
        ArrayList<String> b = new ArrayList<String>();
        for ( int i = 0; i<= store.getDb().getPro().size()-1;i++)
        {
            b.add(store.getDb().getPro().get(i).getName());
        }
        Products.setItems(FXCollections.observableList(b));
        Quantity.setText("1");
    }
    @FXML
    private Label jay;
    
    @FXML
    private TextField Quantity;

    @FXML
    private ChoiceBox<String> Categories;

    @FXML
    private ListView<String> Products;

    @FXML
	public void Browse(MouseEvent e)
	{
    	Category selCat= null;
    	try 
    	{
    		
    	int i=Categories.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	selCat= store.getDb().getCat().get(i);
    	}
    	catch(Exception ell) {
    		System.out.println(ell.getMessage());
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
		    log.setCat(selCat,customer,stage);

        }
        catch (Exception f)
        {
            f.printStackTrace();
        }}
	}
    @FXML
	public void Back(MouseEvent e)
	{
    	stage.close();
	}
    @FXML
	public void Add_pro_cart(MouseEvent e)
	{
    	int q= Integer.parseInt(Quantity.getText());
    	
    	int i=Products.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	Product select= store.getDb().getPro().get(i);
    	customer.addProduct(select, q);
    	
    	jay.setText("ADDED");
	}
    
    @FXML
	public void Check_Avai(MouseEvent e)
	{
    	int q= Integer.parseInt(Quantity.getText());
    	
    	int i=Products.getSelectionModel().getSelectedIndex();
    	if(i<0)i=0;
    	Product select= store.getDb().getPro().get(i);
    	
    	System.out.println(select.getName());
    	
    	if(select.getQuantity()<q) {jay.setText("QUANTITY LESS");}
    	if(select.getQuantity()>=q) {jay.setText("Available, QUANTITY Enough.");}
    	
    	
	}
	public void set(Customer a, Stage b, Store c)
    {
        customer =a;
        stage = b;
        store = c;
        ini();
    }

}
