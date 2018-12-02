package GUI;

import Backend.Customer;
import Backend.Store;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Customer_Browse {
    private Customer customer;
    private Stage stage;
    private Store store;
    @FXML
    void initialize()
    {
        ArrayList<String> a = new ArrayList<String>();
        for ( int i = 0; i<= store.getDb().getCat().size()-1;i++)
        {
            a.add(store.getDb().getCat().get(i).getName());
        }
        Categories.setItems(FXCollections.observableList(a));
        ArrayList<String> b = new ArrayList<String>();
        for ( int i = 0; i<= store.getDb().getPro().size()-1;i++)
        {
            b.add(store.getDb().getPro().get(i).getName());
        }
        Products.setItems(FXCollections.observableList(b));
    }
    @FXML
    private TextField Quantity;

    @FXML
    private ChoiceBox<String> Categories;

    @FXML
    private ListView<String> Products;

    @FXML
	public void Browse(MouseEvent e)
	{
    	
	}
    @FXML
	public void Back(MouseEvent e)
	{
    	
	}
    @FXML
	public void Add_pro_cart(MouseEvent e)
	{
    	
	}
    @FXML
	public void Check_Avai(MouseEvent e)
	{
    	
	}
	public void set(Customer a, Stage b, Store c)
    {
        customer =a;
        stage = b;
        store = c;
    }

}
