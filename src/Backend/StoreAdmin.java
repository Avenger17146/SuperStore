package Backend;

import java.io.Serializable;

public class StoreAdmin implements Serializable {
    public String ID;
    private String password;
    private Store store;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreAdmin(String ID, String password) {
        this.ID = ID;
        this.password = password;
        //this.store = store;
    }
    public void send_request()
    {

    }
    public String toString()
    {
        return ID;
    }

}
