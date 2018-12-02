package GUI;

import java.awt.TextField;

import Backend.Customer;
import Backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class Check_warehouse_data {

	private Stage mystage;
	private Customer Cus;
	private Product Pro;
	
	@FXML
	private TextField Q;
	
	@FXML
    public void Display()
    {
		Cus.addProduct(Pro, Integer.parseInt(Q.getText()));
		mystage.close();
    }
	
	public void lelo(Customer myCus, Product selPro, Stage stage) {
		mystage=stage;
		Cus=myCus;
		Pro=selPro;
	}
}
