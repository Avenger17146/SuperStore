package Backend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;
/**
 *class that defines the methods and functions of superuser
 */
public class SuperUser implements Serializable {
    public static void setID(String ID) {
        SuperUser.ID = ID;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public WarehouseAdminList getWAlist() {
        return WAlist;
    }

    public void setWAlist(WarehouseAdminList WAlist) {
        this.WAlist = WAlist;
    }

    public StoreAdminList getSAlist() {
        return SAlist;
    }

    public void setSAlist(StoreAdminList SAlist) {
        this.SAlist = SAlist;
    }

    private static String ID = "admin";
    private static String Password = "admin";
    private WarehouseList Wlist = new WarehouseList();
    private StoreList Slist = new StoreList();
    private WarehouseAdminList WAlist = new WarehouseAdminList();
    private StoreAdminList SAlist = new StoreAdminList();
    /**
     *for serialising all the files
     */
    public void SerialiseList() throws IOException {
        ObjectOutputStream oStream = null;

        try {
            oStream = new ObjectOutputStream(new FileOutputStream("Warehouses" + ".dat"));
            oStream.writeObject(Wlist);
            System.out.println("File saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            oStream.close();
        }
        try {
            oStream = new ObjectOutputStream(new FileOutputStream("Stores" + ".dat"));
            oStream.writeObject(Slist);
            System.out.println("File saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            oStream.close();
        }
        try {
            oStream = new ObjectOutputStream(new FileOutputStream("WarehouseAdminList" + ".dat"));
            oStream.writeObject(WAlist);
            System.out.println("File saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            oStream.close();
        }
        try {
            oStream = new ObjectOutputStream(new FileOutputStream("StoreAdminList" + ".dat"));
            oStream.writeObject(SAlist);
            System.out.println("File saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            oStream.close();
        }
    }
    /**
     *for deserialising all the files
     */
    public void DeserialiseList() throws IOException {
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("Warehouses" + ".dat"));
            Wlist = (WarehouseList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }
        try {
            inputStream = new ObjectInputStream(new FileInputStream("Stores" + ".dat"));
            Slist = (StoreList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }

        try {
            inputStream = new ObjectInputStream(new FileInputStream("WarehouseAdminList" + ".dat"));
            WAlist = (WarehouseAdminList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }

        try {
            inputStream = new ObjectInputStream(new FileInputStream("StoreAdminList" + ".dat"));
            SAlist = (StoreAdminList) inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
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

    public SuperUser() {
        try
        {
            DeserialiseList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     *for creating store admin
     */
    public Boolean CreateStoreAdmin(String a, String b, Store s) {
        for (int i = 0 ; i <= SAlist.getStoreAdmins().size() -1 ; i++)
        {
            if (SAlist.getStoreAdmins().get(i).getID().equals(a))
            {
                System.out.println("ID alreday exists");
                return false;
            }
        }
        StoreAdmin admin = new StoreAdmin(a, b, s);
        SAlist.getStoreAdmins().add(admin);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    /**
     *for creating warehouse admin
     */
    public Boolean CreateWarehouseAdmin(String a, String b, Warehouse w) {
        for (int i = 0 ; i <= WAlist.getWarehouseAdmins().size() -1 ; i++)
        {
            if (WAlist.getWarehouseAdmins().get(i).getID().equals(a))
            {
                System.out.println("ID alreday exists");
                return false;
            }
        }
        WarehouseAdmin admin = new WarehouseAdmin(a, b, w);
        WAlist.getWarehouseAdmins().add(admin);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void Link(Warehouse a, Store b) {
        b.setLinked(a);
    }

    public void CreateWarehouse(String a, String id) {
        Warehouse w = new Warehouse(a, id);
        Wlist.getWarehouses().add(w);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     *for creating store
     */
    public void CreateStore(String a, String id) {
        Store w = new Store(a, id);
        Slist.getStores().add(w);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *creating files for test run
     */
    public static void main(String[] args)
    {
        SuperUser s = new SuperUser();

        s.CreateStore("Dhruv&bros.","8923");
        Store a  = s.getSlist().getStores().get(0);
        s.CreateStoreAdmin("Dhruv","8923",a);
        s.CreateWarehouse("Punjabi&co", "240");
        s.CreateWarehouseAdmin("RAwal","Jaybalvin",s.getWlist().getWarehouses().get(0));
        s.CreateWarehouse("daBset", "249");
        s.CreateWarehouseAdmin("wa1","qwerty",s.getWlist().getWarehouses().get(1));
        s.CreateStore("daBest","89");
        a  = s.getSlist().getStores().get(1);
        s.CreateStoreAdmin("Dhruv","8923",a);


        s.getSlist().getStores().get(0).setLinked(s.getWlist().getWarehouses().get(0));
        //Store a =  s.getSlist().getStores().get(0);
        try {
            System.out.println("here");
            s.getSlist().getStores().get(0).getDb().insert("phone>op", new Product("oneplus", "2", "34000",  "5", "6", "6"));
            s.getSlist().getStores().get(0).getDb().insert("electronics>home>alexa", new Product("alexa", "2", "34000", "5", "6", "6"));
            s.SAlist.getStoreAdmins().get(0).setStore(s.getSlist().getStores().get(0));
            s.getSlist().getStores().get(1).getDb().insert("phone>op", new Product("huwaie", "2", "34000",  "5", "6", "6"));
            s.getSlist().getStores().get(1).getDb().insert("electronics>home>assistant", new Product("alexa", "2", "34000", "5", "6", "6"));

            s.WAlist.getWarehouseAdmins().get(0).setWarehouse(s.Wlist.getWarehouses().get(0));
            s.Wlist.getWarehouses().get(0).getDb().insert("hello>to>the>other",new Product("side","23","23","23","23","32"));
            s.Wlist.getWarehouses().get(0).getDb().insert("screens",new Product("screen","23","23","23","23","32"));
            /*Product dk = s.getSlist().getStores().get(0).getDb().search(8932);
            System.out.println(dk.getName());*/
            s.Wlist.getWarehouses().get(1).getDb().insert("ca>u>hear>me",new Product("alone","23","23","23","23","32"));
            s.Wlist.getWarehouses().get(1).getDb().insert("football>cosco",new Product("big_football","23","23","23","23","32"));

            s.SerialiseList();
            ObjectOutputStream oStream = null;

            try {
                oStream = new ObjectOutputStream(new FileOutputStream("SuperUser"+".dat"));
                oStream.writeObject(s);
                System.out.println("File saved");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("donr");
                oStream.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
