import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.Serializable;
import java.util.ArrayList;

public class SuperUser implements Serializable {
    private static String ID = "admin";
    private static String Password = "admin";
    private WarehouseList Wlist;
    private StoreList Slist;

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


    }
}
