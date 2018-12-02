package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Backend.Category;
import Backend.Database;
import Backend.Product;
import Backend.SuperUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Update_Product {

	@FXML
	private TextField Name;

	@FXML
	private TextField Price;
	
	@FXML
	private TextField Quantity;
	
	@FXML
	private TextField D;

	@FXML
	private TextField H;
	
	@FXML
	private TextField K;

	private SuperUser mySU;

	private Database myDB;

	private Stage myStage;

	private Category Cat;
	

	private Product pro;
	
	@FXML
	public void Update()
    {
		Product p= new Product(Name.getText(),Quantity.getText(),Price.getText(),
				H.getText(),D.getText(),K.getText());
		
		if(Cat==null && pro!=null)
		{
			myDB.modify(pro, p);
		}
		else if(Cat!=null && pro==null)
		{
		Cat.getpList().add(p);
		myDB.getPro().add(p);
		}
		
		SERIALALL();
		myStage.close();

    }
	public void setWare(SuperUser mySU, Database myDB, Stage stage, Category selCat,Product p) {
		this.mySU=mySU;
		this.myDB=myDB;
		this.myStage=stage;
		this.Cat=selCat;
		this.pro=p;
	}
	public void SERIALALL() {
		try 
    	{
	    	ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream("SuperUser"+".dat"));
			mySU.SerialiseList();
            oStream.writeObject(mySU);
            System.out.println("File saved");   
    		oStream.close();
			
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}		
	}
	
}
