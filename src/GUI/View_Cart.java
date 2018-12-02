package GUI;

import Backend.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class View_Cart {
	private Customer customer;
	private Stage stage;
	@FXML
	ListView<String> Cart;
	@FXML
    void initialize()
    {
        ArrayList<String> a = new ArrayList<String>();
        for ( int i = 0 ;i<= customer.getCart().size()-1; i++)
            a.add(customer.getCart().get(i).getName());
        Cart.setItems(FXCollections.observableList(a));
    }
	@FXML
	void Done(MouseEvent e) {
		stage.close();
	}
	public void set(Customer a , Stage stage)
	{
		this.stage = stage;
		customer = a;
	}
}
