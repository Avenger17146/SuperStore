package GUI;

import Backend.Warehouse;
import Backend.WarehouseAdmin;
import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//import java.util.List;

public class Warehouse_Admin {
    private WarehouseAdmin warehouseAdmin;
	@FXML
	ChoiceBox<Warehouse> Other;
	@FXML
	ChoiceBox<String> Choose;
	
	@FXML
	CheckBox Pro,Sub,Cat;

	@FXML
	private void initialize()
    {
        String[] s = {"  New  ","  Update  ","  Delete  "};
        Other.setItems(FXCollections.observableList(warehouseAdmin.getWlist().getWarehouses()));
        Choose.setItems(FXCollections.observableArrayList(s));
    }


	@FXML
	public void own_data(MouseEvent e) {
        Stage stage = new Stage();
        if(Pro.isSelected()&& Choose.getValue().equalsIgnoreCase("new"));
        {
            try
            {
                Browse_Product b = new Browse_Product();
                b.send(warehouseAdmin, "new");

                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Browse_Product")), 600, 400));
            }
            catch(Exception f)
            {
                f.getMessage();
            }
        }
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
