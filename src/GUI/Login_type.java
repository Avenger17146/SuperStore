package GUI;

import javafx.collections.ObservableList;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Login_type implements Initializable {
	
	@FXML
	private Label Display;
	
	@FXML
	private ImageView imvi;
	
	@FXML
	private ChoiceBox<String> Type;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{

		File file = new File("src/DJSTORE.jpg");
        Image image = new Image(file.toURI().toString());
        imvi.setImage(image);

		List<String> Names = Arrays.asList(" Super User ", " Warehouse Admin ", " Store Admin"," Guest User");
		ObservableList<String> availableChoices = FXCollections.observableArrayList(Names); 
		Type.setItems(availableChoices);
		
		Type.setValue(" Super User ");
	}

	
	@FXML
    public void Select(MouseEvent e)
    {

	 try 
		{
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        
        Login log=loader.getController();

		int n=Type.getSelectionModel().getSelectedIndex();
        log.startit(n);
        
		
		if(n==0) {
			System.out.println("Super User");
			Display.setText("Super User");
		}
		if(n==1) {
			System.out.println("WA");
			Display.setText("Warehouse Admin");
		}
		if(n==2) {
			System.out.println("SA");
			Display.setText("Store Admin");
		}
		if(n==3) {
			System.out.println("Guest User");
			Display.setText("Guest User");
		}
		
		
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.setTitle("SuperStore");
	    stage.show();
	    
		} catch (Exception ex) {
		    System.err.println(ex);
		}
		  
		 
    }
}
