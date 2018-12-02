package GUI;

import Backend.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Customer_Login {
	private Customer customer;
	@FXML
	TextField Estimated_Budget;
	
    @FXML
    public void Submit()
    {
        customer.addFunds(Integer.parseInt(Estimated_Budget.getText()));
        try
        {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Custome_GUI.fxml"));
            Parent root = loader.load();

            Customer_GUI log=loader.getController();
            //log.set(customer);
            Stage stage = new Stage();
            stage.setScene(new Scene(root,600,600));
            stage.setTitle("SuperStore");
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void set(Customer a)
    {
        customer =a;
    }


}
