import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;

public class SuperUser implements Serializable {
    private static String ID = "admin";
    private static String Password = "admin";
    private WarehouseList Wlist;
    private StoreList Slist;

    public void SerialiseList() throws IOException
    {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream("Warehouses"+".dat"));
            oStream.writeObject(Wlist);
            System.out.println("File saved");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            oStream.close();
        }
        try {
            oStream = new ObjectOutputStream(new FileOutputStream("Stores"+".dat"));
            oStream.writeObject(Slist);
            System.out.println("File saved");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            oStream.close();
        }
    }
    public void DeserialiseList() throws IOException
    {
        ObjectInputStream inputStream = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("Warehoues"+".dat"));
            Wlist = (WarehouseList) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }
        try{
            inputStream = new ObjectInputStream(new FileInputStream("Stores"+".dat"));
            Slist = (StoreList) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }

    }

    public static String getID() {
        return ID;
    }

    public static String getPassword() {
        return Password;
    }


    public WarehouseList getWlist() {
        return Wlist;
    }

    public void setWlist(WarehouseList wlist) {
        Wlist = wlist;
    }

    public StoreList getSlist() {
        return Slist;
    }

    public void setSlist(StoreList slist) {
        Slist = slist;
    }

    public SuperUser()
    {
        try
        {
            DeserialiseList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
}
