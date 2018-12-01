package Backend;

import java.util.ArrayList;

public class StoreAdminList {
    private ArrayList<StoreAdmin> StoreAdmins;

    public StoreAdminList()
    {
        StoreAdmins = new ArrayList<StoreAdmin>();
    }

    public StoreAdminList(ArrayList<StoreAdmin> StoreAdmins) {
        this.StoreAdmins = StoreAdmins;
    }

    public ArrayList<StoreAdmin> getStoreAdmins() {
        return StoreAdmins;
    }

    public void setStoreAdmins(ArrayList<StoreAdmin> StoreAdmins) {
        this.StoreAdmins = StoreAdmins;
    }
}
