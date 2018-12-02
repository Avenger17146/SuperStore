package Backend;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *conatins list of all stores
 */
public class StoreList implements Serializable {
    private ArrayList<Store> stores;
    public StoreList()
    {
        stores = new ArrayList<Store>();
    }

    public StoreList(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }
}
