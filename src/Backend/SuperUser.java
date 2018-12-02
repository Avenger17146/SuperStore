package Backend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;

public class SuperUser implements Serializable {
    private static String ID = "admin";
    private static String Password = "admin";
    private WarehouseList Wlist = new WarehouseList();
    private StoreList Slist = new StoreList();
    private WarehouseAdminList WAlist = new WarehouseAdminList();
    private StoreAdminList SAlist = new StoreAdminList();

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
       /* try
        {
            DeserialiseList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }*/
    }

    public void CreateStoreAdmin(String a, String b, Store s) {
        StoreAdmin admin = new StoreAdmin(a, b, s);
        SAlist.getStoreAdmins().add(admin);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void CreateWarehouseAdmin(String a, String b, Warehouse w) {
        WarehouseAdmin admin = new WarehouseAdmin(a, b, w);
        WAlist.getWarehouseAdmins().add(admin);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public void CreateStore(String a, String id) {
        Store w = new Store(a, id);
        Slist.getStores().add(w);
        try {
            SerialiseList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args)
    {
        SuperUser s = new SuperUser();

        s.CreateStore("Dhruv&bros.","8923");
        Store a  = s.getSlist().getStores().get(0);
        s.CreateStoreAdmin("Dhruv","8923",a);
        s.CreateWarehouse("Punjabi&co", "240");
        s.CreateWarehouseAdmin("RAwal","Jaybalvin",s.getWlist().getWarehouses().get(0));

        s.getSlist().getStores().get(0).setLinked(s.getWlist().getWarehouses().get(0));
        //Store a =  s.getSlist().getStores().get(0);
        try {
            System.out.println("here");
            s.getSlist().getStores().get(0).getDb().insert("phone>op", new Product("oneplus", 2, 34000, 8932, 5, 6, 6));
            System.out.println("here");
            s.getSlist().getStores().get(0).getDb().insert("electronics>home>alexa", new Product("alexa", 2, 34000, 1000, 5, 6, 6));
            s.SAlist.getStoreAdmins().get(0).setStore(s.getSlist().getStores().get(0));
            s.WAlist.getWarehouseAdmins().get(0).setWarehouse(s.Wlist.getWarehouses().get(0));
            s.Wlist.getWarehouses().get(0).getDb().insert("heelo>to>the>oher",new Product("side",23,23,2323,23,23,32));
            s.Wlist.getWarehouses().get(0).getDb().insert("blh",new Product("scjnzn",23,23,2878,23,23,32));
            Product dk = s.getSlist().getStores().get(0).getDb().search(8932);
            System.out.println(dk.getName());
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
