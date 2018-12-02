package Backend;

import java.io.Serializable;
/**
 *defines methods and data members of store admins
 */
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
    /**
     *constructor
     */
    public StoreAdmin(String ID, String password, Store s) {
        this.ID = ID;
        this.password = password;
        store = s;
        //this.store = store;
    }
    /**
     *to send request when quantity of a product reaches 0
     */
    public void send_request()
    {
        for ( int i = 0; i<= store.getDb().getPro().size()-1; i++)
        {

        }
    }
    public String toString()
    {
        return ID;
    }

}
