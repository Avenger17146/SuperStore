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


    public StoreAdmin authenticate(String a, String b)
    {
        for ( int i = 0; i<= StoreAdmins.size()-1; i++)
        {
            if (StoreAdmins.get(i).getID().equals(a)&&StoreAdmins.get(i).getPassword().equals(b))
                return StoreAdmins.get(i);
        }
        return null;
    }
}
