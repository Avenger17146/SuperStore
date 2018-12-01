package Backend;

import java.io.*;

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

    public WarehouseAdmin(String ID, String password) {
        this.ID = ID;
        Password = password;
        try {
            DeserialiseList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
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
    }
}
