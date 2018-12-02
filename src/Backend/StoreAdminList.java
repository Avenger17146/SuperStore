package Backend;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *conatins list of all the store admins
 */
public class StoreAdminList implements Serializable {
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
    /**
     *conatins list of all the store admins
     */
    public void setStoreAdmins(ArrayList<StoreAdmin> StoreAdmins) {
        this.StoreAdmins = StoreAdmins;
    }

    /**
     *to check login initials
     */
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
