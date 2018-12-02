package GUI;

import Backend.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Remove_From_Cart {
	private Customer customer;
	private Stage stage;
	@FXML
	ChoiceBox<String>Select_Product;
	@FXML
	void ini()
	{
		ArrayList<String> a = new ArrayList<String>();
		
		for ( int i = 0; i<=customer.getCart().size()-1; i++)
			a.add(customer.getCart().get(i).getName());
		
		Select_Product.setItems(FXCollections.observableList(a));
		
		if(a.size()!=0)Select_Product.setValue(a.get(0));
	}
	
	@FXML
	public void Remove()
    {
		int i = Select_Product.getSelectionModel().getSelectedIndex();
		customer.getCart().remove(i);
		stage.close();
    }

    public void set(Customer a, Stage stage)
	{
		this.stage = stage;
		customer=a;
		ini();
	}
}