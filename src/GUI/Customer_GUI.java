package GUI;

import Backend.Customer;
import Backend.Store;
import Backend.SuperUser;
import Backend.WarehouseList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Customer_GUI {
    private Customer customer;
    private SuperUser su;
    @FXML
    private ChoiceBox<String> Select_Store;
    @FXML
    void initialize()
    {
        try {
            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream("SuperUser" + ".dat"));
            su = (SuperUser) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }
        ArrayList<String> a  = new ArrayList<String>();
        for ( int i = 0; i<= su.getSlist().getStores().size()-1; i++)
        {
            a.add(su.getSlist().getStores().get(i).getName());
            System.out.println(su.getSlist().getStores().get(i).getName()+"i");

        }
        Select_Store.setItems(FXCollections.observableList(a));



    }
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

            Remove_From_Cart log=loader.getController();
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
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Acknowledgement_Message.fxml"));
            Parent root = loader.load();
            int b = customer.checkOut();
            su.setSlist(customer.getSlist());
            ObjectOutputStream oStream = null;
            oStream = new ObjectOutputStream(new FileOutputStream("SuperUser" + ".dat"));
            oStream.writeObject(su);
            System.out.println("File saved");
            oStream.close();
            Acknowledgement_Message log=loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SuperStore");
            stage.show();

            log.set(b, stage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void Browse()
    {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("Customer_Browse.fxml"));
            Parent root = loader.load();

            Customer_Browse log=loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SuperStore");
            stage.show();
            Store store = customer.getSlist().getStores().get(Select_Store.getSelectionModel().getSelectedIndex());
            log.set(customer,stage, store);
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

