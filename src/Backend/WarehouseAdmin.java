package Backend;

import java.io.*;
/**
 *Class that defines the warehouse administrator
 */
public class WarehouseAdmin implements Serializable{
    private Warehouse warehouse;
    private String ID;
    private String Password;
    private WarehouseList Wlist;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public WarehouseList getWlist() {
        return Wlist;
    }

    public void setWlist(WarehouseList wlist) {
        Wlist = wlist;
    }
    /**
     *constructor
     */
    public WarehouseAdmin(String ID, String password, Warehouse W) {
        this.ID = ID;
        Password = password;
        warehouse = W;
        try {
            DeserialiseList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     *reading from file the list of warehouse admins
     */
    public void DeserialiseList() throws IOException
    {
        ObjectInputStream inputStream = null;

        try{
            inputStream = new ObjectInputStream(new FileInputStream("Warehouses"+".dat"));
            Wlist = (WarehouseList) inputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            inputStream.close();
        }
    }
    public String toString()
    {
        return ID;
    }
}
