package GUI;

import Backend.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Customer_GUI {
    private Customer customer;

    @FXML
    private ChoiceBox Select_Store;

    @FXML
    public void View_Cart()
    {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("View_Cart.fxml"));
            Parent root = loader.load();

            View_Cart log=loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SuperStore");
            stage.show();

            log.set(customer,stage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    public void Remove_From_Cart()
    {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Remove_From_Cart.fxml"));
            Parent root = loader.load();

            View_Cart log=loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SuperStore");
            stage.show();

            log.set(customer,stage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    public void Check_Out()
    {

    }
    @FXML
    public void Login_Another()
    {

    }   
    @FXML
    public void Browse()
    {

    }
    public void set(Customer a)
    {
        a = customer;
    }
}

