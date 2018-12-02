package GUI;

import Backend.Warehouse;
import Backend.WarehouseAdmin;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warehouse_Admin {
	@FXML
	ChoiceBox<Warehouse> Other;
	@FXML
	ChoiceBox<String> Choose;
	private WarehouseAdmin warehouseAdmin;
	@FXML
	CheckBox Pro,Sub,Cat;
	@FXML
    private void intialize()
    {
        List<String> s = Arrays.asList("  New  ", "  Update  ", "  Delete  ");
        Other.setItems(FXCollections.observableList(warehouseAdmin.getWlist().getWarehouses()));
        Choose.setItems(FXCollections.observableList(s));
    }
	
	@FXML
	public void own_data(MouseEvent e) {

		
	}
	
	@FXML
	public void Go(MouseEvent e) {
		
	}
	
	@FXML
	public void other_data(MouseEvent e) {	
	
	}
	@FXML
	public void log_out(MouseEvent e) {	
	
	}
	
	@FXML
	public void login_an(MouseEvent e) {	
	
	}

	public void startit(WarehouseAdmin authenticate) {
        warehouseAdmin = authenticate;
	}


	
}
