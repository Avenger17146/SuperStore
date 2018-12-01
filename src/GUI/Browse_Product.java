package GUI;

import Backend.WarehouseAdmin;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Browse_Product {
    private  WarehouseAdmin warehouseAdmin;
	
	@FXML
	private ChoiceBox Select_Category;
	
	@FXML
	private ChoiceBox Product;

	@FXML
    public void Select_Product()
    {

    }
    @FXML
    public void Browse()
    {

    }
	public void send(WarehouseAdmin warehouseAdmin, String a)
    {
        this.warehouseAdmin = warehouseAdmin;
    }
}
