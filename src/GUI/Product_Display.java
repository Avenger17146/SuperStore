package GUI;

import Backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Product_Display  {
	@FXML
	private Label Name;
	
	@FXML
	private Label ID;

	@FXML
	private Label Price;
	
	@FXML
	private Label Quantity;
	
	@FXML
	private Label D;

	@FXML
	private Label H;
	
	@FXML
	private Label K;
	
	
	private Stage myStage;
	private Product myPro;
	
	@FXML
	public void Done()
    {
		myStage.close();
    }

	public void setPro(Product selPro) {
		myPro=selPro;
		setLabels();
	}

	private void setLabels() {
		Name.setText(myPro.getName());
		ID.setText((myPro.getID()));
		Price.setText(Integer.toString(myPro.getPrice()));
		Quantity.setText(Integer.toString(myPro.getQuantity()));
		D.setText(Integer.toString(myPro.getD()));
		H.setText(Integer.toString(myPro.getH()));
		K.setText(Integer.toString(myPro.getK()));
		
	}

	public void setSTAGE(Stage stage) {
		myStage=stage;
		
	}
}
